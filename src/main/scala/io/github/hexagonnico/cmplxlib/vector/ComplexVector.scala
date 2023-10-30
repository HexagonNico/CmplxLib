package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.vecmatlib.vector.VecAbstract

abstract class ComplexVector[V <: ComplexVector[V]] extends VecAbstract[V] {

  def *(r: Double): V

  def multipliedBy(r: Double): V = this * r

  def *(z: Complex): V

  def multipliedBy(z: Complex): V = this * z

  def /(r: Double): V = this * (1.0 / r)

  def dividedBy(r: Double): V = this / r

  def /(z: Complex): V = this * z.reciprocal

  def dividedBy(z: Complex): V = this / z

  def dot(v: V): Complex

  def lengthSquared: Double

  def length: Double = math.sqrt(this.lengthSquared)

  def normalized: V = this / this.length

  override def angle(v: V): Double = math.acos((this dot v).real / (this.length * v.length))

  def reciprocal: V

  def /(v: V): V = this * v.reciprocal

  def divide(v: V): V = this / v
}
