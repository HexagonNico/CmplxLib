package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec2cSuite extends AnyFunSuite {

  test("Sum of a vector and two values") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec + (Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(res == Vec2c(Complex(3.0, 4.5), Complex(4.5, 1.5)))
  }

  test("Sum of two vectors") {
    val a = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val b = Vec2c(Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(a + b == Vec2c(Complex(3.0, 4.5), Complex(4.5, 1.5)))
  }

  test("Additive inverse") {
    val a = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    assert(-a == Vec2c(Complex(-1.0, -2.0), Complex(-1.5, -1.0)))
  }

  test("Subtraction of two values from a vector") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec - (Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(res == Vec2c(Complex(-1.0, -0.5), Complex(-1.5, 0.5)))
  }

  test("Subtraction of two vectors") {
    val a = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val b = Vec2c(Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(a - b == Vec2c(Complex(-1.0, -0.5), Complex(-1.5, 0.5)))
  }

  test("Vector multiplied by a scalar") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec * 1.5
    assert(res == Vec2c(Complex(1.5, 3.0), Complex(2.25, 1.5)))
  }

  test("Vector multiplied by a scalar commutativity") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = 1.5 * vec
    assert(res == Vec2c(Complex(1.5, 3.0), Complex(2.25, 1.5)))
  }

  test("Vector divided by a scalar") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec / 2.0
    assert(res == Vec2c(Complex(0.5, 1.0), Complex(0.75, 0.5)))
  }

  test("Component-wise multiplication of a vector and two values") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec * (Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(res == Vec2c(Complex(-3.0, 6.5), Complex(4.0, 3.75)))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val b = Vec2c(Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(a * b == Vec2c(Complex(-3.0, 6.5), Complex(4.0, 3.75)))
  }

  test("Dot product with two values") {
    val vec = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val res = vec.dot(Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert(res == Complex(12.0, 3.75))
  }

  test("Dot product of two vectors") {
    val a = Vec2c(Complex(1.0, 2.0), Complex(1.5, 1.0))
    val b = Vec2c(Complex(2.0, 2.5), Complex(3.0, 0.5))
    assert((a dot b) == Complex(12.0, 3.75))
  }

  test("Length squared") {
    assert(Vec2c(Complex(1.0, 1.0), Complex(1.0, 1.0)).lengthSquared == 4.0)
  }

  test("Length") {
    assert(Vec2c(Complex(1.0, 1.0), Complex(1.0, 1.0)).length == 2.0)
  }

  test("Normalized vector") {
    val vec = Vec2c(Complex(1.0, 1.0), Complex(1.0, 1.0))
    assert(vec.normalized == Vec2c(Complex(0.5, 0.5), Complex(0.5, 0.5)))
  }

  test("Angle between two vectors") {
    val a = Vec2c(Complex(1.0, 1.0), Complex(2.0, 1.0))
    val b = Vec2c(Complex(2.0, 1.0), Complex(1.0, 1.0))
    assert(a.angle(b) === math.acos(6.0 / 7.0) +- 1e-9)
  }

  test("Conjugate of a vector") {
    val vec = Vec2c(Complex(2.0, 4.0), Complex(8.0, 6.0))
    assert(vec.conjugate == Vec2c(Complex(2.0, -4.0), Complex(8.0, -6.0)))
  }

  test("Reciprocal of a vector") {
    val vec = Vec2c(Complex(2.0, 4.0), Complex(8.0, 6.0))
    assert(vec.reciprocal == Vec2c(Complex(0.1, -0.2), Complex(0.08, -0.06)))
  }

  test("Component-wise division of two vectors") {
    val a = Vec2c(Complex(8.0, 6.0), Complex(6.0, 8.0))
    val b = Vec2c(Complex(2.0, 2.0), Complex(4.0, 2.0))
    assert(a / b == Vec2c(Complex(3.5, -0.5), Complex(2.0, 1.0)))
  }

  test("Component-wise division of a vector and two values") {
    val vec = Vec2c(Complex(8.0, 6.0), Complex(6.0, 8.0))
    val res = vec / (Complex(2.0, 2.0), Complex(4.0, 2.0))
    assert(res == Vec2c(Complex(3.5, -0.5), Complex(2.0, 1.0)))
  }

  test("Vector absolute value") {
    val vec = Vec2c(Complex(1.0, 1.0), Complex(1.0, 1.0))
    assert(vec.abs == Vec2c(Complex(math.sqrt(2.0), 0.0), Complex(math.sqrt(2.0), 0.0)))
  }
}
