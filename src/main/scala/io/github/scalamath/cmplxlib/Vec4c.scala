package io.github.scalamath.cmplxlib

import io.github.scalamath.DoubleEqualsApprox
import io.github.scalamath.vecmatlib.Vec4d

/**
 * A 4D vector using double-precision floating point coordinates.
 *
 * @constructor Constructs a 4D vector from the four given components.
 * @param x The vector's x component.
 * @param y The vector's y component.
 * @param z The vector's z component.
 * @param w The vector's w component.
 */
case class Vec4c(x: Complex, y: Complex, z: Complex, w: Complex) {

  /**
   * Constructs a 4D vector from the given components.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   */
  def this(xyz: Vec3c, w: Complex) = this(xyz.x, xyz.y, xyz.z, w)

  /**
   * Constructs a 4D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   */
  def this(xy: Vec2c, z: Complex, w: Complex) = this(xy.x, xy.y, z, w)

  /**
   * Returns a 2D vector composed of the x and the y components of this vector.
   *
   * @return A 2D vector composed of the x and the y components of this vector.
   */
  def xy: Vec2c = Vec2c(this.x, this.y)

  /**
   * Returns a 3D vector composed of the x, the y, and the z components of this vector.
   *
   * @return A 3D vector composed of the x, the y, and the z components of this vector.
   */
  def xyz: Vec3c = Vec3c(this.x, this.y, this.z)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @param w The w component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x + x, this.y + y, this.z + z, this.w + w)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @param w The w component to add.
   * @return The sum between this vector and the given values.
   */
  def plus(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this + (x, y, z, w)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec4c): Vec4c = this + (v.x, v.y, v.z, v.w)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec4c): Vec4c = this + v

  /**
   * Returns this same vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This same vector.
   */
  def unary_+ : Vec4c = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @param w The w component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x - x, this.y - y, this.z - z, this.w - w)

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @param w The w component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def minus(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this - (x, y, z, w)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec4c): Vec4c = this - (v.x, v.y, v.z, v.w)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec4c): Vec4c = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_- : Vec4c = Vec4c(-this.x, -this.y, -this.z, -this.w)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec4c = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @param z Value to multiply the z component by.
   * @param w Value to multiply the w component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x * x, this.y * y, this.z * z, this.w * w)

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The value to multiply the x component by.
   * @param y The value to multiply the y component by.
   * @param z The value to multiply the z component by.
   * @param w The value to multiply the w component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def multiply(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this * (x, y, z, w)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec4c): Vec4c = this * (v.x, v.y, v.z, v.w)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec4c): Vec4c = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Complex): Vec4c = this * (k, k, k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Complex): Vec4c = this * k

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Double): Vec4c = Vec4c(this.x * k, this.y * k, this.z * k, this.w * k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Double): Vec4c = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @param w The value to divide the w component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = Vec4c(this.x / x, this.y / y, this.z / z, this.w / w)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @param w The value to divide the w component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this / (x, y, z, w)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec4c): Vec4c = this / (v.x, v.y, v.z, v.w)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def divide(v: Vec4c): Vec4c = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Complex): Vec4c = this / (k, k, k, k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Complex): Vec4c = this / k

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Double): Vec4c = Vec4c(this.x / k, this.y / k, this.z / k, this.w / k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Double): Vec4c = this / k

  /**
   * Returns the inverse of this vector with respect to component-wise multiplication.
   *
   * @return The inverse of this vector.
   * @see [[Complex.inverse]]
   */
  def inverse: Vec4c = Vec4c(this.x.inverse, this.y.inverse, this.z.inverse, this.w.inverse)

  /**
   * Returns the conjugate of this complex vector.
   *
   * @return The conjugate of this complex vector.
   * @see [[Complex.conjugate]]
   */
  def conjugate: Vec4c = Vec4c(this.x.conjugate, this.y.conjugate, this.z.conjugate, this.w.conjugate)

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @param z The z component of the vector to multiply this one by.
   * @param w The w component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Complex, y: Complex, z: Complex, w: Complex): Complex = this.x * x.conjugate + this.y * y.conjugate + this.z * z.conjugate + this.w * w.conjugate

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec4c): Complex = this.dot(v.x, v.y, v.z, v.w)

  /**
   * Returns the squared length, or magnitude, or modulus, of this vector.
   *
   * When comparing vectors by their length, it is more efficient to compare them by their squared length, since computing it does not require computing a square root.
   *
   * @return The squared length of this vector.
   * @see [[length]]
   */
  def lengthSquared: Double = this.x.squaredModulus + this.y.squaredModulus + this.z.squaredModulus + this.w.squaredModulus

  /**
   * Returns the length, or magnitude, or modulus, of this vector.
   *
   * @return The length of this vector.
   * @see [[lengthSquared]]
   */
  def length: Double = math.sqrt(this.lengthSquared)

  /**
   * Returns the result of scaling this vector to unit length.
   * Equivalent to `v / v.length`.
   *
   * The resulting vector has the same direction as this one, but a length of `1.0`.
   *
   * @return The result of scaling this vector to unit length.
   * @see [[isNormalized]]
   */
  def normalized: Vec4c = this / this.length

  /**
   * Checks if this vector is a unit vector by checking if its length is approximately equal to `1.0`.
   *
   * @return True if this vector is a unit vector, otherwise false.
   * @see [[normalized]]
   */
  def isNormalized: Boolean = this.lengthSquared ~= 1.0

  /**
   * Returns a vector with the same direction as this one and a length not longer than the given limit.
   * Returns this same vector if its length is smaller than the given limit.
   *
   * @param limit The maximum length of the resulting vector.
   * @return A vector with the same direction as this one and a length not longer than the given limit.
   */
  def limitLength(limit: Double): Vec4c = {
    val length = this.length
    if(length > 0.0 && limit < length) {
      this / length * limit
    } else {
      this
    }
  }

  /**
   * Returns a vector whose components are the modulus, or the absolute value, of the components of this vector.
   *
   * Not to be confused with the [[length]] of the vector.
   *
   * @return A vector whose components are the modulus of the components of this vector.
   * @see [[Complex.modulus]]
   */
  def abs: Vec4d = Vec4d(this.x.modulus, this.y.modulus, this.z.modulus, this.w.modulus)

  /**
   * Returns a vector moved toward the given one by the given delta without going past the final value.
   *
   * @param to The final value of the vector.
   * @param delta The fixed delta by which this vector is moved.
   * @return A vector moved toward the given one by the given delta.
   */
  def moveToward(to: Vec4c, delta: Double): Vec4c = {
    val vd = to - this
    val length = vd.length
    if(length <= delta) {
      to
    } else {
      this + vd / length * delta
    }
  }

  /**
   * Computes the linear interpolation between this vector and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second vector.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between this vector and the given one.
   */
  def lerp(to: Vec4c, weight: Double): Vec4c = this + (to - this) * weight

  /**
   * Computes the normalized vector pointing from this one to the given one and returns the result.
   *
   * This method is equivalent to `(b - a).normalized`.
   *
   * @param v The second vector.
   * @return The normalized vector pointing from this one to the given one.
   */
  def directionTo(v: Vec4c): Vec4c = (v - this).normalized

  /**
   * Computes the normalized vector pointing from this one to the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The normalized vector pointing from this one to the one with the given components.
   */
  def directionTo(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this.directionTo(Vec4c(x, y, z, w))

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec4c): Double = (v - this).lengthSquared

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The squared distance between this vector and the one with the given components.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(x: Complex, y: Complex, z: Complex, w: Complex): Double = this.distanceSquaredTo(Vec4c(x, y, z, w))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec4c): Double = (v - this).length

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The squared between this vector and the one with the given components.
   * @see [[length]]
   */
  def distanceTo(x: Complex, y: Complex, z: Complex, w: Complex): Double = this.distanceTo(Vec4c(x, y, z, w))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec4c): Double = math.acos(this.dot(v).real / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Complex, y: Complex, z: Complex, w: Complex): Double = this.angleTo(Vec4c(x, y, z, w))

  /**
   * Projects this vector on the given one and returns the result.
   *
   * @param v The second vector.
   * @return The projection of this vector on the given one.
   */
  def project(v: Vec4c): Vec4c = v * (this.dot(v) / v.lengthSquared)

  /**
   * Projects this vector on the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The projection of this vector on the one with the given components.
   */
  def project(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this.project(Vec4c(x, y, z, w))

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec4c): Vec4c = this - (n * (this.dot(n) * 2.0))

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @param z The z component of the reflection normal.
   * @param w The w component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this.reflect(Vec4c(x, y, z, w))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec4c): Vec4c = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @param w The w component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this.bounce(Vec4c(x, y, z, w))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec4c): Vec4c = this - (n * this.dot(n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @param w The w component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Complex, y: Complex, z: Complex, w: Complex): Vec4c = this.slide(Vec4c(x, y, z, w))

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Complex, y: Complex, z: Complex, w: Complex): Mat4c = Mat4c(
    this.x * x, this.x * y, this.x * z, this.x * w,
    this.y * x, this.y * y, this.y * z, this.y * w,
    this.z * x, this.z * y, this.z * z, this.z * w,
    this.w * x, this.w * y, this.w * z, this.w * w
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec4c): Mat4c = this.outer(v.x, v.y, v.z, v.w)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @param w The w component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = this.x == x && this.y == y && this.z == z && this.w == w

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @param w The w component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def equals(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = this == (x, y, z, w)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @param w The w component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def ~=(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = (this.x ~= x) && (this.y ~= y) && (this.z ~= z) && (this.w ~= w)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @param w The w component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def equalsApprox(x: Complex, y: Complex, z: Complex, w: Complex): Boolean = this ~= (x, y, z, w)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def ~=(v: Vec4c): Boolean = this ~= (v.x, v.y, v.z, v.w)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(v: Vec4c): Boolean = this ~= v

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`, `2` for `z`, `3` for `w`.
   *
   * @param i The index of the requested component. Must be either 0, 1, 2, or 3.
   * @return The component of this vector at the given index.
   * @throws MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Complex = i match {
    case 0 => this.x
    case 1 => this.y
    case 2 => this.z
    case 3 => this.w
  }

  /**
   * Returns a vector whose components are the real part of the components of this vector.
   *
   * @return A vector whose components are the real part of the components of this vector.
   */
  def real: Vec4d = Vec4d(this.x.real, this.y.real, this.z.real, this.w.real)

  /**
   * Returns a vector whose components are the imaginary part of the components of this vector.
   *
   * @return A vector whose components are the imaginary part of the components of this vector.
   */
  def imaginary: Vec4d = Vec4d(this.x.imaginary, this.y.imaginary, this.z.imaginary, this.w.imaginary)
}

/**
 * Constants, factory methods, and implicits for vectors.
 */
object Vec4c {

  /** Shorthand for `Vec4c(0.0, 0.0, 0.0, 0.0)` */
  val Zero: Vec4c = Vec4c(0.0, 0.0, 0.0, 0.0)

  /**
   * Constructs a 4D vector from the given components.
   *
   * @param xyz The vector's x, y, and z components.
   * @param w The vector's w component.
   * @return A 4D vector constructed from the given components.
   */
  def apply(xyz: Vec3c, w: Complex) = new Vec4c(xyz, w)

  /**
   * Constructs a 4D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @param w The vector's w component.
   * @return A 4D vector constructed from the given components.
   */
  def apply(xy: Vec2c, z: Complex, w: Complex) = new Vec4c(xy, z, w)

  /**
   * Allows to use the `*` and `/` operators with a scalar as `1.0 * vector`.
   *
   * @param self The scalar value.
   */
  implicit class ComplexExtender(val self: Complex) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec4c): Vec4c = v * self

    /**
     * Multiplies the [[Vec4c.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec4c): Vec4c = self * v.inverse
  }

  /**
   * Allows to use the `*` and `/` operators with a scalar as `1.0 * vector`.
   *
   * @param self The scalar value.
   */
  implicit class RealExtender(val self: Double) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec4c): Vec4c = v * self

    /**
     * Multiplies the [[Vec4c.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec4c): Vec4c = self * v.inverse
  }

  /**
   * Implicit conversion from [[Vec4d]] to [[Vec4c]].
   */
  implicit val vec4dToVec4c: Vec4d => Vec4c = v => Vec4c(v.x, v.y, v.z, v.w)
}
