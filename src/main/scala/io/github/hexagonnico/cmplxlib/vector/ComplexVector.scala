package io.github.hexagonnico.cmplxlib.vector

import io.github.hexagonnico.cmplxlib.Complex
import io.github.hexagonnico.vecmatlib.vector.VecAbstract

/**
 * Abstract class with operations for complex vectors.
 * 
 * @tparam V The vector class extending this one
 */
abstract class ComplexVector[V <: ComplexVector[V]] extends VecAbstract[V] {

  /**
   * Returns the product between this vector and the given real number.
   *
   * @param r The real number to which the vector is multiplied
   * @return The result of the product between this vector and the given real number
   */
  def *(r: Double): V

  /**
   * Returns the product between this vector and the given real number.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param r The real number to which the vector is multiplied
   * @return The result of the product between this vector and the given real number
   */
  def multiply(r: Double): V = this * r

  /**
   * Returns the product between this vector and the given complex number.
   *
   * @param z The complex number to which the vector is multiplied
   * @return The result of the product between this vector and the given complex number
   */
  def *(z: Complex): V

  /**
   * Returns the product between this vector and the given complex number.
   *
   * This method can be used in place of the '*' operator for better interoperability with Java.
   *
   * @param z The complex number to which the vector is multiplied
   * @return The result of the product between this vector and the given complex number
   */
  def multiply(z: Complex): V = this * z

  /**
   * Returns the result of the division of this vector by the given real number.
   *
   * @param r The real number by which the vector is divided
   * @return The result of the division of this vector by the given real number
   */
  def /(r: Double): V = this * (1.0 / r)

  /**
   * Returns the result of the division of this vector by the given real number.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param r The real number by which the vector is divided
   * @return The result of the division of this vector by the given real number
   */
  def divide(r: Double): V = this / r

  /**
   * Returns the result of the division of this vector by the given complex number.
   *
   * @param z The complex number by which the vector is divided
   * @return The result of the division of this vector by the given complex number
   */
  def /(z: Complex): V = this * z.inverse

  /**
   * Returns the result of the division of this vector by the given complex number.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param z The complex number by which the vector is divided
   * @return The result of the division of this vector by the given complex number
   */
  def divide(z: Complex): V = this / z

  /**
   * Returns the result of the dot product (or scalar product) between this vector and the given one.
   *
   * @param v The vector by which this one is multiplied
   * @return The result of the dot product between this vector and the given one
   */
  def dot(v: V): Complex

  /**
   * Returns the squared length (or squared magnitude) of this vector.
   *
   * @return The squared length of this vector
   */
  def lengthSquared: Double

  /**
   * Returns the length (or magnitude) of this vector.
   *
   * @return The length (or magnitude) of this vector
   */
  def length: Double = math.sqrt(this.lengthSquared)

  /**
   * Returns a normalized vector that has the same direction as this one
   *
   * @return A vector with the same direction as this one and length 1
   */
  def normalized: V = this / this.length

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector
   * @return The angle in radians between this vector and the given one
   */
  override def angle(v: V): Double = math.acos((this dot v).real / (this.length * v.length))

  /**
   * Returns the complex conjugate of this vector.
   *
   * The conjugate of a vector is a vector where every element is its complex conjugate.
   *
   * @return The complex conjugate of this vector
   */
  def conjugate: V

  /**
   * Returns a vector whose components are the multiplicative inverse of this vector's components.
   *
   * @return A vector whose components are the multiplicative inverse of this vector's components
   */
  def inverse: V

  /**
   * Returns the component-wise division between this vector and the given one.
   *
   * @param v The second operand of the division
   * @return The component-wise division between this vector and the given one
   */
  def /(v: V): V = this * v.inverse

  /**
   * Returns the component-wise division between this vector and the given one.
   *
   * This method can be used in place of the '/' operator for better interoperability with Java.
   *
   * @param v The second operand of the division
   * @return The component-wise division between this vector and the given one
   */
  def divide(v: V): V = this / v
}
