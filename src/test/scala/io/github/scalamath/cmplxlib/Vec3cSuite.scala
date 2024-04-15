package io.github.scalamath.cmplxlib

import io.github.scalamath
import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Vec3d
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec3cSuite extends AnyFunSuite {

  implicit val vectorEquality: Equality[Vec3c] = (a: Vec3c, b: Any) => b match {
    case b: Vec3c => a ~= b
    case _ => false
  }

  implicit val numberEquality: Equality[Complex] = (a: Complex, b: Any) => b match {
    case b: Complex => a ~= b
    case _ => false
  }

  test("Construct from Vec2c and z") {
    val a = Vec2c(1.0 + I, 2.0 + 3.0 * I)
    val b = Vec3c(a, 3.0 + 2.0 * I)
    val res = Vec3c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I)
    assert(b == res)
  }

  test("Access xy components") {
    val a = Vec3c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I)
    val b = Vec2c(1.0 + I, 2.0 + 3.0 * I)
    assert(a.xy == b)
  }

  test("Sum of a vector and three values") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = a + (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(3.0 + 4.5 * I, 4.5 + 1.5 * I, 1.5 + 3.0 * I)
    assert(b === res)
  }

  test("Sum of two vectors") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = Vec3c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(3.0 + 4.5 * I, 4.5 + 1.5 * I, 1.5 + 3.0 * I)
    assert(a + b === res)
  }

  test("Unary plus") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    assert(+vec == vec)
  }

  test("Subtraction of three values from a vector") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = a - (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(-1.0 - 0.5 * I, -1.5 + 0.5 * I, -0.5)
    assert(b === res)
  }

  test("Subtraction of two vectors") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = Vec3c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(-1.0 - 0.5 * I, -1.5 + 0.5 * I, -0.5)
    assert(a - b === res)
  }

  test("Unary minus") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val res = Vec3c(-1.0 - 2.0 * I, -1.5 - I, -0.5 - 1.5 * I)
    assert(-vec == res)
  }

  test("Component-wise multiplication of a vector and three values") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = a * (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(-3.0 + 6.5 * I, 4.0 + 3.75 * I, -1.75 + 2.25 * I)
    assert(b === res)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = Vec3c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = Vec3c(-3.0 + 6.5 * I, 4.0 + 3.75 * I, -1.75 + 2.25 * I)
    assert(a * b === res)
  }

  test("Vector multiplied by a complex number") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 1.0 + I)
    val z = 1.5 + I
    val res = Vec3c(-0.5 + 4.0 * I, 1.25 + 3.0 * I, 0.5 + 2.5 * I)
    assert(vec * z === res)
  }

  test("Vector multiplied by a complex number commutativity") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 1.0 + I)
    val z = 1.5 + I
    val res = Vec3c(-0.5 + 4.0 * I, 1.25 + 3.0 * I, 0.5 + 2.5 * I)
    assert(z * vec === res)
  }

  test("Vector multiplied by a real number") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val res = Vec3c(1.5 + 3.0 * I, 2.25 + 1.5 * I, 0.75 + 2.25 * I)
    assert(vec * 1.5 === res)
  }

  test("Vector multiplied by a real number commutativity") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val res = Vec3c(1.5 + 3.0 * I, 2.25 + 1.5 * I, 0.75 + 2.25 * I)
    assert(1.5 * vec === res)
  }

  test("Component-wise division of two vectors") {
    val a = Vec3c(8.0 + 6.0 * I, 6.0 + 8.0 * I, 1.0 + 2.0 * I)
    val b = Vec3c(2.0 + 2.0 * I, 4.0 + 2.0 * I, 2.0 + 4.0 * I)
    val res = Vec3c(3.5 - 0.5 * I, 2.0 + I, 0.5)
    assert(a / b == res)
  }

  test("Component-wise division of a vector and three values") {
    val a = Vec3c(8.0 + 6.0 * I, 6.0 + 8.0 * I, 1.0 + 2.0 * I)
    val b = a / (2.0 + 2.0 * I, 4.0 + 2.0 * I, 2.0 + 4.0 * I)
    val res = Vec3c(3.5 - 0.5 * I, 2.0 + I, 0.5)
    assert(b === res)
  }

  test("Vector divided by a complex number") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val res = Vec3c(Complex(3.0 / 2.0, 0.5), 1.25 - 0.25 * I, 1.0 + 0.5 * I)
    assert(vec / (1.0 + I) === res)
  }

  test("Vector divided by a real number") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val res = Vec3c(0.5 + I, 0.75 + 0.5 * I, 0.25 + 0.75 * I)
    assert(vec / 2.0 === res)
  }

  test("Inverse of a vector") {
    val vec = Vec3c(2.0 + I, 2.0 + I, 2.0 + I)
    val res = Vec3c(0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(vec.inverse === res)
  }

  test("Inverse of a vector using division") {
    val vec = Vec3c(2.0 + I, 2.0 + I, 2.0 + I)
    val res = Vec3c(0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(1.0 / vec === res)
  }

  test("Conjugate of a vector") {
    val vec = Vec3c(2.0 + 4.0 * I, 8.0 + 6.0 * I, 1.0 + 2.0 * I)
    val res = Vec3c(2.0 - 4.0 * I, 8.0 - 6.0 * I, 1.0 - 2.0 * I)
    assert(vec.conjugate == res)
  }

  test("Dot product with three values") {
    val vec = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val dot = vec.dot(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = 14.75 + 4.5 * I
    assert(dot === res)
  }

  test("Dot product of two vectors") {
    val a = Vec3c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I)
    val b = Vec3c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I)
    val res = 14.75 + 4.5 * I
    assert((a dot b) === res)
  }

  ignore("Cross product with three values") {
    // TODO
  }

  ignore("Cross product with a 3D vector") {
    // TODO
  }

  ignore("Cross product with a 2D vector") {
    // TODO
  }

  test("Length squared") {
    val res = Vec3c(1.0 + I, 1.0 + I, 2.0 + I)
    assert(res.lengthSquared == 9.0)
  }

  test("Length") {
    val res = Vec3c(1.0 + I, 1.0 + I, 2.0 + I)
    assert(res.length == 3.0)
  }

  test("Normalized vector") {
    val vec = Vec3c(1.0 + I, 1.0 + I, 2.0 + I)
    val res = Vec3c((1.0 + I) / 3.0, (1.0 + I) / 3.0, (2.0 + I) / 3.0)
    assert(vec.normalized === res)
  }

  test("Vector is normalized") {
    val a = Vec3c(1.0 + I, 1.0 + I, 2.0 + I)
    val b = Vec3c((1.0 + I) / 3.0, (1.0 + I) / 3.0, (2.0 + I) / 3.0)
    assert(!a.isNormalized)
    assert(b.isNormalized)
  }

  test("Limit length of a vector") {
    val vec = Vec3c(1.0 + 2.0 * I, 3.0 + 4.0 * I, 5.0 + 6.0 * I)
    assert(vec.limitLength(3.0).length === 3.0 +- scalamath.Epsilon)
  }

  test("Vector absolute value") {
    val vec = Vec3c(1.0 + I, 1.0 + I, 2.0 * I)
    val res = Vec3d(math.sqrt(2.0), math.sqrt(2.0), 2.0)
    assert(vec.abs == res)
  }

  ignore("Move vector toward another") {
    // TODO
  }

  ignore("Vector lerp") {
    // TODO
  }

  ignore("Direction to vector") {
    // TODO
  }

  ignore("Direction to three values") {
    // TODO
  }

  ignore("Distance squared to vector") {
    // TODO
  }

  ignore("Distance squared to three values") {
    // TODO
  }

  ignore("Distance to vector") {
    // TODO
  }

  ignore("Distance to three values") {
    // TODO
  }

  test("Angle between two vectors") {
    val a = Vec3c(1.0 + I, 2.0 + I, 3.0 + 2.0 * I)
    val b = Vec3c(2.0 + I, 1.0 + I, 2.0 + 3.0 * I)
    assert(a.angleTo(b) === math.acos(9.0 / 10.0) +- 1e-9)
  }

  test("Angle between two vectors with three values") {
    val vec = Vec3c(1.0 + I, 2.0 + I, 3.0 + 2.0 * I)
    val angle = vec.angleTo(2.0 + I, 1.0 + I, 2.0 + 3.0 * I)
    assert(angle === math.acos(9.0 / 10.0) +- 1e-9)
  }

  ignore("Project vector onto another") {
    // TODO
  }

  ignore("Project vector onto three values") {
    // TODO
  }

  ignore("Reflect vector") {
    // TODO
  }

  ignore("Reflect vector by three values") {
    // TODO
  }

  ignore("Bounce vector") {
    // TODO
  }

  ignore("Bounce vector by three values") {
    // TODO
  }

  ignore("Slide vector") {
    // TODO
  }

  ignore("Slide vector by three values") {
    // TODO
  }

  ignore("Outer product with three values") {
    // TODO
  }

  ignore("Outer product with a 3D vector") {
    // TODO
  }

  ignore("Outer product with four values") {
    // TODO
  }

  ignore("Outer product with a 4D vector") {
    // TODO
  }

  test("Vector equals three values") {
    val vec = Vec3c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I)
    assert(vec == (1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I))
  }

  test("Vector equals approximately three values") {
    val vec = Vec3c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I, 1.00000001 + I)
    assert(vec ~= (1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I))
  }

  test("Vector equals approximately another vector") {
    val a = Vec3c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I, 1.00000001 + I)
    val b = Vec3c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I)
    assert(a ~= b)
  }

  test("Access component using index") {
    val vec = Vec3c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I)
    assert(vec(0) == 1.0 + 2.0 * I)
    assert(vec(1) == 3.0 + 2.0 * I)
    assert(vec(2) == 1.0 + I)
    assertThrows[MatchError] {vec(3)}
  }

  test("Get the real part of a vector") {
    val vec = Vec3c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I)
    val real = Vec3d(1.0, 3.0, 1.0)
    assert(vec.real == real)
  }

  test("Get the imaginary part of a vector") {
    val vec = Vec3c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I)
    val img = Vec3d(2.0, 2.0, 1.0)
    assert(vec.imaginary == img)
  }
}
