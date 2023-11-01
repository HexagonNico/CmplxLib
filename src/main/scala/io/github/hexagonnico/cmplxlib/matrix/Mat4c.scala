package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec4c

/**
 * 4x4 complex matrix.
 *
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m02 Element 0 2
 * @param m03 Element 0 3
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 * @param m12 Element 1 2
 * @param m13 Element 1 3
 * @param m20 Element 2 0
 * @param m21 Element 2 1
 * @param m22 Element 2 2
 * @param m23 Element 2 3
 * @param m30 Element 3 0
 * @param m31 Element 3 1
 * @param m32 Element 3 2
 * @param m33 Element 3 3
 */
case class Mat4c(
                  m00: Complex, m01: Complex, m02: Complex, m03: Complex,
                  m10: Complex, m11: Complex, m12: Complex, m13: Complex,
                  m20: Complex, m21: Complex, m22: Complex, m23: Complex,
                  m30: Complex, m31: Complex, m32: Complex, m33: Complex
                ) extends ComplexMatrix[Mat4c, Vec4c] {

  /**
   * Returns the sum between this matrix and the given one.
   *
   * @param m The matrix to add
   * @return The sum between this matrix and the given one
   */
  override def +(m: Mat4c): Mat4c = Mat4c(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix
   */
  override def unary_- : Mat4c = Mat4c(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  /**
   * Returns the product of this matrix by the given real number.
   *
   * @param r The real number by which this matrix is multiplied
   * @return The product of this matrix by the given real number
   */
  override def *(r: Double): Mat4c = Mat4c(
    this.m00 * r, this.m01 * r, this.m02 * r, this.m03 * r,
    this.m10 * r, this.m11 * r, this.m12 * r, this.m13 * r,
    this.m20 * r, this.m21 * r, this.m22 * r, this.m23 * r,
    this.m30 * r, this.m31 * r, this.m32 * r, this.m33 * r
  )

  /**
   * Returns the product of this matrix by the given complex number.
   *
   * @param z The complex number by which this matrix is multiplied
   * @return The product of this matrix by the given complex number
   */
  override def *(z: Complex): Mat4c = Mat4c(
    this.m00 * z, this.m01 * z, this.m02 * z, this.m03 * z,
    this.m10 * z, this.m11 * z, this.m12 * z, this.m13 * z,
    this.m20 * z, this.m21 * z, this.m22 * z, this.m23 * z,
    this.m30 * z, this.m31 * z, this.m32 * z, this.m33 * z
  )

  /**
   * Returns the first row of this matrix as a 4d vector.
   *
   * @return The first row of this matrix as a 4d vector
   */
  def row0: Vec4c = Vec4c(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a 4d vector.
   *
   * @return The second row of this matrix as a 4d vector
   */
  def row1: Vec4c = Vec4c(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a 4d vector.
   *
   * @return The third row of this matrix as a 4d vector
   */
  def row2: Vec4c = Vec4c(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a 4d vector.
   *
   * @return The fourth row of this matrix as a 4d vector
   */
  def row3: Vec4c = Vec4c(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the first column of this matrix as a 4d vector.
   *
   * @return The first column of this matrix as a 4d vector
   */
  def col0: Vec4c = Vec4c(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a 4d vector.
   *
   * @return The second column of this matrix as a 4d vector
   */
  def col1: Vec4c = Vec4c(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a 4d vector.
   *
   * @return The third column of this matrix as a 4d vector
   */
  def col2: Vec4c = Vec4c(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a 4d vector.
   *
   * @return The fourth column of this matrix as a 4d vector
   */
  def col3: Vec4c = Vec4c(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the product of this matrix by the given vector.
   *
   * @param v The vector by which this matrix is multiplied
   * @return The product of this matrix by the given vector
   */
  override def *(v: Vec4c): Vec4c = Vec4c(this.row0 dot v, this.row1 dot v, this.row2 dot v, this.row3 dot v)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @param w W component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def *(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this * Vec4c(x, y, z, w)

  /**
   * Returns the product of this matrix by the vector with the given components.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param x X component of the vector by which this matrix is multiplied
   * @param y Y component of the vector by which this matrix is multiplied
   * @param z Z component of the vector by which this matrix is multiplied
   * @param w W component of the vector by which this matrix is multiplied
   * @return The product between this matrix and the vector with the given components
   */
  def multiply(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this * (x, y, z, w)

  /**
   * Returns the product between this matrix and the given one.
   *
   * @param m The matrix by which this one is multiplied
   * @return The product between this matrix and the given one
   */
  override def *(m: Mat4c): Mat4c = Mat4c(
    this.row0 dot m.col0, this.row0 dot m.col1, this.row0 dot m.col2, this.row0 dot m.col3,
    this.row1 dot m.col0, this.row1 dot m.col1, this.row1 dot m.col2, this.row1 dot m.col3,
    this.row2 dot m.col0, this.row2 dot m.col1, this.row2 dot m.col2, this.row2 dot m.col3,
    this.row3 dot m.col0, this.row3 dot m.col1, this.row3 dot m.col2, this.row3 dot m.col3
  )

  /**
   * Returns the transposed of this matrix.
   *
   * @return The transposed of this matrix
   */
  override def transposed: Mat4c = Mat4c(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  /**
   * Returns the complex conjugate of this matrix.
   *
   * The conjugate of a matrix is a matrix where every element is its complex conjugate.
   *
   * @return The complex conjugate of this matrix
   */
  override def conjugate: Mat4c = Mat4c(
    this.m00.conjugate, this.m01.conjugate, this.m02.conjugate, this.m03.conjugate,
    this.m10.conjugate, this.m11.conjugate, this.m12.conjugate, this.m13.conjugate,
    this.m20.conjugate, this.m21.conjugate, this.m22.conjugate, this.m23.conjugate,
    this.m30.conjugate, this.m31.conjugate, this.m32.conjugate, this.m33.conjugate
  )

  /**
   * Returns this matrix to the power of the given exponent.
   *
   * @param exp The exponent
   * @return This matrix raised to the power of the given exponent
   */
  override def power(exp: Int): Mat4c = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat4c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  override def determinant: Complex = this.m00 * Mat3c(
    this.m11, this.m12, this.m13,
    this.m21, this.m22, this.m23,
    this.m31, this.m32, this.m33
  ).determinant - this.m01 * Mat3c(
    this.m10, this.m12, this.m13,
    this.m20, this.m22, this.m23,
    this.m30, this.m32, this.m33
  ).determinant + this.m02 * Mat3c(
    this.m10, this.m11, this.m13,
    this.m20, this.m21, this.m23,
    this.m30, this.m31, this.m33
  ).determinant - this.m03 * Mat3c(
    this.m10, this.m11, this.m12,
    this.m20, this.m21, this.m22,
    this.m30, this.m31, this.m32
  ).determinant
}

object Mat4c {

  /** Shorthand for an identity matrix */
  val Identity: Mat4c = Mat4c(
    Complex.One, Complex.Zero, Complex.Zero, Complex.Zero,
    Complex.Zero, Complex.One, Complex.Zero, Complex.Zero,
    Complex.Zero, Complex.Zero, Complex.One, Complex.Zero,
    Complex.Zero, Complex.Zero, Complex.Zero, Complex.One
  )

  /** Shorthand for a zero matrix */
  val Zero: Mat4c = Mat4c(
    Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero,
    Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero,
    Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero,
    Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero
  )

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
    def *(m: Mat4c): Mat4c = m * r
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
    def *(m: Mat4c): Mat4c = m * z
  }
}
