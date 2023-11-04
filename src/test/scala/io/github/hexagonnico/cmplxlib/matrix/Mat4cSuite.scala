package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec4c
import org.scalatest.funsuite.AnyFunSuite

class Mat4cSuite extends AnyFunSuite {

  test("Sum of matrices") {
    val a = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    val b = Mat4c(
      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0), Complex(2.0, 0.5),
      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0), Complex(2.0, 1.5),
      Complex(4.0, 3.5), Complex(2.0, 2.0), Complex(3.0, 1.5), Complex(1.0, 3.0)
    )
    assert(a + b == Mat4c(
      Complex(3.0, 4.5), Complex(4.5, 1.5), Complex(3.0, 3.0), Complex(4.5, 1.0),
      Complex(1.5, 3.0), Complex(7.0, 5.5), Complex(2.5, 4.0), Complex(4.0, 1.5),
      Complex(5.0, 3.5), Complex(1.0, 2.0), Complex(4.0, 2.5), Complex(3.0, 1.5),
      Complex(7.0, 4.5), Complex(4.0, 5.0), Complex(5.5, 3.0), Complex(1.0, 5.0)
    ))
  }

  test("Negative matrix") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ).negated == Mat4c(
      Complex(-1.0, -2.0), Complex(-1.5, -1.0), Complex(-2.0, -1.0), Complex(-3.0, -0.0),
      Complex(-0.5, -1.5), Complex(-3.0, -2.0), Complex(-1.0, -2.0), Complex(-2.0, -1.0),
      Complex(-2.0, -3.0), Complex(-0.0, -1.0), Complex(-1.5, -2.5), Complex(-1.0, -0.0),
      Complex(-3.0, -1.0), Complex(-2.0, -3.0), Complex(-2.5, -1.5), Complex(-0.0, -2.0)
    ))
  }

  test("Subtraction of matrices") {
    val a = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    val b = Mat4c(
      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0), Complex(2.0, 0.5),
      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0), Complex(2.0, 1.5),
      Complex(4.0, 3.5), Complex(2.0, 2.0), Complex(3.0, 1.5), Complex(1.0, 3.0)
    )
    assert(a - b == Mat4c(
      Complex(-1.0, -0.5), Complex(-1.5, 0.5), Complex(1.0, -1.0), Complex(1.5, -1.0),
      Complex(-0.5, 0.0), Complex(-1.0, -1.5), Complex(-0.5, 0.0), Complex(0.0, 0.5),
      Complex(-1.0, 2.5), Complex(-1.0, 0.0), Complex(-1.0, 2.5), Complex(-1.0, -1.5),
      Complex(-1.0, -2.5), Complex(0.0, 1.0), Complex(-0.5, 0.0), Complex(-1.0, -1.0)
    ))
  }

  test("Matrix multiplied by a real number") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ) * 1.5 == Mat4c(
      Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(3.0, 1.5), Complex(4.5, 0.0),
      Complex(0.75, 2.25), Complex(4.5, 3.0), Complex(1.5, 3.0), Complex(3.0, 1.5),
      Complex(3.0, 4.5), Complex(0.0, 1.5), Complex(2.25, 3.75), Complex(1.5, 0.0),
      Complex(4.5, 1.5), Complex(3.0, 4.5), Complex(3.75, 2.25), Complex(0.0, 3.0)
    ))
  }

  test("Matrix multiplied by a real number commutativity") {
    assert(1.5 * Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ) == Mat4c(
      Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(3.0, 1.5), Complex(4.5, 0.0),
      Complex(0.75, 2.25), Complex(4.5, 3.0), Complex(1.5, 3.0), Complex(3.0, 1.5),
      Complex(3.0, 4.5), Complex(0.0, 1.5), Complex(2.25, 3.75), Complex(1.5, 0.0),
      Complex(4.5, 1.5), Complex(3.0, 4.5), Complex(3.75, 2.25), Complex(0.0, 3.0)
    ))
  }

  test("Matrix multiplied by a complex number") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ) * Complex(1.5, 1.0) == Mat4c(
      Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(2.0, 3.5), Complex(4.5, 3.0),
      Complex(-0.75, 2.75), Complex(2.5, 6.0), Complex(-0.5, 4.0), Complex(2.0, 3.5),
      Complex(0.0, 6.5), Complex(-1.0, 1.5), Complex(-0.25, 5.25), Complex(1.5, 1.0),
      Complex(3.5, 4.5), Complex(0.0, 6.5), Complex(2.25, 4.75), Complex(-2.0, 3.0)
    ))
  }

  test("Matrix multiplied by a complex number commutativity") {
    assert(Complex(1.5, 1.0) * Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ) == Mat4c(
      Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(2.0, 3.5), Complex(4.5, 3.0),
      Complex(-0.75, 2.75), Complex(2.5, 6.0), Complex(-0.5, 4.0), Complex(2.0, 3.5),
      Complex(0.0, 6.5), Complex(-1.0, 1.5), Complex(-0.25, 5.25), Complex(1.5, 1.0),
      Complex(3.5, 4.5), Complex(0.0, 6.5), Complex(2.25, 4.75), Complex(-2.0, 3.0)
    ))
  }

  test("Matrix-vector product") {
    val mat = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    val vec = Vec4c(Complex(1.0, 1.0), Complex(2.0, 3.0), Complex(1.0, -1.0), Complex(1.0, 0.0))
    assert(mat * vec == Vec4c(Complex(5.0, 8.5), Complex(4.0, 17.0), Complex(1.0, 8.0), Complex(1.0, 17.0)))
  }

  test("Matrix-vector product by values") {
    val mat = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    val vec = mat * (Complex(1.0, 1.0), Complex(2.0, 3.0), Complex(1.0, -1.0), Complex(1.0, 0.0))
    assert(vec == Vec4c(Complex(5.0, 8.5), Complex(4.0, 17.0), Complex(1.0, 8.0), Complex(1.0, 17.0)))
  }

  test("Transposed") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ).transposed == Mat4c(
      Complex(1.0, 2.0), Complex(0.5, 1.5), Complex(2.0, 3.0), Complex(3.0, 1.0),
      Complex(1.5, 1.0), Complex(3.0, 2.0), Complex(0.0, 1.0), Complex(2.0, 3.0),
      Complex(2.0, 1.0), Complex(1.0, 2.0), Complex(1.5, 2.5), Complex(2.5, 1.5),
      Complex(3.0, 0.0), Complex(2.0, 1.0), Complex(1.0, 0.0), Complex(0.0, 2.0)
    ))
  }

  test("Symmetric matrix") {
    assert(Mat4c(
      Complex.Zero, Complex.One, Complex.Zero, Complex.One,
      Complex.One, Complex.Zero, Complex.One, Complex.Zero,
      Complex.Zero, Complex.One, Complex.Zero, Complex.One,
      Complex.One, Complex.Zero, Complex.One, Complex.Zero
    ).isSymmetric)
  }

  test("Skew symmetric matrix") {
    assert(Mat4c(
      Complex.Zero, Complex.One, Complex.Zero, Complex.One,
      -Complex.One, Complex.Zero, Complex.One, Complex.Zero,
      -Complex.Zero, -Complex.One, Complex.Zero, Complex.One,
      -Complex.One, -Complex.Zero, -Complex.One, Complex.Zero
    ).isSkewSymmetric)
  }

  test("Complex conjugate of a matrix") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ).conjugate == Mat4c(
      Complex(1.0, -2.0), Complex(1.5, -1.0), Complex(2.0, -1.0), Complex(3.0, -0.0),
      Complex(0.5, -1.5), Complex(3.0, -2.0), Complex(1.0, -2.0), Complex(2.0, -1.0),
      Complex(2.0, -3.0), Complex(0.0, -1.0), Complex(1.5, -2.5), Complex(1.0, -0.0),
      Complex(3.0, -1.0), Complex(2.0, -3.0), Complex(2.5, -1.5), Complex(0.0, -2.0)
    ))
  }

  test("Conjugate transposed of a matrix") {
    assert(Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    ).hermitian == Mat4c(
      Complex(1.0, -2.0), Complex(0.5, -1.5), Complex(2.0, -3.0), Complex(3.0, -1.0),
      Complex(1.5, -1.0), Complex(3.0, -2.0), Complex(0.0, -1.0), Complex(2.0, -3.0),
      Complex(2.0, -1.0), Complex(1.0, -2.0), Complex(1.5, -2.5), Complex(2.5, -1.5),
      Complex(3.0, -0.0), Complex(2.0, -1.0), Complex(1.0, -0.0), Complex(0.0, -2.0)
    ))
  }

  test("Matrix product") {
    val a = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    val b = Mat4c(
      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0), Complex(1.5, 1.0),
      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0), Complex(2.0, 0.5),
      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0), Complex(2.0, 1.5),
      Complex(4.0, 3.5), Complex(2.0, 2.0), Complex(3.0, 1.5), Complex(1.0, 3.0)
    )
    assert(a * b == Mat4c(
      Complex(14.5, 24.25), Complex(11.5, 24.75), Complex(11.25, 15.5), Complex(7.5, 20.75),
      Complex(3.75, 28.25), Complex(6.75, 32.25), Complex(5.0, 22.5), Complex(2.25, 20.75),
      Complex(2.25, 23.75), Complex(2.0, 20.0), Complex(0.75, 16.25), Complex(-0.25, 18.75),
      Complex(0.75, 29.25), Complex(3.0, 31.5), Complex(1.25, 25.25), Complex(2.75, 20.25)
    ))
  }

  test("Matrix power") {
    val a = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    assert((a power 3) == (a * a * a))
  }

  test("Matrix determinant") {
    val a = Mat4c(
      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0), Complex(3.0, 0.0),
      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0), Complex(2.0, 1.0),
      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5), Complex(1.0, 0.0),
      Complex(3.0, 1.0), Complex(2.0, 3.0), Complex(2.5, 1.5), Complex(0.0, 2.0)
    )
    assert(a.determinant == Complex(34.75, -5.0))
  }
}
