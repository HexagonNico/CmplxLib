package io.github.scalamath.cmplxlib

import io.github.scalamath.DoubleEqualsApprox

/**
 * Cartesian representation of a complex number expressed in the form `a + ib`.
 *
 * @constructor Constructs a complex number with the given real and imaginary part.
 * @param a The real part of the complex number
 * @param b The imaginary part of a complex number
 */
case class Complex(a: Double, b: Double) {

  /**
   * Adds the given values to this complex number and returns the result.
   *
   * @param a The value to add to the real part.
   * @param b The value to add to the imaginary part.
   * @return The sum between this complex number and the given one.
   */
  def +(a: Double, b: Double): Complex = Complex(this.a + a, this.b + b)

  /**
   * Adds the given values to this complex number and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param a The value to add to the real part.
   * @param b The value to add to the imaginary part.
   * @return The sum between this complex number and the given one.
   */
  def plus(a: Double, b: Double): Complex = this + (a, b)

  /**
   * Adds the given real number to this complex number and returns the result.
   *
   * @param r The real number to add.
   * @return The sum between this complex number and the given real number.
   */
  def +(r: Double): Complex = this + (r, 0.0)

  /**
   * Adds the given real number to this complex number and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param r The real number to add.
   * @return The sum between this complex number and the given real number.
   */
  def plus(r: Double): Complex = this + r

  /**
   * Adds the given complex number to this one and returns the result.
   *
   * @param z The complex number to add.
   * @return The sum between this complex number and the given one.
   */
  def +(z: Complex): Complex = this + (z.a, z.b)

  /**
   * Adds the given complex number to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param z The complex number to add.
   * @return The sum between this complex number and the given one.
   */
  def plus(z: Complex): Complex = this + z

  /**
   * Returns this same complex number.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This same complex.
   */
  def unary_+ : Complex = this

  /**
   * Subtracts the given values from this complex number and returns the result.
   *
   * @param a The value to subtract from the real part.
   * @param b The value to subtract from the imaginary part.
   * @return The subtraction between this complex number and the given one.
   */
  def -(a: Double, b: Double): Complex = Complex(this.a - a, this.b - b)

  /**
   * Subtracts the given values from this complex number and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param a The value to subtract from the real part.
   * @param b The value to subtract from the imaginary part.
   * @return The subtraction between this complex number and the given one.
   */
  def minus(a: Double, b: Double): Complex = this - (a, b)

  /**
   * Subtracts the given real number from this complex number and returns the result.
   *
   * @param r The real number to subtract.
   * @return The subtraction between this complex number and the given real number.
   */
  def -(r: Double): Complex = this - (r, 0.0)

  /**
   * Subtracts the given real number from this complex number and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param r The real number to subtract.
   * @return The subtraction between this complex number and the given real number.
   */
  def minus(r: Double): Complex = this - r

  /**
   * Subtracts the given complex number from this one and returns the result.
   *
   * @param z The complex number to subtract.
   * @return The subtraction between this complex number and the given one.
   */
  def -(z: Complex): Complex = this - (z.a, z.b)

  /**
   * Subtracts the given complex number from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param z The complex number to subtract.
   * @return The subtraction between this complex number and the given one.
   */
  def minus(z: Complex): Complex = this - z

  /**
   * Returns the additive inverse of this complex number.
   *
   * The additive inverse of a complex number `a + ib` is the complex number `-a - ib`.
   *
   * @return The additive inverse of this complex number.
   */
  def unary_- : Complex = Complex(-this.a, -this.b)

  /**
   * Returns the additive inverse of this complex number.
   *
   * The additive inverse of a complex number `a + ib` is the complex number `-a - ib`.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this complex number.
   */
  def negated: Complex = -this

  /**
   * Multiplies this complex number by the given real number and returns the result.
   *
   * @param r The real number to multiply this complex number by.
   * @return The product between this complex number and the given real number.
   */
  def *(r: Double): Complex = Complex(this.a * r, this.b * r)

  /**
   * Multiplies this complex number by the given real number and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param r The real number to multiply this complex number by.
   * @return The product between this complex number and the given real number.
   */
  def multiply(r: Double): Complex = this * r

  /**
   * Multiplies this complex number by the complex number with the given real part and imaginary part and returns the result.
   *
   * @param a The real part of the complex number to multiply this one by.
   * @param b The imaginary part of the complex number to multiply this one by.
   * @return The product between this complex number and the given one.
   */
  def *(a: Double, b: Double): Complex = Complex(this.a * a - this.b * b, this.a * b + this.b * a)

  /**
   * Multiplies this complex number by the complex number with the given real part and imaginary part and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param a The real part of the complex number to multiply this one by.
   * @param b The imaginary part of the complex number to multiply this one by.
   * @return The product between this complex number and the given one.
   */
  def multiply(a: Double, b: Double): Complex = this * (a, b)

  /**
   * Multiplies this complex number by the given one and returns the result.
   *
   * @param z The complex number to multiply this one by.
   * @return The product between this complex number and the given one.
   */
  def *(z: Complex): Complex = this * (z.a, z.b)

  /**
   * Multiplies this complex number by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param z The complex number to multiply this one by.
   * @return The product between this complex number and the given one.
   */
  def multiply(z: Complex): Complex = this * z

  /**
   * Divides this complex number by the given real number and returns the result.
   *
   * @param r The real number to divide this complex number by.
   * @return The division between this complex number and the given real number.
   */
  def /(r: Double): Complex = Complex(this.a / r, this.b / r)

  /**
   * Divides this complex number by the given real number and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param r The real number to divide this complex number by.
   * @return The division between this complex number and the given real number.
   */
  def divide(r: Double): Complex = this / r

  /**
   * Returns the complex conjugate of this complex number.
   *
   * The conjugate of a complex number `a + ib` is the complex number `a - ib`.
   *
   * @return The complex conjugate of this complex number.
   */
  def conjugate: Complex = Complex(this.a, -this.b)

  /**
   * Returns the squared modulus of this complex number.
   *
   * The squared modulus is also the result of multiplying a complex number by its [[conjugate]].
   *
   * @return The squared modulus of this complex number.
   */
  def squaredModulus: Double = this.a * this.a + this.b * this.b

  /**
   * Returns the modulus, or absolute value, of this complex number.
   *
   * The modulus of a complex number represents its distance from the origin of the complex plane.
   *
   * @return The modulus of this complex number.
   */
  def modulus: Double = math.sqrt(this.squaredModulus)

  /**
   * Returns the argument of this complex number, the angle between the real axis and the point representing this number in the complex plane.
   *
   * @return The argument of this complex number.
   */
  def arg: Double = math.atan2(this.imaginary, this.real)

  /**
   * Returns the multiplicative inverse, or the reciprocal, of this complex number.
   *
   * @return The multiplicative inverse of this complex number.
   */
  def inverse: Complex = this.conjugate / this.squaredModulus

  /**
   * Multiplies this complex number by the [[inverse]] of the given one and returns the result.
   * 
   * @param z The complex number to divide this one by.
   * @return The division between this complex number and the given one.
   */
  def /(z: Complex): Complex = this * z.inverse

  /**
   * Multiplies this complex number by the [[inverse]] of the given one and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param z The complex number to divide this one by.
   * @return The division between this complex number and the given one.
   */
  def divide(z: Complex): Complex = this / z

  /**
   * Divides this complex number by the one with the given real and imaginary part and returns the result.
   *
   * @param a The real part of the complex number to divide this one by.
   * @param b The imaginary part of the complex number to divide this one by.
   * @return The division between this complex number and the given one.
   */
  def /(a: Double, b: Double): Complex = this / Complex(a, b)

  /**
   * Divides this complex number by the one with the given real and imaginary part and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param a The real part of the complex number to divide this one by.
   * @param b The imaginary part of the complex number to divide this one by.
   * @return The division between this complex number and the given one.
   */
  def divide(a: Double, b: Double): Complex = this / (a, b)

  /**
   * Returns the real part of this complex number.
   *
   * This method is an alias for `a`.
   *
   * @return The the real part of this complex number.
   */
  def real: Double = this.a

  /**
   * Returns the imaginary part of this complex number.
   *
   * This method is an alias for `b`.
   *
   * @return The the imaginary part of this complex number.
   */
  def imaginary: Double = this.b

  /**
   * Checks if the real and imaginary parts of this complex number are equal to the given values.
   *
   * @param a The real part.
   * @param b The imaginary part.
   * @return True if the real and imaginary parts of this complex number are equal to the given values, otherwise false.
   */
  def ==(a: Double, b: Double): Boolean = this.a == a && this.b == b

  /**
   * Checks if the real and imaginary parts of this complex number are equal to the given values.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param a The real part.
   * @param b The imaginary part.
   * @return True if the real and imaginary parts of this complex number are equal to the given values, otherwise false.
   */
  def equals(a: Double, b: Double): Boolean = this == (a, b)

  /**
   * Checks if the real and imaginary parts of this complex number are approximately equal to the given values using an internal epsilon.
   *
   * @param a The real part.
   * @param b The imaginary part.
   * @return True if the real and imaginary parts of this complex number are approximately equal to the given values, otherwise false.
   */
  def ~=(a: Double, b: Double): Boolean = (this.a ~= a) && (this.b ~= b)

  /**
   * Checks if the real and imaginary parts of this complex number are approximately equal to the given values using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param a The real part.
   * @param b The imaginary part.
   * @return True if the real and imaginary parts of this complex number are approximately equal to the given values, otherwise false.
   */
  def equalsApprox(a: Double, b: Double): Boolean = this ~= (a, b)

  /**
   * Checks if this complex number is approximately equal to the given one using an internal epsilon.
   *
   * @param z The complex number.
   * @return True if this complex number is approximately equal to the given one, otherwise false.
   */
  def ~=(z: Complex): Boolean = this ~= (z.a, z.b)

  /**
   * Checks if this complex number is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param z The complex number.
   * @return True if this complex number is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(z: Complex): Boolean = this ~= z

  /**
   * Returns a string representation of this complex number in the form `a + ib`.
   *
   * @return A string representation of this complex number.
   */
  override def toString: String = {
    if (this.a == 0.0 && this.b == 0.0) {
      "0.0"
    } else if (this.b == 0.0) {
      this.a.toString
    } else if (this.a == 0.0) {
      if (this.b == 1.0) {
        "i"
      } else {
        f"${b}i"
      }
    } else {
      f"$a ${if(b > 0.0) "+" else "-"} ${b.abs}i"
    }
  }
}

