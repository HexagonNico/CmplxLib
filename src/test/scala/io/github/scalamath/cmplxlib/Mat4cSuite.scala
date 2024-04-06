package io.github.scalamath.cmplxlib

import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Mat4d
import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat4cSuite extends AnyFunSuite {

  implicit val matrixEquality: Equality[Mat4c] = (a: Mat4c, b: Any) => b match {
    case b: Mat4c => a ~= b
    case _ => false
  }

  implicit val vectorEquality: Equality[Vec4c] = (a: Vec4c, b: Any) => b match {
    case b: Vec4c => a ~= b
    case _ => false
  }

  test("Sum of matrices") {
    val a = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val b = Mat4c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I, 1.5 + I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I, 2.0 + 0.5 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5, 2.0 + 1.5 * I,
      4.0 + 3.5 * I, 2.0 + 2.0 * I, 3.0 + 1.5 * I, 1.0 + 3.0 * I
    )
    val res = Mat4c(
      3.0 + 4.5 * I, 4.5 + 1.5 * I, 3.0 + 3.0 * I, 4.5 + I,
      1.5 + 3.0 * I, 7.0 + 5.5 * I, 2.5 + 4.0 * I, 4.0 + 1.5 * I,
      5.0 + 3.5 * I, 1.0 + 2.0 * I, 4.0 + 2.5 * I, 3.0 + 1.5 * I,
      7.0 + 4.5 * I, 4.0 + 5.0 * I, 5.5 + 3.0 * I, 1.0 + 5.0 * I
    )
    assert(a + b === res)
  }
  
  test("Unary plus") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    assert(+mat == mat)
  }

  test("Subtraction of matrices") {
    val a = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val b = Mat4c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I, 1.5 + I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I, 2.0 + 0.5 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5, 2.0 + 1.5 * I,
      4.0 + 3.5 * I, 2.0 + 2.0 * I, 3.0 + 1.5 * I, 1.0 + 3.0 * I
    )
    val res = Mat4c(
      -1.0 - 0.5 * I, -1.5 + 0.5 * I, 1.0 - I, 1.5 - I,
      -0.5, -1.0 - 1.5 * I, -0.5, 0.5 * I,
      -1.0 + 2.5 * I, -1.0, -1.0 + 2.5 * I, -1.0 - 1.5 * I,
      -1.0 - 2.5 * I, I, -0.5, -1.0 - I
    )
    assert(a - b === res)
  }

  test("Unary minus") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      -1.0 - 2.0 * I, -1.5 - I, -2.0 - I, -3.0,
      -0.5 - 1.5 * I, -3.0 - 2.0 * I, -1.0 - 2.0 * I, -2.0 - I,
      -2.0 - 3.0 * I, -0.0 - I, -1.5 - 2.5 * I, -1.0,
      -3.0 - I, -2.0 - 3.0 * I, -2.5 - 1.5 * I, -0.0 - 2.0 * I
    )
    assert(-mat == res)
  }

  test("Matrix multiplied by a complex number") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I, 2.0 + 3.5 * I, 4.5 + 3.0 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I, -0.5 + 4.0 * I, 2.0 + 3.5 * I,
      6.5 * I, -1.0 + 1.5 * I, -0.25 + 5.25 * I, 1.5 + I,
      3.5 + 4.5 * I, 6.5 * I, 2.25 + 4.75 * I, -2.0 + 3.0 * I
    )
    assert(mat * (1.5 + I) === res)
  }

  test("Matrix multiplied by a complex number commutativity") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I, 2.0 + 3.5 * I, 4.5 + 3.0 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I, -0.5 + 4.0 * I, 2.0 + 3.5 * I,
      6.5 * I, -1.0 + 1.5 * I, -0.25 + 5.25 * I, 1.5 + I,
      3.5 + 4.5 * I, 6.5 * I, 2.25 + 4.75 * I, -2.0 + 3.0 * I
    )
    assert((1.5 + I) * mat === res)
  }

  test("Matrix multiplied by a real number") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I, 3.0 + 1.5 * I, 4.5,
      0.75 + 2.25 * I, 4.5 + 3.0 * I, 1.5 + 3.0 * I, 3.0 + 1.5 * I,
      3.0 + 4.5 * I, 1.5 * I, 2.25 + 3.75 * I, 1.5,
      4.5 + 1.5 * I, 3.0 + 4.5 * I, 3.75 + 2.25 * I, 3.0 * I
    )
    assert(mat * 1.5 === res)
  }

  test("Matrix multiplied by a real number commutativity") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I, 3.0 + 1.5 * I, 4.5,
      0.75 + 2.25 * I, 4.5 + 3.0 * I, 1.5 + 3.0 * I, 3.0 + 1.5 * I,
      3.0 + 4.5 * I, 1.5 * I, 2.25 + 3.75 * I, 1.5,
      4.5 + 1.5 * I, 3.0 + 4.5 * I, 3.75 + 2.25 * I, 3.0 * I
    )
    assert(1.5 * mat === res)
  }

  ignore("Matrix divided by a complex number") {
    // TODO
  }

  ignore("Matrix divided by a real number") {
    // TODO
  }

  test("Access the rows of a matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val row0 = Vec4c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0)
    val row1 = Vec4c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I)
    val row2 = Vec4c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0)
    val row3 = Vec4c(3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I)
    assert(mat.row0 == row0)
    assert(mat.row1 == row1)
    assert(mat.row2 == row2)
    assert(mat.row3 == row3)
  }

  test("Access the rows of a matrix using their index") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val row0 = Vec4c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0)
    val row1 = Vec4c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I)
    val row2 = Vec4c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0)
    val row3 = Vec4c(3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I)
    assert(mat.row(0) == row0)
    assert(mat.row(1) == row1)
    assert(mat.row(2) == row2)
    assert(mat.row(3) == row3)
    assertThrows[MatchError] {mat.row(4)}
  }

  test("Access the columns of a matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val col0 = Vec4c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I, 3.0 + I)
    val col1 = Vec4c(1.5 + I, 3.0 + 2.0 * I, I, 2.0 + 3.0 * I)
    val col2 = Vec4c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I, 2.5 + 1.5 * I)
    val col3 = Vec4c(3.0, 2.0 + I, 1.0, 2.0 * I)
    assert(mat.col0 == col0)
    assert(mat.col1 == col1)
    assert(mat.col2 == col2)
    assert(mat.col3 == col3)
  }

  test("Access the columns of a matrix using their index") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val col0 = Vec4c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I, 3.0 + I)
    val col1 = Vec4c(1.5 + I, 3.0 + 2.0 * I, I, 2.0 + 3.0 * I)
    val col2 = Vec4c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I, 2.5 + 1.5 * I)
    val col3 = Vec4c(3.0, 2.0 + I, 1.0, 2.0 * I)
    assert(mat.col(0) == col0)
    assert(mat.col(1) == col1)
    assert(mat.col(2) == col2)
    assert(mat.col(3) == col3)
    assertThrows[MatchError] {mat.col(4)}
  }

  test("Matrix-vector product") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val vec = Vec4c(1.0 + I, 2.0 + 3.0 * I, 1.0 - I, 1.0)
    val res = Vec4c(5.0 + 8.5 * I, 4.0 + 17.0 * I, 1.0 + 8.0 * I, 1.0 + 17.0 * I)
    assert(mat * vec === res)
  }

  test("Matrix-vector product by values") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val vec = mat * (1.0 + I, 2.0 + 3.0 * I, 1.0 - I, 1.0)
    val res = Vec4c(5.0 + 8.5 * I, 4.0 + 17.0 * I, 1.0 + 8.0 * I, 1.0 + 17.0 * I)
    assert(vec === res)
  }

  test("Matrix product with a 4x4 matrix") {
    val a = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val b = Mat4c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I, 1.5 + I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I, 2.0 + 0.5 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5, 2.0 + 1.5 * I,
      4.0 + 3.5 * I, 2.0 + 2.0 * I, 3.0 + 1.5 * I, 1.0 + 3.0 * I
    )
    val res = Mat4c(
      14.5 + 24.25 * I, 11.5 + 24.75 * I, 11.25 + 15.5 * I, 7.5 + 20.75 * I,
      3.75 + 28.25 * I, 6.75 + 32.25 * I, 5.0 + 22.5 * I, 2.25 + 20.75 * I,
      2.25 + 23.75 * I, 2.0 + 20.0 * I, 0.75 + 16.25 * I, -0.25 + 18.75 * I,
      0.75 + 29.25 * I, 3.0 + 31.5 * I, 1.25 + 25.25 * I, 2.75 + 20.25 * I
    )
    assert(a * b === res)
  }

  test("Transposed matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I, 3.0 + I,
      1.5 + I, 3.0 + 2.0 * I, I, 2.0 + 3.0 * I,
      2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I, 2.5 + 1.5 * I,
      3.0, 2.0 + I, 1.0, 2.0 * I
    )
    assert(mat.transposed == res)
  }

  test("Conjugate matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4c(
      1.0 - 2.0 * I, 1.5 - I, 2.0 - I, 3.0,
      0.5 - 1.5 * I, 3.0 - 2.0 * I, 1.0 - 2.0 * I, 2.0 - I,
      2.0 - 3.0 * I, 0.0 - I, 1.5 - 2.5 * I, 1.0,
      3.0 - I, 2.0 - 3.0 * I, 2.5 - 1.5 * I, 0.0 - 2.0 * I
    )
    assert(mat.conjugate == res)
  }

  test("Symmetric matrix") {
    val mat = Mat4c(
      1.0 + I, 2.0 + I, 3.0 + I, 4.0 + I,
      2.0 + I, 5.0 + I, 6.0 + I, 7.0 + I,
      3.0 + I, 6.0 + I, 8.0 + I, 9.0 + I,
      4.0 + I, 7.0 + I, 9.0 + I, -1.0 - I
    )
    assert(mat.isSymmetric)
  }

  test("Skew symmetric matrix") {
    val mat = Mat4c(
      0.0, 1.0 - I, 2.0 - I, 3.0 - I,
      I - 1.0, 0.0, 4.0 - I, 5.0 - I,
      I - 2.0, I - 4.0, 0.0, 6.0 - I,
      I - 3.0, I - 5.0, I - 6.0, 0.0
    )
    assert(mat.isSkewSymmetric)
  }

  test("Hermitian matrix") {
    val mat = Mat4c(
      1.0, 1.0 + I, 2.0 + I, 3.0 + I,
      1.0 - I, 2.0, 4.0 + I, 5.0 + I,
      2.0 - I, 4.0 - I, 3.0, 6.0 + I,
      3.0 - I, 5.0 - I, 6.0 - I, 4.0
    )
    assert(mat.isHermitian)
  }

  test("Matrix determinant") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val det = 34.75 - 5.0 * I
    assert(mat.determinant == det)
  }

  ignore("Adjugate matrix") {
    // TODO
  }

  ignore("Inverse matrix") {
    // TODO
  }

  test("Matrix power") {
    val a = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    assert(a.power(3) == a * a * a)
  }

  ignore("Matrix absolute value") {
    // TODO
  }

  ignore("Orthonormalized matrix") {
    // TODO
  }

  test("Matrix equals approx") {
    val a = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val b = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 2.99999999,
      0.5 + 1.50000001 * I, 3.0 + 2.00000001 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.49999999 + 1.5 * I, 1.99999999 * I
    )
    assert(a ~= b)
  }

  test("Access elements using indices") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    assert(mat(0, 0) == 1.0 + 2.0 * I)
    assert(mat(0, 1) == 1.5 + I)
    assert(mat(0, 2) == 2.0 + I)
    assert(mat(0, 3) == Complex(3.0, 0.0))
    assert(mat(1, 0) == 0.5 + 1.5 * I)
    assert(mat(1, 1) == 3.0 + 2.0 * I)
    assert(mat(1, 2) == 1.0 + 2.0 * I)
    assert(mat(1, 3) == 2.0 + I)
    assert(mat(2, 0) == 2.0 + 3.0 * I)
    assert(mat(2, 1) == I)
    assert(mat(2, 2) == 1.5 + 2.5 * I)
    assert(mat(2, 3) == Complex.One)
    assert(mat(3, 0) == 3.0 + I)
    assert(mat(3, 1) == 2.0 + 3.0 * I)
    assert(mat(3, 2) == 2.5 + 1.5 * I)
    assert(mat(3, 3) == 2.0 * I)
    assertThrows[MatchError] {mat(4, 0)}
    assertThrows[MatchError] {mat(0, 4)}
    assertThrows[MatchError] {mat(4, 4)}
  }

  test("Get the real part of a matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4d(1.0, 1.5, 2.0, 3.0, 0.5, 3.0, 1.0, 2.0, 2.0, 0.0, 1.5, 1.0, 3.0, 2.0, 2.5, 0.0)
    assert(mat.real == res)
  }

  test("Get the imaginary part of a matrix") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val res = Mat4d(2.0, 1.0, 1.0, 0.0, 1.5, 2.0, 2.0, 1.0, 3.0, 1.0, 2.5, 0.0, 1.0, 3.0, 1.5, 2.0)
    assert(mat.imaginary == res)
  }

  test("Construct matrix from rows") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val row0 = Vec4c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0)
    val row1 = Vec4c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I)
    val row2 = Vec4c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0)
    val row3 = Vec4c(3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I)
    assert(Mat4c.fromRows(row0, row1, row2, row3) == mat)
  }

  test("Construct matrix from columns") {
    val mat = Mat4c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I, 3.0,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I, 2.0 + I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I, 1.0,
      3.0 + I, 2.0 + 3.0 * I, 2.5 + 1.5 * I, 2.0 * I
    )
    val col0 = Vec4c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I, 3.0 + I)
    val col1 = Vec4c(1.5 + I, 3.0 + 2.0 * I, I, 2.0 + 3.0 * I)
    val col2 = Vec4c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I, 2.5 + 1.5 * I)
    val col3 = Vec4c(3.0, 2.0 + I, 1.0, 2.0 * I)
    assert(Mat4c.fromColumns(col0, col1, col2, col3) == mat)
  }
}
