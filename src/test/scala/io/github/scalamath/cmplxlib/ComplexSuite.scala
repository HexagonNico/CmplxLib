package io.github.scalamath.cmplxlib

import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalatest.funsuite.AnyFunSuite

class ComplexSuite extends AnyFunSuite {

  test("Sum of a complex number and two real numbers") {
    val z = Complex(2.0, 1.0)
    val res = z + (1.5, 2.0)
    assert(res == Complex(3.5, 3.0))
  }

  test("Sum of a complex number and a real number") {
    val z = Complex(2.0, 1.0)
    val res = z + 1.5
    assert(res == Complex(3.5, 1.0))
  }

  test("Sum of a real number and a complex number") {
    val z = Complex(2.0, 1.0)
    val res = 1.5 + z
    assert(res == Complex(3.5, 1.0))
  }

  test("Sum of two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    assert(z + w == Complex(3.5, 3.0))
  }

  test("Additive inverse") {
    val z = Complex(2.0, 1.0)
    assert(-z == Complex(-2.0, -1.0))
  }

  test("Subtraction of two real numbers from a complex number") {
    val z = Complex(2.0, 1.0)
    val res = z - (1.5, 2.0)
    assert(res == Complex(0.5, -1.0))
  }

  test("Subtraction of a real number from a complex number") {
    val z = Complex(2.0, 1.0)
    val res = z - 1.5
    assert(res == Complex(0.5, 1.0))
  }

  test("Subtraction of a complex number from a real number") {
    val z = Complex(2.0, 1.0)
    val res = 1.5 - z
    assert(res == Complex(-0.5, -1.0))
  }

  test("Subtraction of two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    assert(z - w == Complex(0.5, -1.0))
  }

  test("Product between a complex number and a real number") {
    val z = Complex(2.0, 1.0)
    val res = z * 1.5
    assert(res == Complex(3.0, 1.5))
  }

  test("Product between a real number and a complex number") {
    val z = Complex(2.0, 1.0)
    val res = 1.5 * z
    assert(res == Complex(3.0, 1.5))
  }

  test("Product between a complex number and two real numbers") {
    val z = Complex(2.0, 1.0)
    val res = z * (1.5, 2.0)
    assert(res == Complex(1.0, 5.5))
  }

  test("Product between two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    assert(z * w == Complex(1.0, 5.5))
  }

  test("Complex number divided by a real number") {
    val z = Complex(2.0, 1.0)
    val res = z / 2.0
    assert(res == Complex(1.0, 0.5))
  }

  test("Conjugate of a complex number") {
    val z = Complex(2.0, 1.0)
    assert(z.conjugate == Complex(2.0, -1.0))
  }

  test("Modulus of a complex number") {
    val z = Complex(1.0, 1.0)
    assert(z.modulus == math.sqrt(2.0))
  }

  test("Multiplicative inverse of a complex number") {
    val z = Complex(2.0, 1.0)
    assert(z.inverse == Complex(0.4, -0.2))
  }

  test("Complex number divided by a complex number") {
    val z = Complex(2.0, 2.0)
    val w = Complex(3.0, 2.0)
    assert(w / z == Complex(1.25, -0.25))
  }

  test("Complex number divided by two real numbers") {
    val z = Complex(3.0, 2.0)
    val res = z / (2.0, 2.0)
    assert(res == Complex(1.25, -0.25))
  }

  test("Argument of a complex number") {
    val z = Complex(4.0, 2.0)
    assert(z.arg == math.atan(0.5))
  }

  test("Real and imaginary part of a complex number") {
    val z = Complex(3.0, 2.0)
    assert(z.real == 3.0)
    assert(z.imaginary == 2.0)
  }

  test("Complex number to string") {
    val z = Complex(3.0, 2.0)
    assert(z.toString == "3.0 + 2.0i")
  }

  test("Real number to string") {
    assert(Complex.One.toString == "1.0")
  }

  test("Imaginary unit to string") {
    assert(Complex.I.toString == "i")
  }

  test("Imaginary number to string") {
    val z = Complex(0.0, 2.0)
    assert(z.toString == "2.0i")
  }

  test("Zero to string") {
    assert(Complex.Zero.toString == "0.0")
  }

  test("Sine of a complex number") {
    val z = Complex.sin(Complex(math.Pi, 1.0))
    assert(z.real === 0.0 +- 1e-9)
    assert(z.imaginary === (1.0 - math.E * math.E) / (2.0 * math.E) +- 1e-9)
  }

  test("Cosine of a complex number") {
    val z = Complex.cos(Complex.I)
    assert(z.real === (math.E * math.E + 1.0) / (2.0 * math.E) +- 1e-9)
    assert(z.imaginary === 0.0 +- 1e-9)
  }

  test("Inverse sine of a complex number") {
    val z = Complex.asin(Complex(0.0, (1.0 - math.E * math.E) / (2.0 * math.E)))
    assert(z.real === 0.0 +- 1e-9)
    assert(z.imaginary === -1.0 +- 1e-9)
  }

  test("Inverse cosine of a complex number") {
    val z = Complex.acos(Complex(1.0 / math.sqrt(2.0), 0.0))
    assert(z.real === math.Pi / 4.0 +- 1e-9)
    assert(z.imaginary === 0.0 +- 1e-9)
  }
}
