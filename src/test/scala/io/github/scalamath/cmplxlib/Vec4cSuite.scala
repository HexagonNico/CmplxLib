package io.github.scalamath.cmplxlib

import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Vec4d
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec4cSuite extends AnyFunSuite {

  implicit val vectorEquality: Equality[Vec4c] = (a: Vec4c, b: Any) => b match {
    case b: Vec4c => a ~= b
    case _ => false
  }

  implicit val numberEquality: Equality[Complex] = (a: Complex, b: Any) => b match {
    case b: Complex => a ~= b
    case _ => false
  }

  test("Construct from Vec3c and w") {
    val a = Vec3c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I)
    val b = Vec4c(a, 4.0 * I)
    val res = Vec4c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I, 4.0 * I)
    assert(b == res)
  }

  test("Construct from Vec2c, z, and w") {
    val a = Vec2c(1.0 + I, 2.0 + 3.0 * I)
    val b = Vec4c(a, 3.0 + 2.0 * I, 4.0 * I)
    val res = Vec4c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I, 4.0 * I)
    assert(b == res)
  }

  test("Access xyz components") {
    val a = Vec4c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I, 4.0 * I)
    val b = Vec3c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I)
    assert(a.xyz == b)
  }

  test("Access xy components") {
    val a = Vec4c(1.0 + I, 2.0 + 3.0 * I, 3.0 + 2.0 * I, 4.0 * I)
    val b = Vec2c(1.0 + I, 2.0 + 3.0 * I)
    assert(a.xy == b)
  }

  test("Sum of a vector and four values") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = a + (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(3.0 + 4.5 * I, 4.5 + 1.5 * I, 1.5 + 3.0 * I, 7.0 + 5.5 * I)
    assert(b === res)
  }

  test("Sum of two vectors") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = Vec4c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(3.0 + 4.5 * I, 4.5 + 1.5 * I, 1.5 + 3.0 * I, 7.0 + 5.5 * I)
    assert(a + b === res)
  }

  test("Unary plus") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    assert(+vec == vec)
  }

  test("Subtraction of four values from a vector") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = a - (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(-1.0 - 0.5 * I, -1.5 + 0.5 * I, -0.5 + 0.0 * I, -1.0 - 1.5 * I)
    assert(b === res)
  }

  test("Subtraction of two vectors") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = Vec4c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(-1.0 - 0.5 * I, -1.5 + 0.5 * I, -0.5 + 0.0 * I, -1.0 - 1.5 * I)
    assert(a - b === res)
  }

  test("Unary minus") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val res = Vec4c(-1.0 - 2.0 * I, -1.5 - I, -0.5 - 1.5 * I, -3.0 - 2.0 * I)
    assert(-vec == res)
  }

  test("Component-wise multiplication of a vector and four values") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = a * (2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(-3.0 + 6.5 * I, 4.0 + 3.75 * I, -1.75 + 2.25 * I, 5.0 + 18.5 * I)
    assert(b === res)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = Vec4c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = Vec4c(-3.0 + 6.5 * I, 4.0 + 3.75 * I, -1.75 + 2.25 * I, 5.0 + 18.5 * I)
    assert(a * b == res)
  }

  test("Vector multiplied by a complex number") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val z = 1.5 + I
    val res = Vec4c(-0.5 + 4.0 * I, 1.25 + 3.0 * I, -0.75 + 2.75 * I, 2.5 + 6.0 * I)
    assert(vec * z === res)
  }

  test("Vector multiplied by a complex number commutativity") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val z = 1.5 + I
    val res = Vec4c(-0.5 + 4.0 * I, 1.25 + 3.0 * I, -0.75 + 2.75 * I, 2.5 + 6.0 * I)
    assert(z * vec === res)
  }

  test("Vector multiplied by a real number") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val res = Vec4c(1.5 + 3.0 * I, 2.25 + 1.5 * I, 0.75 + 2.25 * I, 4.5 + 3.0 * I)
    assert(vec * 1.5 === res)
  }

  test("Vector multiplied by a real number commutativity") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val res = Vec4c(1.5 + 3.0 * I, 2.25 + 1.5 * I, 0.75 + 2.25 * I, 4.5 + 3.0 * I)
    assert(1.5 * vec === res)
  }

  test("Component-wise division of two vectors") {
    val a = Vec4c(8.0 + 6.0 * I, 6.0 + 8.0 * I, 1.0 + 2.0 * I, 2.0)
    val b = Vec4c(2.0 + 2.0 * I, 4.0 + 2.0 * I, 2.0 + 4.0 * I, 2.0 + 2.0 * I)
    val res = Vec4c(3.5 - 0.5 * I, 2.0 + I, 0.5 + 0.0 * I, 0.5 - 0.5 * I)
    assert(a / b === res)
  }

  test("Component-wise division of a vector and four values") {
    val a = Vec4c(8.0 + 6.0 * I, 6.0 + 8.0 * I, 1.0 + 2.0 * I, 2.0)
    val b = a / (2.0 + 2.0 * I, 4.0 + 2.0 * I, 2.0 + 4.0 * I, 2.0 + 2.0 * I)
    val res = Vec4c(3.5 - 0.5 * I, 2.0 + I, 0.5 + 0.0 * I, 0.5 - 0.5 * I)
    assert(b === res)
  }

  test("Vector divided by a complex number") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val res = Vec4c(Complex(3.0 / 2.0, 0.5), 1.25 - 0.25 * I, 1.0 + 0.5 * I, 2.5 - 0.5 * I)
    assert(vec / (1.0 + I) === res)
  }

  test("Vector divided by a real number") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val res = Vec4c(0.5 + I, 0.75 + 0.5 * I, 0.25 + 0.75 * I, 1.5 + I)
    assert(vec / 2.0 === res)
  }

  test("Inverse of a vector") {
    val vec = Vec4c(2.0 + I, 2.0 + I, 2.0 + I, 2.0 + I)
    val res = Vec4c(0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(vec.inverse === res)
  }

  test("Inverse of a vector using division") {
    val vec = Vec4c(2.0 + I, 2.0 + I, 2.0 + I, 2.0 + I)
    val res = Vec4c(0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(1.0 / vec === res)
  }

  test("Conjugate of a vector") {
    val vec = Vec4c(2.0 + 4.0 * I, 8.0 + 6.0 * I, 1.0 + 2.0 * I, 2.0 - 4.0 * I)
    val res = Vec4c(2.0 - 4.0 * I, 8.0 - 6.0 * I, 1.0 - 2.0 * I, 2.0 + 4.0 * I)
    assert(vec.conjugate == res)
  }

  test("Dot product with four values") {
    val vec = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val dot = vec.dot(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = 33.75 + 2.0 * I
    assert(dot === res)
  }

  test("Dot product of two vectors") {
    val a = Vec4c(1.0 + 2.0 * I, 1.5 + I, 0.5 + 1.5 * I, 3.0 + 2.0 * I)
    val b = Vec4c(2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 1.5 * I, 4.0 + 3.5 * I)
    val res = 33.75 + 2.0 * I
    assert((a dot b) === res)
  }

  test("Length squared") {
    val res = Vec4c(1.0 + I, 1.0 + I, 1.0 + I, 1.0 + I)
    assert(res.lengthSquared == 8.0)
  }

  test("Length") {
    val res = Vec4c(1.0 + I, 1.0 + I, 1.0 + I, 1.0 + I)
    assert(res.length == math.sqrt(8.0))
  }

  test("Normalized vector") {
    val vec = Vec4c(1.0 + I, 1.0 + I, 1.0 + I, 1.0 + I)
    val sqrt = 1.0 / (2.0 * math.sqrt(2.0))
    val res = Vec4c(sqrt + I * sqrt, sqrt + I * sqrt, sqrt + I * sqrt, sqrt + I * sqrt)
    assert(vec.normalized === res)
  }

  test("Vector is normalized") {
    val a = Vec4c(1.0 + I, 1.0 + I, 1.0 + I, 1.0 + I)
    val sqrt = 1.0 / (2.0 * math.sqrt(2.0))
    val b = Vec4c(sqrt + I * sqrt, sqrt + I * sqrt, sqrt + I * sqrt, sqrt + I * sqrt)
    assert(!a.isNormalized)
    assert(b.isNormalized)
  }

  ignore("Limit length of a vector") {
    // TODO
  }

  test("Vector absolute value") {
    val vec = Vec4c(1.0 + I, 1.0 + I, 2.0 * I, 3.0 + 4.0 * I)
    val res = Vec4d(math.sqrt(2.0), math.sqrt(2.0), 2.0, 5.0)
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

  ignore("Direction to four values") {
    // TODO
  }

  ignore("Distance squared to vector") {
    // TODO
  }

  ignore("Distance squared to four values") {
    // TODO
  }

  ignore("Distance to vector") {
    // TODO
  }

  ignore("Distance to four values") {
    // TODO
  }

  test("Angle between two vectors") {
    val a = Vec4c(1.0 + I, 2.0 + I, 3.0 + 2.0 * I, 1.0 + I)
    val b = Vec4c(2.0 + I, 1.0 + I, 2.0 + 3.0 * I, 1.0 - I)
    assert(a.angleTo(b) === math.acos(9.0 / 11.0) +- 1e-9)
  }

  test("Angle between two vectors with four values") {
    val vec = Vec4c(1.0 + I, 2.0 + I, 3.0 + 2.0 * I, 1.0 + I)
    val angle = vec.angleTo(2.0 + I, 1.0 + I, 2.0 + 3.0 * I, 1.0 - I)
    assert(angle === math.acos(9.0 / 11.0) +- 1e-9)
  }

  ignore("Project vector onto another") {
    // TODO
  }

  ignore("Project vector onto four values") {
    // TODO
  }

  ignore("Reflect vector") {
    // TODO
  }

  ignore("Reflect vector by four values") {
    // TODO
  }

  ignore("Bounce vector") {
    // TODO
  }

  ignore("Bounce vector by four values") {
    // TODO
  }

  ignore("Slide vector") {
    // TODO
  }

  ignore("Slide vector by four values") {
    // TODO
  }

  ignore("Outer product with four values") {
    // TODO
  }

  ignore("Outer product with a 4D vector") {
    // TODO
  }

  test("Vector equals four values") {
    val vec = Vec4c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I)
    assert(vec == (1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I))
  }

  test("Vector equals approximately four values") {
    val vec = Vec4c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I, 1.00000001 + I, 0.99999999 * I)
    assert(vec ~= (1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I))
  }

  test("Vector equals approximately another vector") {
    val a = Vec4c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I, 1.00000001 + I, 0.99999999 * I)
    val b = Vec4c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I)
    assert(a ~= b)
  }

  test("Access component using index") {
    val vec = Vec4c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I)
    assert(vec(0) == 1.0 + 2.0 * I)
    assert(vec(1) == 3.0 + 2.0 * I)
    assert(vec(2) == 1.0 + I)
    assert(vec(3) == I)
    assertThrows[MatchError] {vec(4)}
  }

  test("Get the real part of a vector") {
    val vec = Vec4c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I)
    val real = Vec4d(1.0, 3.0, 1.0, 0.0)
    assert(vec.real == real)
  }

  test("Get the imaginary part of a vector") {
    val vec = Vec4c(1.0 + 2.0 * I, 3.0 + 2.0 * I, 1.0 + I, I)
    val img = Vec4d(2.0, 2.0, 1.0, 1.0)
    assert(vec.imaginary == img)
  }
}
