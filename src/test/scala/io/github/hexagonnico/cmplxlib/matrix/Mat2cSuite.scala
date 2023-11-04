package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec2c
import org.scalatest.funsuite.AnyFunSuite

class Mat2cSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    val b = Mat2c(
      Complex(2.0, 2.5), Complex(3.0, 0.5),
      Complex(1.0, 1.5), Complex(4.0, 3.5)
    )
    assert(a + b == Mat2c(
      Complex(3.0, 4.5), Complex(4.5, 1.5),
      Complex(1.5, 3.0), Complex(7.0, 5.5)
    ))
  }

  test("Negative matrix") {
    assert(Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ).negated == Mat2c(
      Complex(-1.0, -2.0), Complex(-1.5, -1.0),
      Complex(-0.5, -1.5), Complex(-3.0, -2.0)
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    val b = Mat2c(
      Complex(2.0, 2.5), Complex(3.0, 0.5),
      Complex(1.0, 1.5), Complex(4.0, 3.5)
    )
    assert(a - b == Mat2c(
      Complex(-1.0, -0.5), Complex(-1.5, 0.5),
      Complex(-0.5, 0.0), Complex(-1.0, -1.5)
    ))
  }

  test("Matrix multiplied by a real number") {
    assert(Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ) * 1.5 == Mat2c(
      Complex(1.5, 3.0), Complex(2.25, 1.5),
      Complex(0.75, 2.25), Complex(4.5, 3.0)
    ))
  }

  test("Matrix multiplied by a real number commutativity") {
    assert(1.5 * Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ) == Mat2c(
      Complex(1.5, 3.0), Complex(2.25, 1.5),
      Complex(0.75, 2.25), Complex(4.5, 3.0)
    ))
  }

  test("Matrix multiplied by a complex number") {
    assert(Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ) * Complex(1.5, 1.0) == Mat2c(
      Complex(-0.5, 4.0), Complex(1.25, 3.0),
      Complex(-0.75, 2.75), Complex(2.5, 6.0)
    ))
  }

  test("Matrix multiplied by a complex number commutativity") {
    assert(Complex(1.5, 1.0) * Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ) == Mat2c(
      Complex(-0.5, 4.0), Complex(1.25, 3.0),
      Complex(-0.75, 2.75), Complex(2.5, 6.0)
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    val vec = Vec2c(Complex(1.0, 1.0), Complex(2.0, 3.0))
    assert(mat * vec == Vec2c(Complex(-1.0, 9.5), Complex(-1.0, 15.0)))
  }

  test("Matrix-vector product by values") {
    val mat = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    assert(mat * (Complex(1.0, 1.0), Complex(2.0, 3.0)) == Vec2c(Complex(-1.0, 9.5), Complex(-1.0, 15.0)))
  }

  test("Transposed") {
    assert(Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    ).transposed == Mat2c(
      Complex(1.0, 2.0), Complex(0.5, 1.5),
      Complex(1.5, 1.0), Complex(3.0, 2.0)
    ))
  }

  test("Symmetric matrix") {
    assert(Mat2c(
      Complex.Zero, Complex.One,
      Complex.One, Complex.Zero
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat2c(
      Complex.Zero, Complex.One,
      -Complex.One, Complex.Zero
    ).isSkewSymmetric)
  }

  test("Complex conjugate of a matrix") {
    assert(Mat2c(
      Complex(1.0, 1.0), Complex(2.0, -2.0),
      Complex(-3.0, 3.0), Complex(4.0, 4.0)
    ).conjugate == Mat2c(
      Complex(1.0, -1.0), Complex(2.0, 2.0),
      Complex(-3.0, -3.0), Complex(4.0, -4.0)
    ))
  }

  test("Conjugate transposed of a matrix") {
    assert(Mat2c(
      Complex(1.0, 1.0), Complex(2.0, -2.0),
      Complex(-3.0, 3.0), Complex(4.0, 4.0)
    ).hermitian == Mat2c(
      Complex(1.0, -1.0), Complex(-3.0, -3.0),
      Complex(2.0, 2.0), Complex(4.0, -4.0)
    ))
  }

  test("Matrix product") {
    val a = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    val b = Mat2c(
      Complex(2.0, 2.5), Complex(3.0, 0.5),
      Complex(1.0, 1.5), Complex(4.0, 3.5)
    )
    assert(a * b == Mat2c(
      Complex(-3.0, 9.75), Complex(4.5, 15.75),
      Complex(-2.75, 10.75), Complex(5.75, 23.25)
    ))
  }

  test("Matrix power") {
    val a = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat2c(
      Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0)
    )
    assert(a.determinant == Complex(-0.25, 5.25))
  }
}
