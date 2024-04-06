package io.github.scalamath.cmplxlib

import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Mat2d
import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat2cSuite extends AnyFunSuite {

  implicit val matrixEquality: Equality[Mat2c] = (a: Mat2c, b: Any) => b match {
    case b: Mat2c => a ~= b
    case _ => false
  }

  implicit val vectorEquality: Equality[Vec2c] = (a: Vec2c, b: Any) => b match {
    case b: Vec2c => a ~= b
    case _ => false
  }

  test("Sum of matrices") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I
    )
    val res = Mat2c(
      3.0 + 4.5 * I, 4.5 + 1.5 * I,
      1.5 + 3.0 * I, 7.0 + 5.5 * I
    )
    assert(a + b === res)
  }
  
  test("Unary plus") {
    val mat = Mat2c(
      3.0 + 4.5 * I, 4.5 + 1.5 * I,
      1.5 + 3.0 * I, 7.0 + 5.5 * I
    )
    assert(+mat == mat)
  }

  test("Subtraction of matrices") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I
    )
    val res = Mat2c(
      -1.0 - 0.5 * I, -1.5 + 0.5 * I,
      -0.5 + 0.0 * I, -1.0 - 1.5 * I
    )
    assert(a - b === res)
  }

  test("Unary minus") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      -1.0 - 2.0 * I, -1.5 - I,
      -0.5 - 1.5 * I, -3.0 - 2.0 * I
    )
    assert(-mat == res)
  }

  test("Matrix multiplied by a complex number") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I
    )
    assert(mat * (1.5 + I) === res)
  }

  test("Matrix multiplied by a complex number commutativity") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I
    )
    assert((1.5 + I) * mat == res)
  }

  test("Matrix multiplied by a real number") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I,
      0.75 + 2.25 * I, 4.5 + 3.0 * I
    )
    assert(mat * 1.5 == res)
  }

  test("Matrix multiplied by a real number commutativity") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I,
      0.75 + 2.25 * I, 4.5 + 3.0 * I
    )
    assert(1.5 * mat == res)
  }

  ignore("Matrix divided by a complex number") {
    // TODO
  }

  ignore("Matrix divided by a real number") {
    // TODO
  }

  test("Access the rows of a matrix") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val row0 = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val row1 = Vec2c(0.5 + 1.5 * I, 3.0 + 2.0 * I)
    assert(mat.row0 == row0)
    assert(mat.row1 == row1)
  }

  test("Access the rows of a matrix using their index") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val row0 = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val row1 = Vec2c(0.5 + 1.5 * I, 3.0 + 2.0 * I)
    assert(mat.row(0) == row0)
    assert(mat.row(1) == row1)
    assertThrows[MatchError] {mat.row(2)}
  }

  test("Access the columns of a matrix") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val col0 = Vec2c(1.0 + 2.0 * I, 0.5 + 1.5 * I)
    val col1 = Vec2c(1.5 + I, 3.0 + 2.0 * I)
    assert(mat.col0 == col0)
    assert(mat.col1 == col1)
  }

  test("Access the columns of a matrix using their index") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val col0 = Vec2c(1.0 + 2.0 * I, 0.5 + 1.5 * I)
    val col1 = Vec2c(1.5 + I, 3.0 + 2.0 * I)
    assert(mat.col(0) == col0)
    assert(mat.col(1) == col1)
    assertThrows[MatchError] {mat.col(2)}
  }

  test("Matrix-vector product") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val vec = Vec2c(1.0 + I, 2.0 + 3.0 * I)
    val res = Vec2c(-1.0 + 9.5 * I, -1.0 + 15.0 * I)
    assert(mat * vec === res)
  }

  test("Matrix-vector product by values") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val vec = mat * (1.0 + I, 2.0 + 3.0 * I)
    val res = Vec2c(-1.0 + 9.5 * I, -1.0 + 15.0 * I)
    assert(vec === res)
  }

  test("Matrix product with a 2x2 matrix") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I
    )
    val res = Mat2c(
      -3.0 + 9.75 * I, 4.5 + 15.75 * I,
      -2.75 + 10.75 * I, 5.75 + 23.25 * I
    )
    assert(a * b === res)
  }

  ignore("Matrix product with a 2x3 matrix") {
    // TODO
  }

  test("Transposed matrix") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val res = Mat2c(
      1.0 + 2.0 * I, 0.5 + 1.5 * I,
      1.5 + I, 3.0 + 2.0 * I
    )
    assert(mat.transposed == res)
  }

  test("Conjugate matrix") {
    val mat = Mat2c(
      1.0 + I, 2.0 - 2.0 * I,
      -3.0 + 3.0 * I, 4.0 + 4.0 * I
    )
    val res = Mat2c(
      1.0 - I, 2.0 + 2.0 * I,
      -3.0 - 3.0 * I, 4.0 - 4.0 * I
    )
    assert(mat.conjugate == res)
  }

  test("Symmetric matrix") {
    val mat = Mat2c(
      0.0, 1.0 + I,
      1.0 + I, 2.0 + 2.0 * I
    )
    assert(mat.isSymmetric)
  }

  test("Skew symmetric matrix") {
    val mat = Mat2c(
      0.0, 1.0 + I,
      -1.0 - I, 0.0
    )
    assert(mat.isSkewSymmetric)
  }

  test("Hermitian matrix") {
    val mat = Mat2c(
      1.0, 1.0 + I,
      1.0 - I, 2.0
    )
    assert(mat.isHermitian)
  }

  test("Matrix determinant") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val det = -0.25 + 5.25 * I
    assert(mat.determinant == det)
  }

  ignore("Adjugate matrix") {
    // TODO
  }

  ignore("Inverse matrix") {
    // TODO
  }

  test("Matrix power") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    assert(a.power(3) === a * a * a)
  }

  ignore("Matrix absolute value") {
    // TODO
  }

  ignore("Orthonormalized matrix") {
    // TODO
  }

  test("Matrix equals approx") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2c(
      1.00000001 + 2.0 * I, 1.5 + I,
      0.5 + 1.49999999 * I, 2.99999999 + 2.0 * I
    )
    assert(a ~= b)
  }

  test("Access element using indices") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    assert(mat(0, 0) == 1.0 + 2.0 * I)
    assert(mat(0, 1) == 1.5 + I)
    assert(mat(1, 0) == 0.5 + 1.5 * I)
    assert(mat(1, 1) == 3.0 + 2.0 * I)
    assertThrows[MatchError] {mat(2, 0)}
    assertThrows[MatchError] {mat(0, 2)}
    assertThrows[MatchError] {mat(2, 2)}
  }

  test("Get the real part of a matrix") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2d(1.0, 1.5, 0.5, 3.0)
    assert(a.real == b)
  }

  test("Get the imaginary part of a matrix") {
    val a = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val b = Mat2d(2.0, 1.0, 1.5, 2.0)
    assert(a.imaginary == b)
  }

  test("Construct matrix from rows") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val row0 = Vec2c(1.0 + 2.0 * I, 1.5 + I)
    val row1 = Vec2c(0.5 + 1.5 * I, 3.0 + 2.0 * I)
    assert(Mat2c.fromRows(row0, row1) == mat)
  }

  test("Construct matrix from columns") {
    val mat = Mat2c(
      1.0 + 2.0 * I, 1.5 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I
    )
    val col0 = Vec2c(1.0 + 2.0 * I, 0.5 + 1.5 * I)
    val col1 = Vec2c(1.5 + I, 3.0 + 2.0 * I)
    assert(Mat2c.fromColumns(col0, col1) == mat)
  }
}
