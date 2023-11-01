package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec2c

/**
 * 2x2 complex matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 */
case class Mat2c(m00: Complex, m01: Complex, m10: Complex, m11: Complex) extends ComplexMatrix[Mat2c, Vec2c] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat2c): Mat2c = Mat2c(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat2c = Mat2c(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  /**
   * Returns the product of this matrix by the given real number.
   *
   * @param r The real number by which this matrix is multiplied
   * @return The product of this matrix by the given real number
   */
  override def *(r: Double): Mat2c = Mat2c(
    this.m00 * r, this.m01 * r,
    this.m10 * r, this.m11 * r
  )

  /**
   * Returns the product of this matrix by the given complex number.
   *
   * @param z The complex number by which this matrix is multiplied
   * @return The product of this matrix by the given complex number
   */
  override def *(z: Complex): Mat2c = Mat2c(
    this.m00 * z, this.m01 * z,
    this.m10 * z, this.m11 * z
  )

  /**
   * Returns the first row of this matrix as a 2d vector.
   *
   * @return The first row of this matrix as a 2d vector
   */
  def row0: Vec2c = Vec2c(this.m00, this.m01)

  /**
   * Returns the second row of this matrix as a 2d vector.
   *
   * @return The second row of this matrix as a 2d vector
   */
  def row1: Vec2c = Vec2c(this.m10, this.m11)

  /**
   * Returns the first column of this matrix as a 2d vector.
   *
   * @return The first column of this matrix as a 2d vector
   */
  def col0: Vec2c = Vec2c(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a 2d vector.
   *
   * @return The second column of this matrix as a 2d vector
   */
  def col1: Vec2c = Vec2c(this.m01, this.m11)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec2c): Vec2c = Vec2c(this.row0 dot v, this.row1 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Complex, y: Complex): Vec2c = this * Vec2c(x, y)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Complex, y: Complex): Vec2c = this * (x, y)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat2c): Mat2c = Mat2c(
    this.row0 dot m.col0, this.row0 dot m.col1,
    this.row1 dot m.col0, this.row1 dot m.col1
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat2c = Mat2c(
    this.m00, this.m10,
    this.m01, this.m11
  )

  /**
   * Returns the complex conjugate of this matrix.
   *
   * The conjugate of a matrix is a matrix where every element is its complex conjugate.
   *
   * @return The complex conjugate of this matrix
   */
  override def conjugate: Mat2c = Mat2c(
    this.m00.conjugate, this.m01.conjugate,
    this.m10.conjugate, this.m11.conjugate
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat2c = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat2c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Complex = this.m00 * this.m11 - this.m01 * this.m10
}

object Mat2c {

  /** Shorthand for Mat2c(1.0, 0.0, 0.0, 1.0) */
  val Identity: Mat2c = Mat2c(Complex.One, Complex.Zero, Complex.Zero, Complex.One)

  /** Shorthand for Mat2c(0.0, 0.0, 0.0, 0.0) */
  val Zero: Mat2c = Mat2c(Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero)

  /**
   * Allows to use the operator '*' with a real number as `1.0 * matrix`.
   *
   * @param r The real number
   */
  implicit class RealExtender(val r: Double) extends AnyVal {

    /**
     * Returns the product between this real number and the given matrix.
     *
     * @param m The matrix to which the number is multiplied
     * @return The result of the product between this number and the given matrix
     */
    def *(m: Mat2c): Mat2c = m * r
  }

  /**
   * Allows to use the operator '*' with a complex number as `z * matrix`.
   *
   * @param z The complex number
   */
  implicit class ComplexExtender(val z: Complex) extends AnyVal {

    /**
     * Returns the product between this complex number and the given matrix.
     *
     * @param m The matrix to which the number is multiplied
     * @return The result of the product between this number and the given matrix
     */
    def *(m: Mat2c): Mat2c = m * z
  }
}