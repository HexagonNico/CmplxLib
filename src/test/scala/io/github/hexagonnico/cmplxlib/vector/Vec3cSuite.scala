package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class Vec3cSuite extends AnyFunSuite {

  test("Sum of a vector and three values") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec + (Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(res == Vec3c(Complex(3.0, 4.5), Complex(4.5, 1.5), Complex(1.5, 3.0)))
  }

  test("Sum of two vectors") {
    val a = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val b = Vec3c(Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(a + b == Vec3c(Complex(3.0, 4.5), Complex(4.5, 1.5), Complex(1.5, 3.0)))
  }

  test("Additive inverse") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    assert(-vec == Vec3c(Complex(-1.0, -2.0), Complex(-1.5, -1.0), Complex(-0.5, -1.5)))
  }

  test("Subtraction of three values from a vector") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec - (Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(res == Vec3c(Complex(-1.0, -0.5), Complex(-1.5, 0.5), Complex(-0.5, 0.0)))
  }

  test("Subtraction of two vectors") {
    val a = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val b = Vec3c(Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(a - b == Vec3c(Complex(-1.0, -0.5), Complex(-1.5, 0.5), Complex(-0.5, 0.0)))
  }

  test("Vector multiplied by a real number") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec * 1.5
    assert(res == Vec3c(Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(0.75, 2.25)))
  }

  test("Vector multiplied by a real number commutativity") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = 1.5 * vec
    assert(res == Vec3c(Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(0.75, 2.25)))
  }

  test("Vector multiplied by a complex number") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(1.0, 1.0))
    val res = vec * Complex(1.5, 1.0)
    assert(res == Vec3c(Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(0.5, 2.5)))
  }

  test("Vector multiplied by a complex number commutativity") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(1.0, 1.0))
    val res = Complex(1.5, 1.0) * vec
    assert(res == Vec3c(Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(0.5, 2.5)))
  }

  test("Vector divided by a real number") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec / 2.0
    assert(res == Vec3c(Complex(0.5, 1.0), Complex(0.75, 0.5), Complex(0.25, 0.75)))
  }

  test("Vector divided by a complex number") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec / Complex(1.0, 1.0)
    assert(res == Vec3c(Complex(3.0 / 2.0, 0.5), Complex(1.25, -0.25), Complex(1.0, 0.5)))
  }

  test("Component-wise multiplication of a vector and three values") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec * (Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(res == Vec3c(Complex(-3.0, 6.5), Complex(4.0, 3.75), Complex(-1.75, 2.25)))
  }

  test("Component-wise multiplication of two vectors") {
    val a = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val b = Vec3c(Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(a * b == Vec3c(Complex(-3.0, 6.5), Complex(4.0, 3.75), Complex(-1.75, 2.25)))
  }

  test("Dot product with three values") {
    val vec = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val res = vec.dot(Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert(res == Complex(14.75, 4.5))
  }

  test("Dot product of two vectors") {
    val a = Vec3c(Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(0.5, 1.5))
    val b = Vec3c(Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 1.5))
    assert((a dot b) == Complex(14.75, 4.5))
  }

  test("Length squared") {
    assert(Vec3c(Complex(1.0, 1.0), Complex(1.0, 1.0), Complex(2.0, 1.0)).lengthSquared == 9.0)
  }

  test("Length") {
    assert(Vec3c(Complex(1.0, 1.0), Complex(1.0, 1.0), Complex(2.0, 1.0)).length == 3.0)
  }

  test("Normalized vector") {
    val vec = Vec3c(Complex(1.0, 1.0), Complex(1.0, 1.0), Complex(2.0, 1.0))
    assert(vec.normalized == Vec3c(Complex(1.0 / 3.0, 1.0 / 3.0), Complex(1.0 / 3.0, 1.0 / 3.0), Complex(2.0 / 3.0, 1.0 / 3.0)))
  }

  test("Angle between two vectors") {
    val a = Vec3c(Complex(1.0, 1.0), Complex(2.0, 1.0), Complex(3.0, 2.0))
    val b = Vec3c(Complex(2.0, 1.0), Complex(1.0, 1.0), Complex(2.0, 3.0))
    assert(a.angle(b) === math.acos(9.0 / 10.0) +- 1e-9)
  }

  test("Conjugate of a vector") {
    val vec = Vec3c(Complex(2.0, 4.0), Complex(8.0, 6.0), Complex(1.0, 2.0))
    assert(vec.conjugate == Vec3c(Complex(2.0, -4.0), Complex(8.0, -6.0), Complex(1.0, -2.0)))
  }

  test("Multiplicative inverse of a vector") {
    val vec = Vec3c(Complex(2.0, 4.0), Complex(8.0, 6.0), Complex(1.0, 2.0))
    assert(vec.inverse == Vec3c(Complex(0.1, -0.2), Complex(0.08, -0.06), Complex(0.2, -0.4)))
  }

  test("Component-wise division of two vectors") {
    val a = Vec3c(Complex(8.0, 6.0), Complex(6.0, 8.0), Complex(1.0, 2.0))
    val b = Vec3c(Complex(2.0, 2.0), Complex(4.0, 2.0), Complex(2.0, 4.0))
    assert(a / b == Vec3c(Complex(3.5, -0.5), Complex(2.0, 1.0), Complex(0.5, 0.0)))
  }

  test("Component-wise division of a vector and three values") {
    val vec = Vec3c(Complex(8.0, 6.0), Complex(6.0, 8.0), Complex(1.0, 2.0))
    val res = vec / (Complex(2.0, 2.0), Complex(4.0, 2.0), Complex(2.0, 4.0))
    assert(res == Vec3c(Complex(3.5, -0.5), Complex(2.0, 1.0), Complex(0.5, 0.0)))
  }

  test("Vector absolute value") {
    val vec = Vec3c(Complex(1.0, 1.0), Complex(1.0, 1.0), Complex(2.0, 2.0))
    val abs = vec.abs
    assert(abs.x.real === math.sqrt(2.0) +- 1e-9)
    assert(abs.y.real === math.sqrt(2.0) +- 1e-9)
    assert(abs.z.real === math.sqrt(8.0) +- 1e-9)
  }
}
