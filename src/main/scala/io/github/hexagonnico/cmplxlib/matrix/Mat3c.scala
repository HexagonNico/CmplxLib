package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec3c

/**
 * 3x3 complex matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 * @param m20 Element 2 0
 * @param m21 Element 2 1
 * @param m22 Element 2 2
 */
case class Mat3c(
                  m00: Complex, m01: Complex, m02: Complex,
                  m10: Complex, m11: Complex, m12: Complex,
                  m20: Complex, m21: Complex, m22: Complex
                ) extends ComplexMatrix[Mat3c, Vec3c] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat3c): Mat3c = Mat3c(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat3c = Mat3c(
    -this.m00, -this.m01, -this.m02,
    -this.m10, -this.m11, -this.m12,
    -this.m20, -this.m21, -this.m22
  )

  /**
   * Returns the product of this matrix by the given real number.
   *
   * @param r The real number by which this matrix is multiplied
   * @return The product of this matrix by the given real number
   */
  override def *(r: Double): Mat3c = Mat3c(
    this.m00 * r, this.m01 * r, this.m02 * r,
    this.m10 * r, this.m11 * r, this.m12 * r,
    this.m20 * r, this.m21 * r, this.m22 * r
  )

  /**
   * Returns the product of this matrix by the given complex number.
   *
   * @param z The complex number by which this matrix is multiplied
   * @return The product of this matrix by the given complex number
   */
  override def *(z: Complex): Mat3c = Mat3c(
    this.m00 * z, this.m01 * z, this.m02 * z,
    this.m10 * z, this.m11 * z, this.m12 * z,
    this.m20 * z, this.m21 * z, this.m22 * z
  )

  /**
   * Returns the first row of this matrix as a 3d vector.
   *
   * @return The first row of this matrix as a 3d vector
   */
  def row0: Vec3c = Vec3c(this.m00, this.m01, this.m02)

  /**
   * Returns the second row of this matrix as a 3d vector.
   *
   * @return The second row of this matrix as a 3d vector
   */
  def row1: Vec3c = Vec3c(this.m10, this.m11, this.m12)

  /**
   * Returns the third row of this matrix as a 3d vector.
   *
   * @return The third row of this matrix as a 3d vector
   */
  def row2: Vec3c = Vec3c(this.m20, this.m21, this.m22)

  /**
   * Returns the first column of this matrix as a 3d vector.
   *
   * @return The first column of this matrix as a 3d vector
   */
  def col0: Vec3c = Vec3c(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a 3d vector.
   *
   * @return The second column of this matrix as a 3d vector
   */
  def col1: Vec3c = Vec3c(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a 3d vector.
   *
   * @return The third column of this matrix as a 3d vector
   */
  def col2: Vec3c = Vec3c(this.m02, this.m12, this.m22)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec3c): Vec3c = Vec3c(this.row0 dot v, this.row1 dot v, this.row2 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Complex, y: Complex, z: Complex): Vec3c = this * Vec3c(x, y, z)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Complex, y: Complex, z: Complex): Vec3c = this * (x, y, z)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat3c): Mat3c = Mat3c(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat3c = Mat3c(
    this.m00, this.m10, this.m20,
    this.m01, this.m11, this.m21,
    this.m02, this.m12, this.m22
  )

  /**
   * Returns the complex conjugate of this matrix.
   *
   * The conjugate of a matrix is a matrix where every element is its complex conjugate.
   *
   * @return The complex conjugate of this matrix
   */
  override def conjugate: Mat3c = Mat3c(
    this.m00.conjugate, this.m01.conjugate, this.m02.conjugate,
    this.m10.conjugate, this.m11.conjugate, this.m12.conjugate,
    this.m20.conjugate, this.m21.conjugate, this.m22.conjugate
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat3c = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat3c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Complex = m00 * m11 * m22 + m01 * m12 * m20 + m02 * m10 * m21 - m02 * m11 * m20 - m01 * m10 * m22 - m00 * m12 * m21
}

object Mat3c {

  /** Shorthand for an identity matrix */
  val Identity: Mat3c = Mat3c(Complex.One, Complex.Zero, Complex.Zero, Complex.Zero, Complex.One, Complex.Zero, Complex.Zero, Complex.Zero, Complex.One)

  /** Shorthand for a zero matrix */
  val Zero: Mat3c = Mat3c(Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero)

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
    def *(m: Mat3c): Mat3c = m * r
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
    def *(m: Mat3c): Mat3c = m * z
  }
}