/**
 * Constants, implicits, and static methods for complex numbers.
 */
object Complex {

  /** Shorthand for `Complex(1.0, 0.0)` */
  val One: Complex = Complex(1.0, 0.0)

  /** Shorthand for the imaginary unit `Complex(0.0, 1.0)` */
  val I: Complex = Complex(0.0, 1.0)

  /** Shorthand for `Complex(0.0, 0.0)` */
  val Zero: Complex = Complex(0.0, 0.0)

  /**
   * Returns the absolute value, or modulus, of the given complex number.
   *
   * @return The absolute value of the given complex number.
   */
  def abs(z: Complex): Double = z.modulus

  /**
   * Returns the exponential of the given complex number, or Euler's number raised to the power of the given number.
   *
   * @param z The exponent to raise e to.
   * @return The exponential of the given complex number.
   */
  def exp(z: Complex): Complex = Complex(math.cos(z.b), math.sin(z.b)) * math.exp(z.a)

  /**
   * Returns the sine of the given complex number.
   *
   * @param z The argument of the sin function.math.exp(z.a)
   * @return The sine of the given complex number.
   */
  def sin(z: Complex): Complex = 0.5 * I * (exp(-I * z) - exp(I * z))

  /**
   * Returns the cosine of the given complex number.
   *
   * @param z The argument of the cos function.
   * @return The cosine of the given complex number.
   */
  def cos(z: Complex): Complex = 0.5 * (exp(I * z) + exp(-I * z))

