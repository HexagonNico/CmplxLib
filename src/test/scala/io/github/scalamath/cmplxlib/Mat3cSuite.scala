package io.github.scalamath.cmplxlib

import org.scalatest.funsuite.AnyFunSuite

class Mat3cSuite extends AnyFunSuite {

//  test("Sum of matrices") {
//    val a = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    val b = Mat3c(
//      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0),
//      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0),
//      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0)
//    )
//    assert(a + b == Mat3c(
//      Complex(3.0, 4.5), Complex(4.5, 1.5), Complex(3.0, 3.0),
//      Complex(1.5, 3.0), Complex(7.0, 5.5), Complex(2.5, 4.0),
//      Complex(5.0, 3.5), Complex(1.0, 2.0), Complex(4.0, 2.5)
//    ))
//  }
//
//  test("Negative matrix") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ).negated == Mat3c(
//      Complex(-1.0, -2.0), Complex(-1.5, -1.0), Complex(-2.0, -1.0),
//      Complex(-0.5, -1.5), Complex(-3.0, -2.0), Complex(-1.0, -2.0),
//      Complex(-2.0, -3.0), Complex(-0.0, -1.0), Complex(-1.5, -2.5)
//    ))
//  }
//
//  test("Subtraction of matrices") {
//    val a = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    val b = Mat3c(
//      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0),
//      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0),
//      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0)
//    )
//    assert(a - b == Mat3c(
//      Complex(-1.0, -0.5), Complex(-1.5, 0.5), Complex(1.0, -1.0),
//      Complex(-0.5, 0.0), Complex(-1.0, -1.5), Complex(-0.5, 0.0),
//      Complex(-1.0, 2.5), Complex(-1.0, 0.0), Complex(-1.0, 2.5)
//    ))
//  }
//
//  test("Matrix multiplied by a real number") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ) * 1.5 == Mat3c(
//      Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(3.0, 1.5),
//      Complex(0.75, 2.25), Complex(4.5, 3.0), Complex(1.5, 3.0),
//      Complex(3.0, 4.5), Complex(0.0, 1.5), Complex(2.25, 3.75)
//    ))
//  }
//
//  test("Matrix multiplied by a real number commutativity") {
//    assert(1.5 * Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ) == Mat3c(
//      Complex(1.5, 3.0), Complex(2.25, 1.5), Complex(3.0, 1.5),
//      Complex(0.75, 2.25), Complex(4.5, 3.0), Complex(1.5, 3.0),
//      Complex(3.0, 4.5), Complex(0.0, 1.5), Complex(2.25, 3.75)
//    ))
//  }
//
//  test("Matrix multiplied by a complex number") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ) * Complex(1.5, 1.0) == Mat3c(
//      Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(2.0, 3.5),
//      Complex(-0.75, 2.75), Complex(2.5, 6.0), Complex(-0.5, 4.0),
//      Complex(0.0, 6.5), Complex(-1.0, 1.5), Complex(-0.25, 5.25)
//    ))
//  }
//
//  test("Matrix multiplied by a complex number commutativity") {
//    assert(Complex(1.5, 1.0) * Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ) == Mat3c(
//      Complex(-0.5, 4.0), Complex(1.25, 3.0), Complex(2.0, 3.5),
//      Complex(-0.75, 2.75), Complex(2.5, 6.0), Complex(-0.5, 4.0),
//      Complex(0.0, 6.5), Complex(-1.0, 1.5), Complex(-0.25, 5.25)
//    ))
//  }
//
//  test("Matrix-vector product") {
//    val mat = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    val vec = Vec3c(Complex(1.0, 1.0), Complex(2.0, 3.0), Complex(1.0, -1.0))
//    assert(mat * vec == Vec3c(Complex(2.0, 8.5), Complex(2.0, 16.0), Complex(0.0, 8.0)))
//  }
//
//  test("Matrix-vector product by values") {
//    val mat = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    val vec = mat * (Complex(1.0, 1.0), Complex(2.0, 3.0), Complex(1.0, -1.0))
//    assert(vec == Vec3c(Complex(2.0, 8.5), Complex(2.0, 16.0), Complex(0.0, 8.0)))
//  }
//
//  test("Transposed") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ).transposed == Mat3c(
//      Complex(1.0, 2.0), Complex(0.5, 1.5), Complex(2.0, 3.0),
//      Complex(1.5, 1.0), Complex(3.0, 2.0), Complex(0.0, 1.0),
//      Complex(2.0, 1.0), Complex(1.0, 2.0), Complex(1.5, 2.5)
//    ))
//  }
//
//  test("Symmetric matrix") {
//    assert(Mat3c(
//      Complex.Zero, Complex.One, Complex.Zero,
//      Complex.One, Complex.Zero, Complex.One,
//      Complex.Zero, Complex.One, Complex.Zero
//    ).isSymmetric)
//  }
//
//  test("Skew symmetric matrix") {
//    assert(Mat3c(
//      Complex.Zero, Complex.One, Complex.Zero,
//      -Complex.One, Complex.Zero, Complex.One,
//      -Complex.Zero, -Complex.One, Complex.Zero
//    ).isSkewSymmetric)
//  }
//
//  test("Complex conjugate of a matrix") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ).conjugate == Mat3c(
//      Complex(1.0, -2.0), Complex(1.5, -1.0), Complex(2.0, -1.0),
//      Complex(0.5, -1.5), Complex(3.0, -2.0), Complex(1.0, -2.0),
//      Complex(2.0, -3.0), Complex(0.0, -1.0), Complex(1.5, -2.5)
//    ))
//  }
//
//  test("Conjugate transposed of a matrix") {
//    assert(Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    ).hermitian == Mat3c(
//      Complex(1.0, -2.0), Complex(0.5, -1.5), Complex(2.0, -3.0),
//      Complex(1.5, -1.0), Complex(3.0, -2.0), Complex(0.0, -1.0),
//      Complex(2.0, -1.0), Complex(1.0, -2.0), Complex(1.5, -2.5)
//    ))
//  }
//
//  test("Matrix product") {
//    val a = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    val b = Mat3c(
//      Complex(2.0, 2.5), Complex(3.0, 0.5), Complex(1.0, 2.0),
//      Complex(1.0, 1.5), Complex(4.0, 3.5), Complex(1.5, 2.0),
//      Complex(3.0, 0.5), Complex(1.0, 1.0), Complex(2.5, 0.0)
//    )
//    assert(a * b == Mat3c(
//      Complex(2.5, 13.75), Complex(5.5, 18.75), Complex(2.25, 11.0),
//      Complex(-0.75, 17.25), Complex(4.75, 26.25), Complex(0.5, 16.5),
//      Complex(-1.75, 20.25), Complex(0.0, 18.0), Complex(-2.25, 14.75)
//    ))
//  }
//
//  test("Matrix power") {
//    val a = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    assert((a power 3) == (a * a * a))
//  }
//
//  test("Matrix determinant") {
//    val a = Mat3c(
//      Complex(1.0, 2.0), Complex(1.5, 1.0), Complex(2.0, 1.0),
//      Complex(0.5, 1.5), Complex(3.0, 2.0), Complex(1.0, 2.0),
//      Complex(2.0, 3.0), Complex(0.0, 1.0), Complex(1.5, 2.5)
//    )
//    assert(a.determinant == Complex(-13.0, -9.75))
//  }
}
