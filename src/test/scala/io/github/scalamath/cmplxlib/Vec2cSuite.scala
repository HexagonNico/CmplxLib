package io.github.scalamath.cmplxlib

import io.github.scalamath
import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Vec2d
import org.scalactic.Equality
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec2cSuite extends AnyFunSuite {

  implicit val vectorEquality: Equality[Vec2c] = (a: Vec2c, b: Any) => b match {
    case b: Vec2c => a ~= b
    case _ => false
  }

  implicit val numberEquality: Equality[Complex] = (a: Complex, b: Any) => b match {
    case b: Complex => a ~= b
    case _ => false
  }

  test("Sum of a vector and two values") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = a + (2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(3.0 + 4.5 * I, 4.5 + 1.5 * I)
    assert(b === res)
  }

  test("Sum of two vectors") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = Vec2c(2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(3.0 + 4.5 * I, 4.5 + 1.5 * I)
    assert(a + b === res)
  }

  test("Unary plus") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    assert(+vec == vec)
  }

  test("Subtraction of two values from a vector") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = a - (2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(-1.0 - 0.5 * I, -1.5 + 0.5 * I)
    assert(b === res)
  }

  test("Subtraction of two vectors") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = Vec2c(2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(-1.0 - 0.5 * I, -1.5 + 0.5 * I)
    assert(a - b === res)
  }

  test("Unary minus") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val res = Vec2c(-1.0 - 2.0 * I, -1.5 - I)
    assert(-vec == res)
  }

  test("Component-wise multiplication of a vector and two values") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = a * (2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(-3.0 + 6.5 * I, 4.0 + 3.75 * I)
    assert(b === res)
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = Vec2c(2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = Vec2c(-3.0 + 6.5 * I, 4.0 + 3.75 * I)
    assert(a * b === res)
  }

  test("Vector multiplied by a complex number") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val z = 1.5 + I
    val res = Vec2c(-0.5 + 4.0 * I, 1.25 + 3.0 * I)
    assert(vec * z === res)
  }

  test("Vector multiplied by a complex number commutativity") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val z = 1.5 + I
    val res = Vec2c(-0.5 + 4.0 * I, 1.25 + 3.0 * I)
    assert(z * vec === res)
  }

  test("Vector multiplied by a real number") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val res = Vec2c(1.5 + 3.0 * I, 2.25 + 1.5 * I)
    assert(vec * 1.5 === res)
  }

  test("Vector multiplied by a real number commutativity") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val res = Vec2c(1.5 + 3.0 * I, 2.25 + 1.5 * I)
    assert(1.5 * vec === res)
  }

  test("Component-wise division of a vector and two values") {
    val a = Vec2c(8.0 + 6.0 * I, 6.0 + 8.0 * I)
    val b = a / (2.0 + 2.0 * I, 4.0 + 2.0 * I)
    val res = Vec2c(3.5 - 0.5 * I, 2.0 + I)
    assert(b === res)
  }

  test("Component-wise division of two vectors") {
    val a = Vec2c(8.0 + 6.0 * I, 6.0 + 8.0 * I)
    val b = Vec2c(2.0 + 2.0 * I, 4.0 + 2.0 * I)
    val res = Vec2c(3.5 - 0.5 * I, 2.0 + I)
    assert(a / b === res)
  }

  test("Vector divided by a complex number") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val b = a / (1.0 + I)
    val res = Vec2c(3.0 / 2.0 + 0.5 * I, 1.25 - 0.25 * I)
    assert(b === res)
  }

  test("Vector divided by a real number") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val res = Vec2c(0.5 + I, 0.75 + 0.5 * I)
    assert(vec / 2.0 === res)
  }

  test("Inverse of a vector") {
    val vec = Vec2c(2.0 + I, 2.0 + I)
    val res = Vec2c(0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(vec.inverse === res)
  }

  test("Inverse of a vector using division") {
    val vec = Vec2c(2.0 + I, 2.0 + I)
    val res = Vec2c(0.4 - 0.2 * I, 0.4 - 0.2 * I)
    assert(1.0 / vec === res)
  }

  test("Conjugate of a vector") {
    val vec = Vec2c(2.0 + 4.0 * I, 8.0 + 6.0 * I)
    val res = Vec2c(2.0 - 4.0 * I, 8.0 - 6.0 * I)
    assert(vec.conjugate == res)
  }

  test("Dot product with two values") {
    val vec = Vec2c(1.0 + 2.0 * I, 1.5 + 1.0 * I)
    val dot = vec.dot(2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = 12.0 + 3.75 * I
    assert(dot === res)
  }

  test("Dot product of two vectors") {
    val a = Vec2c(1.0 + 2.0 * I, 1.5 + 1.0 * I)
    val b = Vec2c(2.0 + 2.5 * I, 3.0 + 0.5 * I)
    val res = 12.0 + 3.75 * I
    assert((a dot b) === res)
  }

  test("Length squared") {
    val vec = Vec2c(1.0 + I, 1.0 + I)
    assert(vec.lengthSquared == 4.0)
  }

  test("Length") {
    val vec = Vec2c(1.0 + I, 1.0 + I)
    assert(vec.length == 2.0)
  }

  test("Normalized vector") {
    val vec = Vec2c(1.0 + I, 1.0 + I)
    val res = Vec2c(0.5 + 0.5 * I, 0.5 + 0.5 * I)
    assert(vec.normalized === res)
  }

  test("Vector is normalized") {
    val a = Vec2c(1.0 + I, 1.0 + I)
    val b = Vec2c(0.5 + 0.5 * I, 0.5 + 0.5 * I)
    assert(!a.isNormalized)
    assert(b.isNormalized)
  }

  test("Limit length of a vector") {
    val vec = Vec2c(1.0 + 2.0 * I, 3.0 + 4.0 * I)
    assert(vec.limitLength(2.0).length === 2.0 +- scalamath.Epsilon)
  }

  test("Vector absolute value") {
    val vec = Vec2c(1.0 + I, 1.0 + I)
    val res = Vec2d(math.sqrt(2.0), math.sqrt(2.0))
    assert(vec.abs == res)
  }

  ignore("Move vector toward another") {
    // TODO
  }

  ignore("Vector lerp") {
    // TODO
  }

  ignore("Vector slerp") {
    // TODO
  }

  ignore("Direction to vector") {
    // TODO
  }

  ignore("Direction to two values") {
    // TODO
  }

  ignore("Distance squared to vector") {
    // TODO
  }

  ignore("Distance squared to two values") {
    // TODO
  }

  ignore("Distance to vector") {
    // TODO
  }

  ignore("Distance to two values") {
    // TODO
  }

  test("Angle between two vectors") {
    val a = Vec2c(1.0 + I, 2.0 + I)
    val b = Vec2c(2.0 + I, 1.0 + I)
    assert(a.angleTo(b) === math.acos(6.0 / 7.0) +- 1e-9)
  }

  test("Angle between two vectors with two values") {
    val vec = Vec2c(1.0 + I, 2.0 + I)
    val angle = vec.angleTo(2.0 + I, 1.0 + I)
    assert(angle === math.acos(6.0 / 7.0) +- 1e-9)
  }

  ignore("Project vector onto another") {
    // TODO
  }

  ignore("Project vector onto two values") {
    // TODO
  }

  ignore("Reflect vector") {
    // TODO
  }

  ignore("Reflect vector by two values") {
    // TODO
  }

  ignore("Bounce vector") {
    // TODO
  }

  ignore("Bounce vector by two values") {
    // TODO
  }

  ignore("Slide vector") {
    // TODO
  }

  ignore("Slide vector by two values") {
    // TODO
  }

  ignore("Vector rotated by angle") {
    // TODO
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

  ignore("Outer product with two values") {
    // TODO
  }

  ignore("Outer product with a 2D vector") {
    // TODO
  }

  ignore("Outer product with three values") {
    // TODO
  }

  ignore("Outer product with a 3D vector") {
    // TODO
  }

  test("Vector equals two values") {
    val vec = Vec2c(1.0 + 2.0 * I, 3.0 + 2.0 * I)
    assert(vec == (1.0 + 2.0 * I, 3.0 + 2.0 * I))
  }

  test("Vector equals approximately two values") {
    val vec = Vec2c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I)
    assert(vec ~= (1.0 + 2.0 * I, 3.0 + 2.0 * I))
  }

  test("Vector equals approximately another vector") {
    val a = Vec2c(1.00000001 + 1.99999999 * I, 2.99999999 + 2.0 * I)
    val b = Vec2c(1.0 + 2.0 * I, 3.0 + 2.0 * I)
    assert(a ~= b)
  }

  test("Access component using index") {
    val vec = Vec2c(1.0 + 2.0 * I, 3.0 + 2.0 * I)
    assert(vec(0) == 1.0 + 2.0 * I)
    assert(vec(1) == 3.0 + 2.0 * I)
    assertThrows[MatchError] {vec(2)}
  }

  test("Get the real part of a vector") {
    val vec = Vec2c(1.0 + 2.0 * I, 3.0 + 2.0 * I)
    val real = Vec2d(1.0, 3.0)
    assert(vec.real == real)
  }

  test("Get the imaginary part of a vector") {
    val vec = Vec2c(1.0 + 2.0 * I, 3.0 + 2.0 * I)
    val img = Vec2d(2.0, 2.0)
    assert(vec.imaginary == img)
  }
}
