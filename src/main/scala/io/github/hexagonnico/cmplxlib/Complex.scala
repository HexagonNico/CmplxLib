package io.github.hexagonnico.cmplxlib

import io.github.hexagonnico.vecmatlib.Double2

case class Complex(a: Double, b: Double) extends Double2 {

  def +(a: Double, b: Double): Complex = Complex(this.a + a, this.b + b)

  def plus(a: Double, b: Double): Complex = this + (a, b)

  def +(z: Complex): Complex = this + (z.a, z.b)

  def plus(z: Complex): Complex = this + z

  def unary_-(): Complex = Complex(-this.a, -this.b)

  def negated: Complex = -this

  def -(a: Double, b: Double): Complex = Complex(this.a - a, this.b - b)

  def minus(a: Double, b: Double): Complex = this - (a, b)

  def -(z: Complex): Complex = this - (z.a, z.b)

  def minus(z: Complex): Complex = this - z

  def *(k: Double): Complex = Complex(this.a * k, this.b * k)

  def multipliedBy(k: Double): Complex = this * k

  def *(a: Double, b: Double): Complex = Complex(this.a * a - this.b * b, this.a * b + this.b * a)

  def multiply(a: Double, b: Double): Complex = this * (a, b)

  def *(z: Complex): Complex = this * (z.a, z.b)

  def multiply(z: Complex): Complex = this * z

  def /(k: Double): Complex = Complex(this.a / k, this.b / k)

  def dividedBy(k: Double): Complex = this / k

  def conjugate: Complex = Complex(this.a, -this.b)

  def modulusSquared: Double = this.a * this.a + this.b * b

  def modulus: Double = math.sqrt(modulusSquared)

  def reciprocal: Complex = this.conjugate / this.modulusSquared

  def /(z: Complex): Complex = this * z.reciprocal

  def divide(z: Complex): Complex = this / z

  override def x: Double = this.a

  override def y: Double = this.b
}
