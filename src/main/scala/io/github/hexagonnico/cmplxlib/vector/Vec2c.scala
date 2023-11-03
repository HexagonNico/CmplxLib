package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex

/**
 * Class that represents a two-dimensional complex vector.
 *
 * @constructor Constructs a Vec2c from the two given values
 * @param x X component of the vector
 * @param y Y component of the vector
 */
case class Vec2c(x: Complex, y: Complex) extends ComplexVector[Vec2c] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Complex, y: Complex): Vec2c = Vec2c(this.x + x, this.y + y)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Complex, y: Complex): Vec2c = this + (x, y)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec2c): Vec2c = this + (v.x, v.y)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec2c = Vec2c(-this.x, -this.y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Complex, y: Complex): Vec2c = Vec2c(this.x - x, this.y - y)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Complex, y: Complex): Vec2c = this - (x, y)

  /**
   * Returns the product between this vector and the given real number.
   *
   * @param r The real number to which the vector is multiplied
   * @return The result of the product between this vector and the given real number
   */
  override def *(r: Double): Vec2c = Vec2c(this.x * r, this.y * r)

  /**
   * Returns the product between this vector and the given complex number.
   *
   * @param z The complex number to which the vector is multiplied
   * @return The result of the product between this vector and the given complex number
   */
  override def *(z: Complex): Vec2c = Vec2c(this.x * z, this.y * z)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Complex, y: Complex): Vec2c = Vec2c(this.x * x, this.y * y)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Complex, y: Complex): Vec2c = this * (x, y)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec2c): Vec2c = this * (v.x, v.y)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Complex, y: Complex): Complex = this.x * x.conjugate + this.y * y.conjugate

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The result of the dot product between this vector and the given one
   */
  override def dot(v: Vec2c): Complex = this.dot(v.x, v.y)

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector
   */
  override def lengthSquared: Double = (this dot this).real

  /**
   * Returns the complex conjugate of this vector.
   *
   * The conjugate of a vector is a vector where every element is its complex conjugate.
   *
   * @return The complex conjugate of this vector
   */
  override def conjugate: Vec2c = Vec2c(this.x.conjugate, this.y.conjugate)

  /**
   * Returns a vector whose components are the multiplicative inverse of this vectors components.
   *
   * @return A vector whose components are the multiplicative inverse of this vectors components
   */
  override def inverse: Vec2c = Vec2c(this.x.inverse, this.y.inverse)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Complex, y: Complex): Vec2c = Vec2c(this.x / x, this.y / y)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def divide(x: Complex, y: Complex): Vec2c = this / (x, y)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec2c = Vec2c(Complex(this.x.abs, 0.0), Complex(this.y.abs, 0.0))

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Complex, y: Complex): Boolean = this.x == x && this.y == y

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Complex, y: Complex): Boolean = this == (x, y)
}

object Vec2c {

  /** Shorthand for `Vec2c(Complex.Zero, Complex.Zero)` */
  val Zero: Vec2c = Vec2c(Complex.Zero, Complex.Zero)

  /** Shorthand for `Vec2c(Complex.One, Complex.One)` */
  val One: Vec2c = Vec2c(Complex.One, Complex.One)

  /**
   * Allows to use the operator '*' with a real number as `1.0 * vector`.
   *
   * @param r The real number
   */
  implicit class RealExtender(val r: Double) extends AnyVal {

    /**
     * Returns the product between this real number and the given vector.
     *
     * @param v The vector to which the number is multiplied
     * @return The result of the product between this number and the given vector
     */
    def *(v: Vec2c): Vec2c = v * r
  }

  /**
   * Allows to use the operator '*' with a complex number as `z * vector`.
   *
   * @param z The complex number
   */
  implicit class ComplexExtender(val z: Complex) extends AnyVal {

    /**
     * Returns the product between this complex number and the given vector.
     *
     * @param v The vector to which the number is multiplied
     * @return The result of the product between this number and the given vector
     */
    def *(v: Vec2c): Vec2c = v * z
  }
}
