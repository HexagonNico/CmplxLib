package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.Vec2c

case class Mat2c(m00: Complex, m01: Complex, m10: Complex, m11: Complex) extends ComplexMatrix[Mat2c, Vec2c] {

  override def +(m: Mat2c): Mat2c = Mat2c(
    this.m00 + m.m00, this.m01 + m.m01,
    this.m10 + m.m10, this.m11 + m.m11
  )

  override def unary_- : Mat2c = Mat2c(
    -this.m00, -this.m01,
    -this.m10, -this.m11
  )

  override def *(r: Double): Mat2c = Mat2c(
    this.m00 * r, this.m01 * r,
    this.m10 * r, this.m11 * r
  )

  override def *(z: Complex): Mat2c = Mat2c(
    this.m00 * z, this.m01 * z,
    this.m10 * z, this.m11 * z
  )

  def row0: Vec2c = Vec2c(this.m00, this.m01)

  def row1: Vec2c = Vec2c(this.m10, this.m11)

  def col0: Vec2c = Vec2c(this.m00, this.m10)

  def col1: Vec2c = Vec2c(this.m01, this.m11)

  override def *(v: Vec2c): Vec2c = Vec2c(this.row0 dot v, this.row1 dot v)

  def *(x: Complex, y: Complex): Vec2c = this * Vec2c(x, y)

  def multiply(x: Complex, y: Complex): Vec2c = this * (x, y)

  override def *(m: Mat2c): Mat2c = Mat2c(
    this.row0 dot m.col0, this.row0 dot m.col1,
    this.row1 dot m.col0, this.row1 dot m.col1
  )

  override def transposed: Mat2c = Mat2c(
    this.m00, this.m10,
    this.m01, this.m11
  )

  override def conjugate: Mat2c = Mat2c(
    this.m00.conjugate, this.m01.conjugate,
    this.m10.conjugate, this.m11.conjugate
  )

  override def power(exp: Int): Mat2c = {
    if (exp < 0) {
      this.transposed.power(-exp)
    } else if (exp == 0) {
      Mat2c.Identity
    } else {
      this * this.power(exp - 1)
    }
  }

  override def determinant: Complex = this.m00 * this.m11 - this.m01 * this.m10
}

object Mat2c {

  val Identity: Mat2c = Mat2c(Complex.One, Complex.Zero, Complex.Zero, Complex.One)

  val Zero: Mat2c = Mat2c(Complex.Zero, Complex.Zero, Complex.Zero, Complex.Zero)

  implicit class RealExtender(val r: Double) extends AnyVal {

    def *(m: Mat2c): Mat2c = m * r
  }

  implicit class ComplexExtender(val z: Complex) extends AnyVal {

    def *(m: Mat2c): Mat2c = m * z
  }
}