package io.github.scalamath.cmplxlib

import io.github.scalamath.vecmatlib.Mat3x4d

/**
 * A 3x4 (three rows and four columns) complex matrix.
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
 */
case class Mat3x4c(
                    m00: Complex, m01: Complex, m02: Complex, m03: Complex,
                    m10: Complex, m11: Complex, m12: Complex, m13: Complex,
                    m20: Complex, m21: Complex, m22: Complex, m23: Complex
                  ) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat3x4c): Mat3x4c = Mat3x4c(
    this.m00 + m.m00, this.m01 + m.m01, this.m02 + m.m02, this.m03 + m.m03,
    this.m10 + m.m10, this.m11 + m.m11, this.m12 + m.m12, this.m13 + m.m13,
    this.m20 + m.m20, this.m21 + m.m21, this.m22 + m.m22, this.m23 + m.m23
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat3x4c): Mat3x4c = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This matrix.
   */
  def unary_+ : Mat3x4c = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat3x4c): Mat3x4c = Mat3x4c(
    this.m00 - m.m00, this.m01 - m.m01, this.m02 - m.m02, this.m03 - m.m03,
    this.m10 - m.m10, this.m11 - m.m11, this.m12 - m.m12, this.m13 - m.m13,
    this.m20 - m.m20, this.m21 - m.m21, this.m22 - m.m22, this.m23 - m.m23
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat3x4c): Mat3x4c = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat3x4c = Mat3x4c(
    -this.m00, -this.m01, -this.m02, -this.m03,
    -this.m10, -this.m11, -this.m12, -this.m13,
    -this.m20, -this.m21, -this.m22, -this.m23
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat3x4c = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Complex): Mat3x4c = Mat3x4c(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Complex): Mat3x4c = this * k

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat3x4c = Mat3x4c(
    this.m00 * k, this.m01 * k, this.m02 * k, this.m03 * k,
    this.m10 * k, this.m11 * k, this.m12 * k, this.m13 * k,
    this.m20 * k, this.m21 * k, this.m22 * k, this.m23 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Double): Mat3x4c = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Complex): Mat3x4c = Mat3x4c(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Complex): Mat3x4c = this / k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat3x4c = Mat3x4c(
    this.m00 / k, this.m01 / k, this.m02 / k, this.m03 / k,
    this.m10 / k, this.m11 / k, this.m12 / k, this.m13 / k,
    this.m20 / k, this.m21 / k, this.m22 / k, this.m23 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat3x4c = this / k

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
   * Returns the row at the given index as a [[Vec4c]].
   *
   * @param i The index of the requested row. Must be either 0, 1, or 2.
   * @return The row at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[row0]], [[row1]], and [[row2]]
   */
  def row(i: Int): Vec4c = i match {
    case 0 => this.row0
    case 1 => this.row1
    case 2 => this.row2
  }

  /**
   * Returns the first column of this matrix as a [[Vec3c]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec3c = Vec3c(this.m00, this.m10, this.m20)

  /**
   * Returns the second column of this matrix as a [[Vec3c]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec3c = Vec3c(this.m01, this.m11, this.m21)

  /**
   * Returns the third column of this matrix as a [[Vec3c]].
   *
   * @return The third column of this matrix.
   * @see [[col]]
   */
  def col2: Vec3c = Vec3c(this.m02, this.m12, this.m22)

  /**
   * Returns the fourth column of this matrix as a [[Vec3c]].
   *
   * @return The fourth column of this matrix.
   * @see [[col]]
   */
  def col3: Vec3c = Vec3c(this.m03, this.m13, this.m23)

  /**
   * Returns the column at the given index as a [[Vec3c]].
   *
   * @param i The index of the requested column. Must be either 0, 1, 2, or 3.
   * @return The column at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[col0]], [[col1]], [[col2]], and [[col3]]
   */
  def col(i: Int): Vec3c = i match {
    case 0 => this.col0
    case 1 => this.col1
    case 2 => this.col2
    case 3 => this.col3
  }

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec4c): Vec3c = Vec3c(this.row0.dot(v), this.row1.dot(v), this.row2.dot(v))

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec4c): Vec3c = this * v

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Complex, y: Complex, z: Complex, w: Complex): Vec3c = this * Vec4c(x, y, z, w)

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
  def multiply(x: Complex, y: Complex, z: Complex, w: Complex): Vec3c = this * (x, y, z, w)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * Useful to simplify the transformation of a 3D point.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(xyz: Vec3c, w: Complex): Vec3c = this * (xyz.x, xyz.y, xyz.z, w)

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
  def multiply(xyz: Vec3c, w: Complex): Vec3c = this * (xyz, w)

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
  def *(xy: Vec2c, z: Complex, w: Complex): Vec3c = this * (xy.x, xy.y, z, w)

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
  def multiply(xy: Vec2c, z: Complex, w: Complex): Vec3c = this * (xy, z, w)

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat4c): Mat3x4c = Mat3x4c(
    this.row0.dot(m.col0), this.row0.dot(m.col1), this.row0.dot(m.col2), this.row0.dot(m.col3),
    this.row1.dot(m.col0), this.row1.dot(m.col1), this.row1.dot(m.col2), this.row1.dot(m.col3),
    this.row2.dot(m.col0), this.row2.dot(m.col1), this.row2.dot(m.col2), this.row2.dot(m.col3),
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat4c): Mat3x4c = this * m

  /**
   * Returns the conjugate of this complex matrix.
   *
   * @return The conjugate of this complex matrix.
   */
  def conjugate: Mat3x4c = Mat3x4c(
    this.m00.conjugate, this.m01.conjugate, this.m02.conjugate, this.m03.conjugate,
    this.m10.conjugate, this.m11.conjugate, this.m12.conjugate, this.m13.conjugate,
    this.m20.conjugate, this.m21.conjugate, this.m22.conjugate, this.m23.conjugate
  )

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat3x4c = Mat3x4c(
    Complex.abs(this.m00), Complex.abs(this.m01), Complex.abs(this.m02), Complex.abs(this.m03),
    Complex.abs(this.m10), Complex.abs(this.m11), Complex.abs(this.m12), Complex.abs(this.m13),
    Complex.abs(this.m20), Complex.abs(this.m21), Complex.abs(this.m22), Complex.abs(this.m23)
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat3x4c = {
    var (v0, v1, v2, v3) = (this.col0, this.col1, this.col2, this.col3)
    v1 = v1 - v1.project(v0)
    v2 = v2 - v2.project(v0) - v2.project(v1)
    v3 = v3 - v3.project(v0) - v3.project(v1) - v3.project(v2)
    Mat3x4c.fromColumns(v0.normalized, v1.normalized, v2.normalized, v3.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat3x4c): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m02 ~= m.m02) && (this.m03 ~= m.m03) &&
    (this.m10 ~= m.m10) && (this.m11 ~= m.m11) && (this.m12 ~= m.m12) && (this.m13 ~= m.m13) &&
    (this.m20 ~= m.m20) && (this.m21 ~= m.m21) && (this.m22 ~= m.m22) && (this.m23 ~= m.m23)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat3x4c): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0, 1, or 2.
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
  }

  /**
   * Returns a matrix whose elements are the real part of the elements of this matrix.
   *
   * @return A matrix whose elements are the real part of the elements of this matrix.
   */
  def real: Mat3x4d = Mat3x4d(
    this.m00.real, this.m01.real, this.m02.real, this.m03.real,
    this.m10.real, this.m11.real, this.m12.real, this.m13.real,
    this.m20.real, this.m21.real, this.m22.real, this.m23.real
  )

  /**
   * Returns a matrix whose elements are the imaginary part of the elements of this matrix.
   *
   * @return A matrix whose elements are the imaginary part of the elements of this matrix.
   */
  def imaginary: Mat3x4d = Mat3x4d(
    this.m00.imaginary, this.m01.imaginary, this.m02.imaginary, this.m03.imaginary,
    this.m10.imaginary, this.m11.imaginary, this.m12.imaginary, this.m13.imaginary,
    this.m20.imaginary, this.m21.imaginary, this.m22.imaginary, this.m23.imaginary
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat3x4c {

  /** Shorthand for the zero matrix */
  val Zero: Mat3x4c = Mat3x4c(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)

  /**
   * Returns a 3x4 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @param row2 The third row.
   * @return A 3x4 matrix from the given rows.
   */
  def fromRows(row0: Vec4c, row1: Vec4c, row2: Vec4c): Mat3x4c = Mat3x4c(
    row0.x, row0.y, row0.z, row0.w,
    row1.x, row1.y, row1.z, row1.w,
    row2.x, row2.y, row2.z, row2.w
  )

  /**
   * Returns a 3x4 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @param col2 The third column.
   * @param col3 The fourth column.
   * @return A 3x4 matrix from the given columns.
   */
  def fromColumns(col0: Vec3c, col1: Vec3c, col2: Vec3c, col3: Vec3c): Mat3x4c = Mat3x4c(
    col0.x, col1.x, col2.x, col3.x,
    col0.y, col1.y, col2.y, col3.y,
    col0.z, col1.z, col2.z, col3.z
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
    def *(v: Mat3x4c): Mat3x4c = v * self
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
    def *(v: Mat3x4c): Mat3x4c = v * self
  }

  /**
   * Implicit conversion from [[Mat3x4d]] to [[Mat3x4c]].
   */
  implicit val mat3x4dToMat3x4c: Mat3x4d => Mat3x4c = m => Mat3x4c(m.m00, m.m01, m.m02, m.m03, m.m10, m.m11, m.m12, m.m13, m.m20, m.m21, m.m22, m.m23)
}