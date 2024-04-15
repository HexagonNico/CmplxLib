package io.github.scalamath.cmplxlib

import io.github.scalamath.cmplxlib.Complex.I
import io.github.scalamath.vecmatlib.Mat3d
import org.scalactic.Equality
import org.scalatest.funsuite.AnyFunSuite

class Mat3cSuite extends AnyFunSuite {

  implicit val matrixEquality: Equality[Mat3c] = (a: Mat3c, b: Any) => b match {
    case b: Mat3c => a ~= b
    case _ => false
  }

  implicit val vectorEquality: Equality[Vec3c] = (a: Vec3c, b: Any) => b match {
    case b: Vec3c => a ~= b
    case _ => false
  }

  test("Sum of matrices") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val b = Mat3c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5
    )
    val res = Mat3c(
      3.0 + 4.5 * I, 4.5 + 1.5 * I, 3.0 + 3.0 * I,
      1.5 + 3.0 * I, 7.0 + 5.5 * I, 2.5 + 4.0 * I,
      5.0 + 3.5 * I, 1.0 + 2.0 * I, 4.0 + 2.5 * I
    )
    assert(a + b === res)
  }
  
  test("Unary plus") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    assert(+mat == mat)
  }

  test("Subtraction of matrices") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val b = Mat3c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5
    )
    val res = Mat3c(
      -1.0 - 0.5 * I, -1.5 + 0.5 * I, 1.0 - I,
      -0.5, -1.0 - 1.5 * I, -0.5,
      -1.0 + 2.5 * I, -1.0, -1.0 + 2.5 * I
    )
    assert(a - b === res)
  }

  test("Unary minus") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      -1.0 - 2.0 * I, -1.5 - I, -2.0 - I,
      -0.5 - 1.5 * I, -3.0 - 2.0 * I, -1.0 - 2.0 * I,
      -2.0 - 3.0 * I, -I, -1.5 - 2.5 * I
    )
    assert(-mat == res)
  }

  test("Matrix multiplied by a complex number") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I, 2.0 + 3.5 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I, -0.5 + 4.0 * I,
      6.5 * I, -1.0 + 1.5 * I, -0.25 + 5.25 * I
    )
    assert(mat * (1.5 + I) === res)
  }

  test("Matrix multiplied by a complex number commutativity") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      -0.5 + 4.0 * I, 1.25 + 3.0 * I, 2.0 + 3.5 * I,
      -0.75 + 2.75 * I, 2.5 + 6.0 * I, -0.5 + 4.0 * I,
      6.5 * I, -1.0 + 1.5 * I, -0.25 + 5.25 * I
    )
    assert((1.5 + I) * mat === res)
  }

  test("Matrix multiplied by a real number") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I, 3.0 + 1.5 * I,
      0.75 + 2.25 * I, 4.5 + 3.0 * I, 1.5 + 3.0 * I,
      3.0 + 4.5 * I, 1.5 * I, 2.25 + 3.75 * I
    )
    assert(mat * 1.5 === res)
  }

  test("Matrix multiplied by a real number commutativity") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      1.5 + 3.0 * I, 2.25 + 1.5 * I, 3.0 + 1.5 * I,
      0.75 + 2.25 * I, 4.5 + 3.0 * I, 1.5 + 3.0 * I,
      3.0 + 4.5 * I, 1.5 * I, 2.25 + 3.75 * I
    )
    assert(1.5 * mat === res)
  }

  test("Matrix divided by a complex number") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val z = 1.5 + I
    val res = Mat3c(
      3.5 / 3.25 + 2.0 / 3.25 * I, 1.0, 4.0 / 3.25 - 0.5 / 3.25 * I,
      2.25 / 3.25 + 1.75 / 3.25 * I, 6.5 / 3.25, 3.5 / 3.25 + 2.0 / 3.25 * I,
      6.0 / 3.25 + 2.5 / 3.25 * I, 1.0 / 3.25 + 1.5 / 3.25 * I, 4.75 / 3.25 + 2.25 / 3.25 * I
    )
    assert(mat / z === res)
  }

  test("Matrix divided by a real number") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      0.5 + I, 0.75 + 0.5 * I, 1.0 + 0.5 * I,
      0.25 + 0.75 * I, 1.5 + I, 0.5 + I,
      1.0 + 1.5 * I, 0.5 * I, 0.75 + 1.25 * I
    )
    assert(mat / 2.0 === res)
  }

  test("Access the rows of a matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val row0 = Vec3c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I)
    val row1 = Vec3c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I)
    val row2 = Vec3c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I)
    assert(mat.row0 == row0)
    assert(mat.row1 == row1)
    assert(mat.row2 == row2)
  }

  test("Access the rows of a matrix using their index") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val row0 = Vec3c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I)
    val row1 = Vec3c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I)
    val row2 = Vec3c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I)
    assert(mat.row(0) == row0)
    assert(mat.row(1) == row1)
    assert(mat.row(2) == row2)
    assertThrows[MatchError] {mat.row(3)}
  }

  test("Access the columns of a matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val col0 = Vec3c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I)
    val col1 = Vec3c(1.5 + I, 3.0 + 2.0 * I, I)
    val col2 = Vec3c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I)
    assert(mat.col0 == col0)
    assert(mat.col1 == col1)
    assert(mat.col2 == col2)
  }

  test("Access the columns of a matrix using their index") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val col0 = Vec3c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I)
    val col1 = Vec3c(1.5 + I, 3.0 + 2.0 * I, I)
    val col2 = Vec3c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I)
    assert(mat.col(0) == col0)
    assert(mat.col(1) == col1)
    assert(mat.col(2) == col2)
    assertThrows[MatchError] {mat.col(3)}
  }

  test("Matrix-vector product") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val vec = Vec3c(1.0 + I, 2.0 + 3.0 * I, 1.0 - I)
    val res = Vec3c(2.0 + 8.5 * I, 2.0 + 16.0 * I, 8.0 * I)
    assert(mat * vec == res)
  }

  test("Matrix-vector product by values") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val vec = mat * (1.0 + I, 2.0 + 3.0 * I, 1.0 - I)
    val res = Vec3c(2.0 + 8.5 * I, 2.0 + 16.0 * I, 8.0 * I)
    assert(vec == res)
  }

  test("Matrix product with a 3x3 matrix") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val b = Mat3c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5
    )
    val res = Mat3c(
      2.5 + 13.75 * I, 5.5 + 18.75 * I, 2.25 + 11.0 * I,
      -0.75 + 17.25 * I, 4.75 + 26.25 * I, 0.5 + 16.5 * I,
      -1.75 + 20.25 * I, 18.0 * I, -2.25 + 14.75 * I
    )
    assert(a * b == res)
  }

  test("Matrix product with a 3x4 matrix") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val b = Mat3x4c(
      2.0 + 2.5 * I, 3.0 + 0.5 * I, 1.0 + 2.0 * I, 1.5 + I,
      1.0 + 1.5 * I, 4.0 + 3.5 * I, 1.5 + 2.0 * I, 2.0 + 0.5 * I,
      3.0 + 0.5 * I, 1.0 + I, 2.5, 2.0 + 1.5 * I
    )
    val res = Mat3x4c(
      2.5 + 13.75 * I, 5.5 + 18.75 * I, 2.25 + 11.0 * I, 4.5 + 11.75 * I,
      -0.75 + 17.25 * I, 4.75 + 26.25 * I, 0.5 + 16.5 * I, 3.25 + 13.75 * I,
      -1.75 + 20.25 * I, 18.0 * I, -2.25 + 14.75 * I, -1.25 + 15.75 * I
    )
    assert(a * b === res)
  }

  test("Transposed matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I,
      1.5 + I, 3.0 + 2.0 * I, I,
      2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I
    )
    assert(mat.transposed == res)
  }

  test("Conjugate matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      1.0 - 2.0 * I, 1.5 - I, 2.0 - I,
      0.5 - 1.5 * I, 3.0 - 2.0 * I, 1.0 - 2.0 * I,
      2.0 - 3.0 * I, -I, 1.5 - 2.5 * I
    )
    assert(mat.conjugate == res)
  }

  test("Symmetric matrix") {
    val mat = Mat3c(
      0.0, 1.0 + I, 2.0 - I,
      1.0 + I, 2.0 * I, 3.0 + I,
      2.0 - I, 3.0 + I, -4.0
    )
    assert(mat.isSymmetric)
  }

  test("Skew symmetric matrix") {
    val mat = Mat3c(
      0.0, 1.0 + I, 2.0 - I,
      -1.0 - I, 0.0, 3.0 + I,
      -2.0 + I, -3.0 - I, 0.0
    )
    assert(mat.isSkewSymmetric)
  }

  test("Hermitian matrix") {
    val mat = Mat3c(
      0.0, 1.0 + I, 2.0 - I,
      1.0 - I, 1.0, 3.0 + I,
      2.0 + I, 3.0 - I, 2.0
    )
    assert(mat.isHermitian)
  }

  test("Matrix determinant") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val det = -13.0 - 9.75 * I
    assert(mat.determinant == det)
  }

  test("Adjugate matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      1.5 + 9.5 * I, -0.75 - 3.25 * I, -4.5 - 3.0 * I,
      -1.0 + 3.5 * I, -4.5 - 2.5 * I, 2.5 - 0.5 * I,
      -1.5 - 12.5 * I, 2.0 + 5.5 * I, -0.25 + 5.25 * I
    )
    assert(mat.adjugate === res)
  }

  ignore("Inverse matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3c(
      -0.42461 - 0.41230 * I, 0.15692 + 0.13230 * I, 0.33230 - 0.01846 * I,
      -0.08 - 0.20923 * I, 0.31384 - 0.04307 * I, -0.10461 + 0.11692 * I,
      0.53538 + 0.56 * I, -0.30153 - 0.19692 * I, -0.18153 - 0.26769 * I
    )
    assert(mat.inverse === res) // TODO: Precision
  }

  test("Matrix power") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    assert(a.power(3) == (a * a * a))
  }

  test("Matrix absolute value") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3d(
      math.sqrt(5.0), math.sqrt(13.0) / 2.0, math.sqrt(5.0),
      math.sqrt(5.0 / 2.0), math.sqrt(13.0), math.sqrt(5.0),
      math.sqrt(13.0), 1.0, math.sqrt(17.0 / 2.0)
    )
    assert(mat.abs === res)
  }

  ignore("Orthonormalized matrix") {
    // TODO
  }

  test("Matrix equals approx") {
    val a = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val b = Mat3c(
      0.99999999 + 2.0 * I, 1.5 + I, 2.00000001 + I,
      0.5 + 1.5 * I, 3.00000001 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 2.99999999 * I, I, 1.5 + 2.49999999 * I
    )
    assert(a ~= b)
  }

  test("Access element using indices") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    assert(mat(0, 0) == 1.0 + 2.0 * I)
    assert(mat(0, 1) == 1.5 + I)
    assert(mat(0, 2) == 2.0 + I)
    assert(mat(1, 0) == 0.5 + 1.5 * I)
    assert(mat(1, 1) == 3.0 + 2.0 * I)
    assert(mat(1, 2) == 1.0 + 2.0 * I)
    assert(mat(2, 0) == 2.0 + 3.0 * I)
    assert(mat(2, 1) == I)
    assert(mat(2, 2) == 1.5 + 2.5 * I)
    assertThrows[MatchError] {mat(3, 0)}
    assertThrows[MatchError] {mat(0, 3)}
    assertThrows[MatchError] {mat(3, 3)}
  }

  test("Get the real part of a matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3d(1.0, 1.5, 2.0, 0.5, 3.0, 1.0, 2.0, 0.0, 1.5)
    assert(mat.real == res)
  }

  test("Get the imaginary part of a matrix") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val res = Mat3d(2.0, 1.0, 1.0, 1.5, 2.0, 2.0, 3.0, 1.0, 2.5)
    assert(mat.imaginary == res)
  }

  test("Construct matrix from rows") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val row0 = Vec3c(1.0 + 2.0 * I, 1.5 + I, 2.0 + I)
    val row1 = Vec3c(0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I)
    val row2 = Vec3c(2.0 + 3.0 * I, I, 1.5 + 2.5 * I)
    assert(Mat3c.fromRows(row0, row1, row2) == mat)
  }

  test("Construct matrix from columns") {
    val mat = Mat3c(
      1.0 + 2.0 * I, 1.5 + I, 2.0 + I,
      0.5 + 1.5 * I, 3.0 + 2.0 * I, 1.0 + 2.0 * I,
      2.0 + 3.0 * I, I, 1.5 + 2.5 * I
    )
    val col0 = Vec3c(1.0 + 2.0 * I, 0.5 + 1.5 * I, 2.0 + 3.0 * I)
    val col1 = Vec3c(1.5 + I, 3.0 + 2.0 * I, I)
    val col2 = Vec3c(2.0 + I, 1.0 + 2.0 * I, 1.5 + 2.5 * I)
    assert(Mat3c.fromColumns(col0, col1, col2) == mat)
  }
}
