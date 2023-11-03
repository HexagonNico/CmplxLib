package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex

/**
 * Class that represents a four-dimensional complex vector.
 *
 * @constructor Constructs a Vec4c from the three given values
 * @param x X component of the vector
 * @param y Y component of the vector
 * @param z Z component of the vector
 * @param w W component of the vector
 */
case class Vec4c(x: Complex, y: Complex, z: Complex, w: Complex) extends ComplexVector[Vec4c] {

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def +(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Returns the sum between this vector and the one with the given components.
   *
   * This method can be used in place of the '+' operator for better interoperability with Java.
   *
   * @param x X component of the vector to add
   * @param y Y component of the vector to add
   * @param z Z component of the vector to add
   * @param w W component of the vector to add
   * @return The sum of this vector and the one with the given components
   */
  def plus(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this + (x, y, z, w)

  /**
   * Returns the sum between this vector and the given one.
   *
   * @param v The vector to add.
   * @return The sum of this vector and the given one.
   */
  override def +(v: Vec4c): Vec4c = this + (v.x, v.y, v.z, v.w)

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector
   */
  override def unary_- : Vec4c = Vec4c(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def -(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x - x, this.y - y, this.z - z, this.w - w)

  /**
   * Returns the subtraction between this vector and the one with the given components.
   *
   * This method can be used in place of the '-' operator for better interoperability with Java.
   *
   * @param x X component of the vector to subtract
   * @param y Y component of the vector to subtract
   * @param z Z component of the vector to subtract
   * @param w W component of the vector to subtract
   * @return The subtraction of the vector with the given components from this one.
   */
  def minus(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this - (x, y, z, w)

  /**
   * Returns the product between this vector and the given real number.
   *
   * @param r The real number to which the vector is multiplied
   * @return The result of the product between this vector and the given real number
   */
  override def *(r: Double): Vec4c = Vec4c(this.x * r, this.y * r, this.z * r, this.w * r)

  /**
   * Returns the product between this vector and the given complex number.
   *
   * @param z The complex number to which the vector is multiplied
   * @return The result of the product between this vector and the given complex number
   */
  override def *(z: Complex): Vec4c = Vec4c(this.x * z, this.y * z, this.z * z, this.w * z)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def *(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Returns the component-wise multiplication between this vector and the given scalars.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is multiplied
   * @param y Value by which the Y component is multiplied
   * @param z Value by which the Z component is multiplied
   * @param w Value by which the W component is multiplied
   * @return The component-wise multiplication between this vector and the given scalars.
   */
  def multiply(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this * (x, y, z, w)

  /**
   * Returns the component-wise multiplication between this vector and the given one.
   *
   * @param v The second operand of the multiplication.
   * @return The component-wise multiplication between this vector and the given one.
   */
  override def *(v: Vec4c): Vec4c = this * (v.x, v.y, v.z, v.w)

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the one with the given components.
   *
   * @param x X component of the vector by which this one is multiplied
   * @param y Y component of the vector by which this one is multiplied
   * @param z Z component of the vector by which this one is multiplied
   * @param w W component of the vector by which this one is multiplied
   * @return The result of the dot product between this vector and the one with the given components.
   */
  def dot(x: Complex, y: Complex, z: Complex, w: Complex): Complex = this.x * x.conjugate + this.y * y.conjugate + this.z * z.conjugate + this.w * w.conjugate

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The result of the dot product between this vector and the given one
   */
  override def dot(v: Vec4c): Complex = this.dot(v.x, v.y, v.z, v.w)

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
  override def conjugate: Vec4c = Vec4c(this.x.conjugate, this.y.conjugate, this.z.conjugate, this.w.conjugate)

  /**
   * Returns a vector whose components are the multiplicative inverse of this vector's components.
   *
   * @return A vector whose components are the multiplicative inverse of this vector's components
   */
  override def inverse: Vec4c = Vec4c(this.x.inverse, this.y.inverse, this.z.inverse, this.w.inverse)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @param w Value by which the W component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def /(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x / x, this.y / y, this.z / z, this.w / w)

  /**
   * Returns the component-wise division between this vector and the given scalars.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param x Value by which the X component is divided
   * @param y Value by which the Y component is divided
   * @param z Value by which the Z component is divided
   * @param w Value by which the W component is divided
   * @return The component-wise division between this vector and the given scalars.
   */
  def divide(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this / (x, y, z, w)

  /**
   * Returns a vector with all components in absolute value.
   *
   * @return This vector with all components in absolute value
   */
  override def abs: Vec4c = Vec4c(Complex(this.x.abs, 0.0), Complex(this.y.abs, 0.0), Complex(this.z.abs, 0.0), Complex(this.w.abs, 0.0))

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def ==(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the '==' operator for better interoperability with Java.
   *
   * @param x X component of the vector
   * @param y Y component of the vector
   * @param z Z component of the vector
   * @param w W component of the vector
   * @return True if the components of this vector equal the given ones, otherwise false
   */
  def equals(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = this == (x, y, z, w)
}

object Vec4c {

  /** Shorthand for `Vec4c(Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero)` */
  val Zero: Vec4c = Vec4c(Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero)

  /** Shorthand for `Vec4c(Complex.One, Complex.One, Complex.One, Complex.One)` */
  val One: Vec4c = Vec4c(Complex.One, Complex.One, Complex.One, Complex.One)

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
    def *(v: Vec4c): Vec4c = v * r
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
    def *(v: Vec4c): Vec4c = v * z
  }
}