  /**
   * Returns the principal square root of the given complex number.
   * 
   * @param z The number to take the square root of.
   * @return The principal square root of the given complex number.
   */
  def sqrt(z: Complex): Complex = {
    val abs = z.modulus
    Complex(math.sqrt((abs + z.a) / 2.0), z.b.sign * math.sqrt((abs - z.a) / 2.0))
  }

  /**
   * Returns the natural logarithm of the given complex number.
   * 
   * @param z The number to take the natural logarithm of.
   * @return The natural logarithm of the given complex number.
   */
  def log(z: Complex): Complex = math.log(z.modulus) + I * z.arg

  /**
   * Returns the inverse sine of the given complex number.
   *
   * @param z The argument of the asin function.
   * @return The inverse sine of the given complex number.
   */
  def asin(z: Complex): Complex = -I * log(I * z + sqrt(1.0 - z * z))

  /**
   * Returns the inverse cosine of the given complex number.
   *
   * @param z The argument of the acos function.
   * @return The inverse cosine of the given complex number.
   */
  def acos(z: Complex): Complex = 0.5 * math.Pi + I * log(I * z + sqrt(1.0 - z * z))

  /**
   * Allows to use commutative operators between complex and real numbers.
   * 
   * @param r The real number
   */
  implicit class RealExtender(val r: Double) extends AnyVal {

    /**
     * Returns the sum between this real number and the given complex number.
     * 
     * @param z The complex number to add
     * @return The sum between this real number and the given complex number
     */
    def +(z: Complex): Complex = z + r

    /**
     * Returns the subtraction between the given complex number and this real number.
     * 
     * @param z The complex number to subtract
     * @return The subtraction between the given complex number and this real number
     */
    def -(z: Complex): Complex = -z + r

    /**
     * Returns the product between this real number and the given complex number.
     * 
     * @param z The complex number to multiply
     * @return The product between this real number and the given complex number
     */
    def *(z: Complex): Complex = z * r

    /**
     * Returns the result of the division of this real number by the given complex number.
     * 
     * @param z The complex number by which this one is divided
     * @return The result of the division of this real number by the given complex number
     */
    def /(z: Complex): Complex = r * z.inverse
  }

  implicit val realToComplex: Double => Complex = r => Complex(r, 0.0)
}
