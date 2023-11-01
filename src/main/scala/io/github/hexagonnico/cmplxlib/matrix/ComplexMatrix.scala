package io.github.hexagonnico.cmplxlib.matrix

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.cmplxlib.vector.ComplexVector
import io.github.hexagonnico.vecmatlib.matrix.MatAbstract

/**
 * Abstract class with operations for complex matrices.
 *
 * @tparam M The matrix class extending this one
 * @tparam V The corresponding vector class
 */
abstract class ComplexMatrix[M <: ComplexMatrix[M, V], V <: ComplexVector[V]] extends MatAbstract[M, V] {

  /**
   * Returns the product of this matrix by the given real number.
   *
   * @param r The real number by which this matrix is multiplied
   * @return The product of this matrix by the given real number
   */
  def *(r: Double): M

  /**
   * Returns the product of this matrix by the given real number.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param r The real number by which this matrix is multiplied
   * @return The product of this matrix by the given real number
   */
  def multiply(r: Double): M = this * r

  /**
   * Returns the product of this matrix by the given complex number.
   *
   * @param z The complex number by which this matrix is multiplied
   * @return The product of this matrix by the given complex number
   */
  def *(z: Complex): M

  /**
   * Returns the product of this matrix by the given complex number.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param z The complex number by which this matrix is multiplied
   * @return The product of this matrix by the given complex number
   */
  def multiply(z: Complex): M = this * z

  /**
   * Returns the complex conjugate of this matrix.
   *
   * The conjugate of a matrix is a matrix where every element is its complex conjugate.
   *
   * @return The complex conjugate of this matrix
   */
  def conjugate: M

  /**
   * Returns the [[conjugate]] [[transposed]] of this matrix.
   *
   * @return The conjugate transposed of this matrix
   */
  def hermitian: M = this.conjugate.transposed

  /**
   * Returns the determinant of this matrix.
   *
   * @return The determinant of this matrix
   */
  def determinant: Complex
}
