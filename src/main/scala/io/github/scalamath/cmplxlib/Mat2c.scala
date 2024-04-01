package io.github.scalamath.cmplxlib

import io.github.scalamath.vecmatlib.Mat2d

/**
 * A 2x2 complex matrix.
 *
 * @constructor Constructs a matrix from the given values.
 * @param m00 Element 0 0
 * @param m01 Element 0 1
 * @param m10 Element 1 0
 * @param m11 Element 1 1
 */
case class Mat2c(m00: Complex, m01: Complex, m10: Complex, m11: Complex) {

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def +(m: Mat2c): Mat2c = Mat2c(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  /**
   * Adds the given matrix to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param m The matrix to add.
   * @return The sum between this matrix and the given one.
   */
  def plus(m: Mat2c): Mat2c = this + m

  /**
   * Returns this same matrix.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This same matrix.
   */
  def unary_+ : Mat2c = this

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def -(m: Mat2c): Mat2c = Mat2c(
    this.m00 - m.m00, this.m01 - m.m01,
    this.m10 - m.m10, this.m11 - m.m11
  )

  /**
   * Subtracts the given matrix from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param m The matrix to subtract.
   * @return The subtraction between this matrix and the given one.
   */
  def minus(m: Mat2c): Mat2c = this - m

  /**
   * Returns the additive inverse of this matrix.
   *
   * @return The additive inverse of this matrix.
   */
  def unary_- : Mat2c = Mat2c(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  /**
   * Returns the additive inverse of this matrix.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this matrix.
   */
  def negated: Mat2c = -this

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Complex): Mat2c = Mat2c(
    this.m00 * k, this.m01 * k,
    this.m10 * k, this.m11 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Complex): Mat2c = this * k

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def *(k: Double): Mat2c = Mat2c(
    this.m00 * k, this.m01 * k,
    this.m10 * k, this.m11 * k
  )

  /**
   * Multiplies this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this matrix by.
   * @return The product between this matrix and the given scalar.
   */
  def multipliedBy(k: Double): Mat2c = this * k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Complex): Mat2c = Mat2c(
    this.m00 / k, this.m01 / k,
    this.m10 / k, this.m11 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Complex): Mat2c = this / k

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def /(k: Double): Mat2c = Mat2c(
    this.m00 / k, this.m01 / k,
    this.m10 / k, this.m11 / k
  )

  /**
   * Divides this matrix by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this matrix by.
   * @return The division between this matrix and the given scalar.
   */
  def dividedBy(k: Double): Mat2c = this / k

  /**
   * Returns the first row of this matrix as a [[Vec2c]].
   *
   * @return The first row of this matrix.
   * @see [[row]]
   */
  def row0: Vec2c = Vec2c(this.m00, this.m01)

  /**
   * Returns the second row of this matrix as a [[Vec2c]].
   *
   * @return The second row of this matrix.
   * @see [[row]]
   */
  def row1: Vec2c = Vec2c(this.m10, this.m11)

  /**
   * Returns the row at the given index as a [[Vec2c]].
   *
   * @param i The index of the requested row. Must be either 0 or 1.
   * @return The row at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[row0]] and [[row1]]
   */
  def row(i: Int): Vec2c = i match {
    case 0 => this.row0
    case 1 => this.row1
  }

  /**
   * Returns the first column of this matrix as a [[Vec2c]].
   *
   * @return The first column of this matrix.
   * @see [[col]]
   */
  def col0: Vec2c = Vec2c(this.m00, this.m10)

  /**
   * Returns the second column of this matrix as a [[Vec2c]].
   *
   * @return The second column of this matrix.
   * @see [[col]]
   */
  def col1: Vec2c = Vec2c(this.m01, this.m11)

  /**
   * Returns the column at the given index as a [[Vec2c]].
   *
   * @param i The index of the requested column. Must be either 0 or 1.
   * @return The column at the given index.
   * @throws MatchError If the given index is out of bounds.
   * @see [[col0]] and [[col1]]
   */
  def col(i: Int): Vec2c = i match {
    case 0 => this.col0
    case 1 => this.col1
  }

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @return The product of this matrix by the vector with the given components.
   */
  def *(x: Complex, y: Complex): Vec2c = Vec2c(this.m00 * x + this.m01 * y, this.m10 * x + this.m11 * y)

  /**
   * Multiplies this matrix by the vector with the given components and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The vector's x component.
   * @param y The vector's y component.
   * @return The product of this matrix by the vector with the given components.
   */
  def multiply(x: Complex, y: Complex): Vec2c = this * (x, y)

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def *(v: Vec2c): Vec2c = this * (v.x, v.y)

  /**
   * Multiplies this matrix by the given vector and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this matrix by.
   * @return The product of this matrix by the given vector.
   */
  def multiply(v: Vec2c): Vec2c = this * v

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat2c): Mat2c = Mat2c(
    this.m00 * m.m00 + this.m01 * m.m10, this.m00 * m.m01 + this.m01 * m.m11,
    this.m10 * m.m00 + this.m11 * m.m10, this.m10 * m.m01 + this.m11 * m.m11
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat2c): Mat2c = this * m

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def *(m: Mat2x3c): Mat2x3c = Mat2x3c(
    this.m00 * m.m00 + this.m01 * m.m10, this.m00 * m.m01 + this.m01 * m.m11, this.m00 * m.m02 + this.m01 * m.m12,
    this.m10 * m.m00 + this.m11 * m.m10, this.m10 * m.m01 + this.m11 * m.m11, this.m10 * m.m02 + this.m11 * m.m12
  )

  /**
   * Multiplies this matrix by the given one and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param m The matrix to multiply this one by.
   * @return The product between this matrix and the given one.
   */
  def multiply(m: Mat2x3c): Mat2x3c = this * m

  /**
   * Returns the transposed of this matrix.
   *
   * The transposed of a matrix is obtained by switching its rows and its columns.
   *
   * @return The transposed of this matrix.
   */
  def transposed: Mat2c = Mat2c(
    this.m00, this.m10,
    this.m01, this.m11
  )

  /**
   * Returns the conjugate of this complex matrix.
   *
   * @return The conjugate of this complex matrix.
   */
  def conjugate: Mat2c = Mat2c(
    this.m00.conjugate, this.m01.conjugate,
    this.m10.conjugate, this.m11.conjugate
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
   * Returns the determinant of this matrix.
   *
   * For a 2x2 matrix `[a, b, c, d]`, the determinant is `ad - bc`.
   *
   * @return The determinant of this matrix.
   */
  def determinant: Complex = this.m00 * this.m11 - this.m01 * this.m10

  /**
   * Returns the adjugate of this matrix.
   *
   * For a 2x2 matrix `[a, b, c, d]`, the adjugate is defined as the 2x2 matrix `[d, -b, -c, a]`.
   *
   * @return The adjugate of this matrix.
   */
  def adjugate: Mat2c = Mat2c(
    this.m11, -this.m01,
    -this.m10, this.m00
  )

  /**
   * Returns the inverse of this matrix.
   *
   * The result is undefined if this matrix is not invertible.
   * It is possible to check if the matrix is invertible by checking if its [[determinant]] is not zero.
   *
   * @return The inverse of this matrix.
   */
  def inverse: Mat2c = this.adjugate / this.determinant

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
  def power(exp: Int): Mat2c = {
    if (exp < 0) {
      this.inverse.power(-exp)
    } else if (exp == 1) {
      this
    } else if (exp == 0) {
      Mat2c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  /**
   * Returns a matrix with all elements in absolute value.
   *
   * @return A matrix with all elements in absolute value.
   */
  def abs: Mat2d = Mat2d(
    Complex.abs(this.m00), Complex.abs(this.m01),
    Complex.abs(this.m10), Complex.abs(this.m11)
  )

  /**
   * Constructs an orthonormal matrix from the columns of this matrix using the Gram-Schmidt procedure.
   *
   * @return This matrix with orthogonal columns of unit length.
   */
  def orthonormalized: Mat2c = {
    var (v0, v1) = (this.col0, this.col1)
    v1 = v1 - v1.project(v0)
    Mat2c.fromColumns(v0.normalized, v1.normalized)
  }

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def ~=(m: Mat2c): Boolean = (this.m00 ~= m.m00) && (this.m01 ~= m.m01) && (this.m10 ~= m.m10) && (this.m11 ~= m.m11)

  /**
   * Checks if this matrix is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator.
   *
   * @param m The second matrix.
   * @return True if this matrix is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(m: Mat2c): Boolean = this ~= m

  /**
   * Returns the element at the given row and column index.
   *
   * @param row The row index of the desired element. Must be either 0 or 1.
   * @param col The column index of the desired element. Must be either 0 or 1.
   * @return The element at the given row and column index.
   * @throws MatchError If any of the given indices is out of bounds.
   */
  def apply(row: Int, col: Int): Complex = (row, col) match {
    case (0, 0) => this.m00
    case (0, 1) => this.m01
    case (1, 0) => this.m10
    case (1, 1) => this.m11
  }

  /**
   * Returns a matrix whose elements are the real part of the elements of this matrix.
   *
   * @return A matrix whose elements are the real part of the elements of this matrix.
   */
  def real: Mat2d = Mat2d(
    this.m00.real, this.m01.real,
    this.m10.real, this.m11.real
  )

  /**
   * Returns a matrix whose elements are the imaginary part of the elements of this matrix.
   *
   * @return A matrix whose elements are the imaginary part of the elements of this matrix.
   */
  def imaginary: Mat2d = Mat2d(
    this.m00.imaginary, this.m01.imaginary,
    this.m10.imaginary, this.m11.imaginary
  )
}

/**
 * Constants, factory methods, and implicits for matrices.
 */
object Mat2c {

  /** Shorthand for an identity matrix */
  val Identity: Mat2c = Mat2c(1.0, 0.0, 0.0, 1.0)

  /** Shorthand for the zero matrix */
  val Zero: Mat2c = Mat2c(0.0, 0.0, 0.0, 0.0)

  /**
   * Returns a 2x2 matrix from the given rows.
   *
   * @param row0 The first row.
   * @param row1 The second row.
   * @return A 2x2 matrix from the given rows.
   */
  def fromRows(row0: Vec2c, row1: Vec2c): Mat2c = Mat2c(row0.x, row0.y, row1.x, row1.y)

  /**
   * Returns a 2x2 matrix from the given columns.
   *
   * @param col0 The first column.
   * @param col1 The second column.
   * @return A 2x2 matrix from the given columns.
   */
  def fromColumns(col0: Vec2c, col1: Vec2c): Mat2c = Mat2c(col0.x, col1.x, col0.y, col1.y)

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
    def *(v: Mat2c): Mat2c = v * self
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
    def *(v: Mat2c): Mat2c = v * self
  }

  /**
   * Implicit conversion from [[Mat2d]] to [[Mat2c]].
   */
  implicit val mat2dToMat2c: Mat2d => Mat2c = m => Mat2c(m.m00, m.m01, m.m10, m.m11)
}