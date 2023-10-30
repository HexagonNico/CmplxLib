package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex

case class Vec2c(x: Complex, y: Complex) extends ComplexVector[Vec2c] {

  def +(x: Complex, y: Complex): Vec2c = Vec2c(this.x + x, this.y + y)

  def plus(x: Complex, y: Complex): Vec2c = this + (x, y)

  override def +(v: Vec2c): Vec2c = this + (v.x, v.y)

  override def unary_- : Vec2c = Vec2c(-this.x, -this.y)

  def -(x: Complex, y: Complex): Vec2c = Vec2c(this.x - x, this.y - y)

  def minus(x: Complex, y: Complex): Vec2c = this - (x, y)

  override def *(r: Double): Vec2c = Vec2c(this.x * r, this.y * r)

  override def *(z: Complex): Vec2c = Vec2c(this.x * z, this.y * z)

  def *(x: Complex, y: Complex): Vec2c = Vec2c(this.x * x, this.y * y)

  def multiply(x: Complex, y: Complex): Vec2c = this * (x, y)

  override def *(v: Vec2c): Vec2c = this * (v.x, v.y)

  def dot(x: Complex, y: Complex): Complex = this.x * x + this.y * y

  override def dot(v: Vec2c): Complex = this.dot(v.x, v.y)

  override def lengthSquared: Complex = this dot this

  override def reciprocal: Vec2c = Vec2c(this.x.reciprocal, this.y.reciprocal)

  def /(x: Complex, y: Complex): Vec2c = Vec2c(this.x / x, this.y / y)

  def divide(x: Complex, y: Complex): Vec2c = this / (x, y)

  override def abs: Vec2c = Vec2c(Complex(this.x.abs, 0.0), Complex(this.y.abs, 0.0))
}
