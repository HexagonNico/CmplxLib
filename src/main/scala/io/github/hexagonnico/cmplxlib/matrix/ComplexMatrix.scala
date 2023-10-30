package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.ComplexVector
import io.github.hexagonnico.vecmatlib.matrix.MatAbstract

abstract class ComplexMatrix[M <: ComplexMatrix[M, V], V <: ComplexVector[V]] extends MatAbstract[M, V] {

  def *(r: Double): M

  def multipliedBy(r: Double): M = this * r

  def *(z: Complex): M

  def multipliedBy(z: Complex): M = this * z

  def conjugate: M

  def hermitian: M = this.conjugate.transposed

  def determinant: Complex
}
