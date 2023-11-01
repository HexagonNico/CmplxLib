package io.github.hexagonnico.cmplxlib

import io.github.hexagonnico.vecmatlib.Double2

/**
 * Cartesian representation of a complex number expressed in the form `a + ib`.
 *
 * @constructor Constructs a complex number with the given real and imaginary part.
 * @param a The real part of the complex number
 * @param b The imaginary part of a complex number
 */
case class Complex(a: Double, b: Double) extends Double2 {

  /**
   * Returns the sum between this complex number and the number `a + ib`.
   *
   * @param a The real part of the complex number to add
   * @param b The imaginary part of the complex number to add
   * @return The sum of this complex number and the given one
   */
  def +(a: Double, b: Double): Complex = Complex(this.a + a, this.b + b)

  /**
   * Returns the sum between this complex number and the number `a + ib`.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param a The real part of the complex number to add
   * @param b The imaginary part of the complex number to add
   * @return The sum of this complex number and the given one
   */
  def plus(a: Double, b: Double): Complex = this + (a, b)

  /**
   * Returns the sum between this complex number and the given real number.
   *
   * @param r The number to add
   * @return The sum of this complex number and the given real number
   */
  def +(r: Double): Complex = this + (r, 0.0)

  /**
   * Returns the sum between this complex number and the given real number.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param r The number to add
   * @return The sum of this complex number and the given real number
   */
  def plus(r: Double): Complex = this + r

  /**
   * Returns the sum between this complex number and the given one.
   *
   * @param z The number to add
   * @return The sum of this complex number and the given one
   */
  def +(z: Complex): Complex = this + (z.a, z.b)

  /**
   * Returns the sum between this complex number and the given one.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param z The number to add
   * @return The sum of this complex number and the given one
   */
  def plus(z: Complex): Complex = this + z

  /**
   * Returns the additive inverse of this complex number.
   *
   * The additive inverse of a complex number `a + ib` is the complex number `-a - ib`.
   *
   * @return The additive inverse of this complex number
   */
  def unary_-(): Complex = Complex(-this.a, -this.b)

  /**
   * Returns the additive inverse of this complex number.
   *
   * The additive inverse of a complex number `a + ib` is the complex number `-a - ib`.
   *
   * This method can be used in place of the unary '-' operator for better interoperability with Java.
   *
   * @return The additive inverse of this complex number
   */
  def negated: Complex = -this

  /**
   * Returns the subtraction between the complex number `a + ib` and this complex number.
   *
   * @param a The real part of the complex number to subtract
   * @param b The imaginary part of the complex number to subtract
   * @return The subtraction between the given complex number and this one
   */
  def -(a: Double, b: Double): Complex = Complex(this.a - a, this.b - b)

  /**
   * Returns the subtraction between the complex number `a + ib` and this complex number.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param a The real part of the complex number to subtract
   * @param b The imaginary part of the complex number to subtract
   * @return The subtraction between the given complex number and this one
   */
  def minus(a: Double, b: Double): Complex = this - (a, b)

  /**
   * Returns the subtraction between the given real number and this complex number.
   *
   * @param r The real number to subtract
   * @return The subtraction between the given real number and this complex number
   */
  def -(r: Double): Complex = this - (r, 0.0)

  /**
   * Returns the subtraction between the given real number and this complex number.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param r The real number to subtract
   * @return The subtraction between the given real number and this complex number
   */
  def minus(r: Double): Complex = this - r

  /**
   * Returns the subtraction between the given complex number and this one.
   *
   * @param z The complex number to subtract
   * @return The subtraction between the given complex number and this one
   */
  def -(z: Complex): Complex = this - (z.a, z.b)

  /**
   * Returns the subtraction between the given complex number and this one.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param z The complex number to subtract
   * @return The subtraction between the given complex number and this one
   */
  def minus(z: Complex): Complex = this - z

  /**
   * Returns the product between this complex number and the given real number.
   *
   * @param k The real number to multiply
   * @return The product between this complex number and the given real number
   */
  def *(k: Double): Complex = Complex(this.a * k, this.b * k)

  /**
   * Returns the product between this complex number and the given real number.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param k The real number to multiply
   * @return The product between this complex number and the given real number
   */
  def multiply(k: Double): Complex = this * k

  /**
   * Returns the product between this complex number and the number `a + ib`.
   *
   * @param a The real part of the complex number to multiply
   * @param b The imaginary part of the complex number to multiply
   * @return The product between this complex number and the given one
   */
  def *(a: Double, b: Double): Complex = Complex(this.a * a - this.b * b, this.a * b + this.b * a)

  /**
   * Returns the product between this complex number and the number `a + ib`.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param a The real part of the complex number to multiply
   * @param b The imaginary part of the complex number to multiply
   * @return The product between this complex number and the given one
   */
  def multiply(a: Double, b: Double): Complex = this * (a, b)

  /**
   * Returns the product between this complex number and the given one.
   *
   * @param z The complex number to multiply
   * @return The product between this complex number and the given one
   */
  def *(z: Complex): Complex = this * (z.a, z.b)

  /**
   * Returns the product between this complex number and the given one.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param z The complex number to multiply
   * @return The product between this complex number and the given one
   */
  def multiply(z: Complex): Complex = this * z

  /**
   * Returns the result of the division between this complex number and the given real number.
   *
   * @param k The real number by which this complex number is divided
   * @return The result of the division between this complex number and the given real number
   */
  def /(k: Double): Complex = Complex(this.a / k, this.b / k)

  /**
   * Returns the result of the division between this complex number and the given real number.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param k The real number by which this complex number is divided
   * @return The result of the division between this complex number and the given real number
   */
  def divide(k: Double): Complex = this / k

  /**
   * Returns the complex conjugate of this complex number.
   *
   * The conjugate of a complex number `a + ib` is the complex number `a - ib`
   *
   * @return The complex conjugate of this complex number
   */
  def conjugate: Complex = Complex(this.a, -this.b)

  /**
   * Returns the absolute value, or modulus, of this complex number.
   *
   * @return The absolute value of this complex number
   */
  def abs: Double = Complex.abs(this)

  /**
   * Returns the multiplicative inverse, or the reciprocal, of this complex number.
   *
   * @return The multiplicative inverse of this complex number
   */
  def reciprocal: Complex = this.conjugate / (this.a * this.a + this.b * b)

  /**
   * Returns the result of the division between this complex number and the given one.
   *
   * @param z The complex number by which this one is divided
   * @return The result of the division between this complex number and the given one
   */
  def /(z: Complex): Complex = this * z.reciprocal

  /**
   * Returns the result of the division between this complex number and the given one.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param z The complex number by which this one is divided
   * @return The result of the division between this complex number and the given one
   */
  def divide(z: Complex): Complex = this / z

  /**
   * Returns the result of the division between this complex number and number `a + ib`.
   *
   * @param a The real part of the number by which this one is divided
   * @param b The imaginary part of the number by which this one is divided
   * @return The result of the division between this complex number and the given one
   */
  def /(a: Double, b: Double): Complex = this / Complex(a, b)

  /**
   * Returns the result of the division between this complex number and number `a + ib`.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param a The real part of the number by which this one is divided
   * @param b The imaginary part of the number by which this one is divided
   * @return The result of the division between this complex number and the given one
   */
  def divide(a: Double, b: Double): Complex = this / (a, b)

  /**
   * Returns the argument of this complex number, the angle between the real axis and the point representing this number in the complex plane.
   *
   * @see [[math.atan2]]
   * @return The argument of this complex number
   */
  def arg: Double = math.atan2(this.imaginary, this.real)

  /**
   * Returns the real part of this complex number.
   *
   * This method is an alias for `a`.
   *
   * @return The the real part of this complex number
   */
  def real: Double = this.a

  /**
   * Returns the imaginary part of this complex number.
   *
   * This method is an alias for `b`.
   *
   * @return The the imaginary part of this complex number
   */
  def imaginary: Double = this.b

  /**
   * Returns the real part of this complex number.
   *
   * This method is an alias for `a`.
   *
   * @return The the real part of this complex number
   */
  override def x: Double = this.a

  /**
   * Returns the imaginary part of this complex number.
   *
   * This method is an alias for `b`.
   *
   * @return The the imaginary part of this complex number
   */
  override def y: Double = this.b

  /**
   * Returns a string representation of this complex number in the form `a + bi`.
   *
   * @return A string representation of this complex number
   */
  override def toString: String = {
    if(this.a == 0.0 && this.b == 0.0) {
      "0.0"
    } else if(this.b == 0.0) {
      this.a.toString
    } else if(this.a == 0.0) {
      f"${b}i"
    } else {
      f"$a ${if(b > 0.0) "+" else "-"} ${b.abs}i"
    }
  }
}

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
   * @return The absolute value of the given complex number
   */
  def abs(z: Complex): Double = math.sqrt(z.a * z.a + z.b * z.b)

  /**
   * Returns the exponential of the given complex number, or Euler's number raised to the power of the given number.
   *
   * @param z The exponent to raise e to
   * @return The exponential of the given complex number
   */
  def exp(z: Complex): Complex = math.exp(z.a) * Complex(math.cos(z.b), math.sin(z.b))

  /**
   * Returns the sine of the given complex number.
   *
   * @param z The argument of the sin function
   * @return The sine of the given complex number
   */
  def sin(z: Complex): Complex = 0.5 * I * (exp(-I * z) - exp(I * z))

  /**
   * Returns the cosine of the given complex number.
   *
   * @param z The argument of the cos function
   * @return The cosine of the given complex number
   */
  def cos(z: Complex): Complex = 0.5 * (exp(I * z) + exp(-I * z))

  /**
   * Returns the principal square root of the given complex number.
   * 
   * @param z The number to take the square root of
   * @return The principal square root of the given complex number
   */
  def sqrt(z: Complex): Complex = {
    val abs = z.abs
    0.5 * math.sqrt(2.0) * Complex(math.sqrt(abs + z.a), math.signum(z.b) * math.sqrt(abs - z.a))
  }

  /**
   * Returns the natural logarithm of the given complex number.
   * 
   * @param z The number to take the natural logarithm of
   * @return The natural logarithm of the given complex number
   */
  def log(z: Complex): Complex = math.log(z.abs) + I * z.arg

  /**
   * Returns the inverse sine of the given complex number.
   *
   * @param z The argument of the asin function
   * @return The inverse sine of the given complex number
   */
  def asin(z: Complex): Complex = -I * log(I * z + sqrt(1.0 - z * z))

  /**
   * Returns the inverse cosine of the given complex number.
   *
   * @param z The argument of the acos function
   * @return The inverse cosine of the given complex number
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
    def /(z: Complex): Complex = r * z.reciprocal
  }
}
