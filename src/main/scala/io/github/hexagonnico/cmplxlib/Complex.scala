package io.github.hexagonnico.cmplxlib

import io.github.hexagonnico.vecmatlib.Double2

case class Complex(a: Double, b: Double) extends Double2 {

  def +(a: Double, b: Double): Complex = Complex(this.a + a, this.b + b)

  def plus(a: Double, b: Double): Complex = this + (a, b)

  def +(r: Double): Complex = this + (r, 0.0)

  def plus(r: Double): Complex = this + r

  def +(z: Complex): Complex = this + (z.a, z.b)

  def plus(z: Complex): Complex = this + z

  def unary_-(): Complex = Complex(-this.a, -this.b)

  def negated: Complex = -this

  def -(a: Double, b: Double): Complex = Complex(this.a - a, this.b - b)

  def minus(a: Double, b: Double): Complex = this - (a, b)

  def -(r: Double): Complex = this - (r, 0.0)

  def minus(r: Double): Complex = this - r

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

  def abs: Double = Complex.abs(this)

  def reciprocal: Complex = this.conjugate / (this.a * this.a + this.b * b)

  def /(z: Complex): Complex = this * z.reciprocal

  def divide(z: Complex): Complex = this / z

  def arg: Double = math.atan2(this.imaginary, this.real)

  def real: Double = this.a

  def imaginary: Double = this.b

  override def x: Double = this.a

  override def y: Double = this.b
}

object Complex {

  val I: Complex = Complex(0.0, 1.0)

  def abs(z: Complex): Double = math.sqrt(z.a * z.a + z.b * z.b)

  def exp(z: Complex): Complex = math.exp(z.a) * Complex(math.cos(z.b), math.sin(z.b))

  def sin(z: Complex): Complex = 0.5 * I * (exp(-I * z) - exp(I * z))

  def cos(z: Complex): Complex = 0.5 * (exp(I * z) + exp(-I * z))

  def sqrt(z: Complex): Complex = {
    val abs = z.abs
    0.5 * math.sqrt(2.0) * Complex(math.sqrt(abs + z.a), math.signum(z.b) * math.sqrt(abs - z.a))
  }

  def log(z: Complex): Complex = math.log(z.abs) + I * z.arg

  def asin(z: Complex): Complex = -I * log(I * z + sqrt(1.0 - z * z))

  def acos(z: Complex): Complex = 0.5 * math.Pi + I * log(I * z + sqrt(1.0 - z * z))

  implicit class CommutativeExtender(val r: Double) extends AnyVal {

    def +(z: Complex): Complex = z + r

    def -(z: Complex): Complex = -z + r

    def *(z: Complex): Complex = z * r

    def /(z: Complex): Complex = r * z.reciprocal
  }
}
