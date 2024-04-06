package io.github.scalamath.cmplxlib

import io.github.scalamath.vecmatlib.Mat4d

/**
 * A 4x4 complex matrix.
 *
 * @constructor Constructs a matrix from the given values.
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
                ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat4c): Mat4c = Mat4c(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23,
    this.m30 + m.m30, this.m31 + m.m31, this.m32 + m.m32, this.m33 + m.m33
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat4c): Mat4c = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+ : Mat4c = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat4c): Mat4c = Mat4c(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02, this.m03 - m.m03,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12, this.m13 - m.m13,
    this.m20 - m.m20, this.m21 - m.m21, this.m22 - m.m22, this.m23 - m.m23,
    this.m30 - m.m30, this.m31 - m.m31, this.m32 - m.m32, this.m33 - m.m33
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat4c): Mat4c = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat4c = Mat4c(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23,
    -this.m30, -this.m31, -this.m32, -this.m33
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat4c = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Complex): Mat4c = Mat4c(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Complex): Mat4c = this * k

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat4c = Mat4c(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k,
    this.m30 * k, this.m31 * k, this.m32 * k, this.m33 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Double): Mat4c = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Complex): Mat4c = Mat4c(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k,
    this.m30 / k, this.m31 / k, this.m32 / k, this.m33 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Complex): Mat4c = this / k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat4c = Mat4c(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k,
    this.m30 / k, this.m31 / k, this.m32 / k, this.m33 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat4c = this / k

  /**
   * Returns the first row of this matrix as a [[Vec4c]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec4c = Vec4c(this.m00, this.m01, this.m02, this.m03)

  /**
   * Returns the second row of this matrix as a [[Vec4c]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec4c = Vec4c(this.m10, this.m11, this.m12, this.m13)

  /**
   * Returns the third row of this matrix as a [[Vec4c]].
   *
   * @return The third row of this matrix.
   * @see [[row]]
   */
  def row2: Vec4c = Vec4c(this.m20, this.m21, this.m22, this.m23)

  /**
   * Returns the fourth row of this matrix as a [[Vec4c]].
   *
   * @return The fourth row of this matrix.
   * @see [[row]]
   */
  def row3: Vec4c = Vec4c(this.m30, this.m31, this.m32, this.m33)

  /**
   * Returns the row at the given index as a [[Vec4c]].
   *
   * @param i The index of the requested row. Must be either 0, 1, 2, or 3.
   * @return The row at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], [[row2]], and [[row3]]
   */
  def row(i: Int): Vec4c = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
    case 3 => this.row3
  }

  /**
   * Returns the first column of this matrix as a [[Vec4c]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec4c = Vec4c(this.m00, this.m10, this.m20, this.m30)

  /**
   * Returns the second column of this matrix as a [[Vec4c]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec4c = Vec4c(this.m01, this.m11, this.m21, this.m31)

  /**
   * Returns the third column of this matrix as a [[Vec4c]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec4c = Vec4c(this.m02, this.m12, this.m22, this.m32)

  /**
   * Returns the fourth column of this matrix as a [[Vec4c]].
   *
   * @return The fourth column of this matrix.
   * @see [[col]]
   */
  def col3: Vec4c = Vec4c(this.m03, this.m13, this.m23, this.m33)

  /**
   * Returns the column at the given index as a [[Vec4c]].
   *
   * @param i The index of the requested column. Must be either 0, 1, 2, or 3.
   * @return The column at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], [[col2]], and [[col3]]
   */
  def col(i: Int): Vec4c = i match {
    case 0 => this.col0
    case 1 => this.col1
    case 2 => this.col2
    case 3 => this.col3
  }

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(
    this.m00 * x + this.m01 * y + this.m02 * z + this.m03 * w,
    this.m10 * x + this.m11 * y + this.m12 * z + this.m13 * w,
    this.m20 * x + this.m21 * y + this.m22 * z + this.m23 * w,
    this.m30 * x + this.m31 * y + this.m32 * z + this.m33 * w
  )

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this * (x, y, z, w)

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec4c): Vec4c = this * (v.x, v.y, v.z, v.w)

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec4c): Vec4c = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xyz: Vec3c, w: Complex): Vec4c = this * (xyz.x, xyz.y, xyz.z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xyz: Vec3c, w: Complex): Vec4c = this * (xyz, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xy: Vec2c, z: Complex, w: Complex): Vec4c = this * (xy.x, xy.y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 2D point.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(xy: Vec2c, z: Complex, w: Complex): Vec4c = this * (xy, z, w)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat4c): Mat4c = Mat4c(
    this.m00 * m.m00 + this.m01 * m.m10 + this.m02 * m.m20 + this.m03 * m.m30,
    this.m00 * m.m01 + this.m01 * m.m11 + this.m02 * m.m21 + this.m03 * m.m31,
    this.m00 * m.m02 + this.m01 * m.m12 + this.m02 * m.m22 + this.m03 * m.m32,
    this.m00 * m.m03 + this.m01 * m.m13 + this.m02 * m.m23 + this.m03 * m.m33,
    this.m10 * m.m00 + this.m11 * m.m10 + this.m12 * m.m20 + this.m13 * m.m30,
    this.m10 * m.m01 + this.m11 * m.m11 + this.m12 * m.m21 + this.m13 * m.m31,
    this.m10 * m.m02 + this.m11 * m.m12 + this.m12 * m.m22 + this.m13 * m.m32,
    this.m10 * m.m03 + this.m11 * m.m13 + this.m12 * m.m23 + this.m13 * m.m33,
    this.m20 * m.m00 + this.m21 * m.m10 + this.m22 * m.m20 + this.m23 * m.m30,
    this.m20 * m.m01 + this.m21 * m.m11 + this.m22 * m.m21 + this.m23 * m.m31,
    this.m20 * m.m02 + this.m21 * m.m12 + this.m22 * m.m22 + this.m23 * m.m32,
    this.m20 * m.m03 + this.m21 * m.m13 + this.m22 * m.m23 + this.m23 * m.m33,
    this.m30 * m.m00 + this.m31 * m.m10 + this.m32 * m.m20 + this.m33 * m.m30,
    this.m30 * m.m01 + this.m31 * m.m11 + this.m32 * m.m21 + this.m33 * m.m31,
    this.m30 * m.m02 + this.m31 * m.m12 + this.m32 * m.m22 + this.m33 * m.m32,
    this.m30 * m.m03 + this.m31 * m.m13 + this.m32 * m.m23 + this.m33 * m.m33
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat4c): Mat4c = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat4c = Mat4c(
    this.m00, this.m10, this.m20, this.m30,
    this.m01, this.m11, this.m21, this.m31,
    this.m02, this.m12, this.m22, this.m32,
    this.m03, this.m13, this.m23, this.m33
  )

  /**
   * Returns the conjugate of this complex matrix.
   *
   * @return The conjugate of this complex matrix.
   */
  def conjugate: Mat4c = Mat4c(
    this.m00.conjugate, this.m01.conjugate, this.m02.conjugate, this.m03.conjugate,
    this.m10.conjugate, this.m11.conjugate, this.m12.conjugate, this.m13.conjugate,
    this.m20.conjugate, this.m21.conjugate, this.m22.conjugate, this.m23.conjugate,
    this.m30.conjugate, this.m31.conjugate, this.m32.conjugate, this.m33.conjugate
  )

  /**
   * Checks if this matrix is symmetric by checking if it is equal to its [[transposed]].
   *
   * @return True if this matrix is equal to its transposed, otherwise false.
   */
  def isSymmetric: Boolean = this == this.transposed

  /**
   * Checks if this matrix is skew-symmetric by checking if it is equal to its [[negated]] [[transposed]].
   *
   * @return True if this matrix is equal to its negated transposed, otherwise false.
   */
  def isSkewSymmetric: Boolean = this == this.negated.transposed

  /**
   * Checks if this matrix is hermitian by checking if it is equal to its [[conjugate]] [[transposed]].
   *
   * @return True if this matrix is equal to its conjugate transposed, otherwise false.
   */
  def isHermitian: Boolean = this == this.conjugate.transposed

  /**
   * Returns a submatrix of this matrix obtained by removing the row at index `i` and the column at index `j`.
   *
   * @param i Index of the row to remove. Must be either 0, 1, 2, or 3.
   * @param j Index of the column to remove. Must be either 0, 1, 2, or 3.
   * @return A submatrix of this matrix.
   * @throws MatchError if one of the given indices is out of bounds.
   */
  def submatrix(i: Int, j: Int): Mat3c = (i, j) match {
    case (0, 0) => Mat3c(this.m11, this.m12, this.m13, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (0, 1) => Mat3c(this.m10, this.m12, this.m13, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (0, 2) => Mat3c(this.m10, this.m11, this.m13, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (0, 3) => Mat3c(this.m10, this.m11, this.m12, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32)
    case (1, 0) => Mat3c(this.m01, this.m02, this.m03, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33)
    case (1, 1) => Mat3c(this.m00, this.m02, this.m03, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33)
    case (1, 2) => Mat3c(this.m00, this.m01, this.m03, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33)
    case (1, 3) => Mat3c(this.m00, this.m01, this.m02, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32)
    case (2, 0) => Mat3c(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m31, this.m32, this.m33)
    case (2, 1) => Mat3c(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m30, this.m32, this.m33)
    case (2, 2) => Mat3c(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m30, this.m31, this.m33)
    case (2, 3) => Mat3c(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m30, this.m31, this.m32)
    case (3, 0) => Mat3c(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m21, this.m22, this.m23)
    case (3, 1) => Mat3c(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23)
    case (3, 2) => Mat3c(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23)
    case (3, 3) => Mat3c(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22)
  }

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Complex = this.m00 * this.submatrix(0, 0).determinant - this.m01 * this.submatrix(0, 1).determinant + this.m02 * this.submatrix(0, 2).determinant - this.m03 * this.submatrix(0, 3).determinant

  /**
   * Returns the adjugate of this matrix.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat4c = Mat4c(
    this.submatrix(0, 0).determinant, -this.submatrix(1, 0).determinant, this.submatrix(2, 0).determinant, -this.submatrix(3, 0).determinant,
    -this.submatrix(0, 1).determinant, this.submatrix(1, 1).determinant, -this.submatrix(2, 1).determinant, this.submatrix(3, 1).determinant,
    this.submatrix(0, 2).determinant, -this.submatrix(1, 2).determinant, this.submatrix(2, 2).determinant, -this.submatrix(3, 2).determinant,
    -this.submatrix(0, 3).determinant, this.submatrix(1, 3).determinant, -this.submatrix(2, 3).determinant, this.submatrix(3, 3).determinant
  )

  /**
   * Returns the inverse of this matrix.
   *
   * The result is undefined if this matrix is not invertible.
   * It is possible to check if the matrix is invertible by checking if its [[determinant]] is not zero.
   *
   * @return The inverse of this matrix.
   */
  def inverse: Mat4c = this.adjugate / this.determinant

  /**
   * Raises this matrix to the given power by multiplying it with itself `exp` times and returns the result.
   *
   * If the given exponent is zero, the result will be the identity matrix.
   *
   * A matrix raised to a negative power is defined as the [[inverse]] matrix raised to `-exp`.
   * The result is undefined if the given exponent is negative and this matrix is not invertible.
   *
   * @param exp The exponent to raise this matrix to.
   * @return This matrix raised to the given power.
   */
  def power(exp: Int): Mat4c = {
    if (exp < 0) {
      this.inverse.power(-exp)
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat4c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat4c = Mat4c(
    Complex.abs(this.m00), Complex.abs(this.m01), Complex.abs(this.m02), Complex.abs(this.m03),
    Complex.abs(this.m10), Complex.abs(this.m11), Complex.abs(this.m12), Complex.abs(this.m13),
    Complex.abs(this.m20), Complex.abs(this.m21), Complex.abs(this.m22), Complex.abs(this.m23),
    Complex.abs(this.m30), Complex.abs(this.m31), Complex.abs(this.m32), Complex.abs(this.m33)
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat4c = {
    var (v0, v1, v2, v3) = (this.col0, this.col1, this.col2, this.col3)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    v3 = v3 - v3.project(v0) - v3.project(v1) - v3.project(v2)
    Mat4c.fromColumns(v0.normalized, v1.normalized, v2.normalized, v3.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat4c): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) && (this.m03 ~= m.m03) &&
    (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12) && (this.m13 ~= m.m13) &&
    (this.m20 ~= m.m20) && (this.m21 ~= m.m21) && (this.m22 ~= m.m22) && (this.m23 ~= m.m23) &&
    (this.m30 ~= m.m30) && (this.m31 ~= m.m31) && (this.m32 ~= m.m32) && (this.m33 ~= m.m33)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat4c): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, 2, or 3.
   * @param col The column index of the desired element. Must be either 0, 1, 2, or 3.
   * @return The element at the given row and column index.
   * @throws MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Complex = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (0, 2) => this.m02
    case (0, 3) => this.m03
    case (1, 0) => this.m10
    case (1, 1) => this.m11
    case (1, 2) => this.m12
    case (1, 3) => this.m13
    case (2, 0) => this.m20
    case (2, 1) => this.m21
    case (2, 2) => this.m22
    case (2, 3) => this.m23
    case (3, 0) => this.m30
    case (3, 1) => this.m31
    case (3, 2) => this.m32
    case (3, 3) => this.m33
  }

  /**
   * Returns a matrix whose elements are the real part of the elements of this matrix.
   *
   * @return A matrix whose elements are the real part of the elements of this matrix.
   */
  def real: Mat4d = Mat4d(
    this.m00.real, this.m01.real, this.m02.real, this.m03.real,
    this.m10.real, this.m11.real, this.m12.real, this.m13.real,
    this.m20.real, this.m21.real, this.m22.real, this.m23.real,
    this.m30.real, this.m31.real, this.m32.real, this.m33.real
  )

  /**
   * Returns a matrix whose elements are the imaginary part of the elements of this matrix.
   *
   * @return A matrix whose elements are the imaginary part of the elements of this matrix.
   */
  def imaginary: Mat4d = Mat4d(
    this.m00.imaginary, this.m01.imaginary, this.m02.imaginary, this.m03.imaginary,
    this.m10.imaginary, this.m11.imaginary, this.m12.imaginary, this.m13.imaginary,
    this.m20.imaginary, this.m21.imaginary, this.m22.imaginary, this.m23.imaginary,
    this.m30.imaginary, this.m31.imaginary, this.m32.imaginary, this.m33.imaginary
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat4c {

  /** Shorthand for the zero matrix */
  val Zero: Mat4c = Mat4c(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /** Shorthand for the identity matrix */
  val Identity: Mat4c = Mat4c(1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0)

  /**
   * Returns a 4x4 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @param row3 The fourth row.
   * @return A 4x4 matrix from the given rows.
   */
  def fromRows(row0: Vec4c, row1: Vec4c, row2: Vec4c, row3: Vec4c): Mat4c = Mat4c(
    row0.x, row0.y, row0.z, row0.w,
    row1.x, row1.y, row1.z, row1.w,
    row2.x, row2.y, row2.z, row2.w,
    row3.x, row3.y, row3.z, row3.w
  )

  /**
   * Returns a 4x4 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @param col3 The fourth column.
   * @return A 4x4 matrix from the given columns.
   */
  def fromColumns(col0: Vec4c, col1: Vec4c, col2: Vec4c, col3: Vec4c): Mat4c = Mat4c(
    col0.x, col1.x, col2.x, col3.x,
    col0.y, col1.y, col2.y, col3.y,
    col0.z, col1.z, col2.z, col3.z,
    col0.w, col1.w, col2.w, col3.w
  )

  /**
   * Allows to use the `*` operator with a complex number as `z * matrix`.
   *
   * @param self The scalar value.
   */
  implicit class ComplexExtender(val self: Complex) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Mat4c): Mat4c = v * self
  }

  /**
   * Allows to use the `*` operator with a real number as `k * matrix`.
   *
   * @param self The scalar value.
   */
  implicit class RealExtender(val self: Double) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Mat4c): Mat4c = v * self
  }

  /**
   * Implicit conversion from [[Mat4d]] to [[Mat4c]].
   */
  implicit val mat4dToMat4c: Mat4d => Mat4c = m => Mat4c(m.m00, m.m01, m.m02, m.m03, m.m10, m.m11, m.m12, m.m13, m.m20, m.m21, m.m22, m.m23, m.m30, m.m31, m.m32, m.m33)
}
