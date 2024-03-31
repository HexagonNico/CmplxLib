package io.github.scalamath.cmplxlib

import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class ComplexSuite extends AnyFunSuite {

  implicit val equality: Equality[Complex] = (a: Complex, b: Any) => b match {
    case b: Complex => a ~= b
    case _ => false
  }

  test("Sum of a complex number and two values") {
    val z = Complex(2.0, 1.0)
    val res = Complex(3.5, 3.0)
    assert(z + (1.5, 2.0) == res)
  }

  test("Sum of a complex number and a real number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(3.5, 1.0)
    assert(z + 1.5 == res)
  }

  test("Sum of a real number and a complex number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(3.5, 1.0)
    assert(1.5 + z == res)
  }

  test("Sum of two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    val res = Complex(3.5, 3.0)
    assert(z + w == res)
  }

  test("Unary plus") {
    val z = Complex(2.0, 1.0)
    assert(+z == z)
  }

  test("Subtraction of two values from a complex number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(0.5, -1.0)
    assert(z - (1.5, 2.0) == res)
  }

  test("Subtraction of a real number from a complex number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(0.5, 1.0)
    assert(z - 1.5 == res)
  }

  test("Subtraction of a complex number from a real number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(-0.5, -1.0)
    assert(1.5 - z == res)
  }

  test("Subtraction of two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    val res = Complex(0.5, -1.0)
    assert(z - w == res)
  }

  test("Unary minus") {
    val z = Complex(2.0, 1.0)
    val w = Complex(-2.0, -1.0)
    assert(-z == w)
  }

  test("Product between a complex number and a real number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(3.0, 1.5)
    assert(z * 1.5 == res)
  }

  test("Product between a real number and a complex number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(3.0, 1.5)
    assert(1.5 * z == res)
  }

  test("Product between a complex number and two values") {
    val z = Complex(2.0, 1.0)
    val res = Complex(1.0, 5.5)
    assert(z * (1.5, 2.0) == res)
  }

  test("Product between two complex numbers") {
    val z = Complex(2.0, 1.0)
    val w = Complex(1.5, 2.0)
    val res = Complex(1.0, 5.5)
    assert(z * w == res)
  }

  test("Complex number divided by a real number") {
    val z = Complex(2.0, 1.0)
    val res = Complex(1.0, 0.5)
    assert(z / 2.0 == res)
  }

  test("Conjugate of a complex number") {
    val z = Complex(2.0, 1.0)
    assert(z.conjugate == Complex(2.0, -1.0))
  }

  test("Squared modulus of a complex number") {
    val z = Complex(3.0, 2.0)
    assert(z.squaredModulus == 13.0)
  }

  test("Modulus of a complex number") {
    val z = Complex(1.0, 1.0)
    assert(z.modulus == math.sqrt(2.0))
  }

  test("Argument of a complex number") {
    val z = Complex(5.0, 5.0)
    assert(z.arg == math.Pi / 4.0)
  }

  test("Multiplicative inverse of a complex number") {
    val z = Complex(2.0, 1.0)
    assert(z.inverse == Complex(0.4, -0.2))
  }

  test("Complex number divided by a complex number") {
    val z = Complex(2.0, 2.0)
    val w = Complex(3.0, 2.0)
    val res = Complex(1.25, -0.25)
    assert(w / z == res)
  }

  test("Complex number divided by two values") {
    val z = Complex(3.0, 2.0)
    val res = Complex(1.25, -0.25)
    assert(z / (2.0, 2.0) == res)
  }

  test("Real and imaginary part of a complex number") {
    val z = Complex(3.0, 2.0)
    assert(z.real == 3.0)
    assert(z.imaginary == 2.0)
  }

  test("Complex number equals two values") {
    val z = Complex(3.0, 2.0)
    assert(z == (3.0, 2.0))
  }

  test("Complex number equals approx two values") {
    val z = Complex(3.00000001, 1.99999999)
    assert(z ~= (3.0, 2.0))
  }

  test("Complex number equals approx a complex number") {
    val z = Complex(3.00000001, 1.99999999)
    val w = Complex(3.0, 2.0)
    assert(z ~= w)
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

  test("Complex number from polar form") {
    val z = Complex(3.0, 2.0)
    val w = Complex.fromPolar(z.modulus, z.arg)
    assert(z === w)
  }

  test("Absolute value of a complex number given two values") {
    val abs = Complex.abs(3.0, 2.0)
    val res = math.sqrt(13.0)
    assert(abs == res)
  }

  test("Absolute value of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = math.sqrt(13.0)
    assert(Complex.abs(z) == res)
  }

  test("Square root of a complex number given two values") {
    val sqrt = Complex.sqrt(3.0, 2.0)
    val res = Complex(1.81735402, 0.55025052)
    assert(sqrt === res)
  }

  test("Square root of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = Complex(1.81735402, 0.55025052)
    assert(Complex.sqrt(z) === res)
  }

  test("Square root of -1") {
    assert(Complex.sqrt(-1.0) == Complex.I)
  }

  test("Exponential of a complex number given two values") {
    val exp = Complex.exp(3.0, 2.0)
    val res = Complex(math.cos(2.0), math.sin(2.0)) * math.exp(3.0)
    assert(exp === res)
  }

  test("Exponential of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = Complex(math.cos(2.0), math.sin(2.0)) * math.exp(3.0)
    assert(Complex.exp(z) === res)
  }

  test("Logarithm of a complex number given two values") {
    val log = Complex.log(math.cos(2.0) * math.exp(3.0), math.sin(2.0) * math.exp(3.0))
    val res = Complex(3.0, 2.0)
    assert(log === res)
  }

  test("Logarithm of a complex number") {
    val z = Complex(math.cos(2.0), math.sin(2.0)) * math.exp(3.0)
    val res = Complex(3.0, 2.0)
    assert(Complex.log(z) === res)
  }

  // TODO: Power

  test("Sine of a complex number given two values") {
    val sin = Complex.sin(3.0, 2.0)
    val res = Complex(0.5309211, -3.5905646)
    assert(sin === res)
  }

  test("Sine of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = Complex(0.5309211, -3.5905646)
    assert(Complex.sin(z) === res)
  }

  test("Cosine of a complex number given two values") {
    val cos = Complex.cos(3.0, 2.0)
    val res = Complex(-3.7245455, -0.5118226)
    assert(cos === res)
  }

  test("Cosine of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = Complex(-3.7245455, -0.5118226)
    assert(Complex.cos(z) === res)
  }

  test("Tangent of a complex number given two values") {
    val tan = Complex.tan(3.0, 2.0)
    val res = Complex(-0.0098844, 0.9653859)
    assert(tan === res)
  }

  test("Tangent of a complex number") {
    val z = Complex(3.0, 2.0)
    val res = Complex(-0.0098844, 0.9653859)
    assert(Complex.tan(z) === res)
  }
}
