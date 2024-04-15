
# CmplxLib

A Scala library for complex numbers, complex vectors, and complex matrices.

## Project goals

CmplxLib is an extension of [VecMatLib](https://github.com/HexagonNico/VecMatLib) adding complex numbers, complex vectors, and complex matrices.

Vectors and matrices structures are written in Scala to make the best use possible of Scala's operator overloading.
All methods with symbolic names have an alias for better interoperability with java.

All operations in CmplxLib are designed to **not** modify the object on which the operation is invoked to respect the principles of purity and immutability of functional programming.

## Complex numbers

The `Complex` class is the cartesian representation of a complex number in cartesian coordinates in the form `a + ib`,
where `a` is the real part and `b` is the imaginary part.

Complex numbers use two double-precision floating point numbers.

Scala example:
```scala
val z = Complex(2.0, 1.0) // 2 + i
val w = Complex.I // The imaginary unit

val sum = z + w // Result: 2 + 2i

val product = z * (1.0, 1.0) // (2 + i) * (1 + i) = 1 + 3i
```

Java example:
```java
Complex z = new Complex(2.0, 1.0); // 2 + i
Complex w = Complex.I; // The imaginary unit

Complex sum = z.plus(w); // Result: 2 + 2i

Complex product = z.multiply(1.0, 1.0); // (2 + i) * (1 + i) = 1 + 3i
```

In Scala, complex numbers can also be expressed in their cartesian form using the constant `I`.

```scala
import io.github.scalamath.cmplxlib.Complex.I

val z = 3.0 + 2.0 * I // Equivalent to Complex(3.0, 2.0)
val w = z + 3.0 // Results in 6 + 2i
```

## Vectors and matrices

The vector and matrix packages offer 2-dimensional, 3-dimensional, and 4-dimensional complex vectors, as well as 2x2,
3x3, and 4x4 complex matrices.

They offer the same operations as real vectors and matrices, with the additional operations involving complex numbers.

Scala example:

```scala
import io.github.scalamath.cmplxlib.Complex.I

val vector = Vec2c(1.0 + 2.0 * I, 2.0 + 1.0 * I)
val conjugate = vector.conjugate // (1 - 2i, 2 - i)

val matrix = Mat2c(
  1.0 + 2.0 * I, 1.5 + 1.0 * I,
  0.5 + 1.5 * I, 3.0 + 2.0 * I
)

val product = matrix * vector
```

Java example:
```java
Vec2c vector = new Vec2c(new Complex(1.0, 2.0), new Complex(2.0, 1.0)); // [1 + 2i, 2 + i]
Vec2c conjugate = vector.conjugate(); // [1 - 2i, 2 - i]

Mat2c matrix = new Mat2c(
  new Complex(1.0, 2.0), new Complex(1.5, 1.0),
  new Complex(0.5, 1.5), new Complex(3.0, 2.0)
);

Vec2c product = matrix.multiply(vector);
```

## Multithreading

Due to VecMatLib not using any internal or temporal objects during any computations, neither modifying objects on which operations are called, it can be used safely in a multithreaded application.

## Add CmplxLib to your project

### sbt

```
libraryDependencies += "io.github.scalamath" % "cmplxlib" % "2.0"
```

### Maven

```
<dependency>
    <groupId>io.github.scalamath</groupId>
    <artifactId>cmplxlib</artifactId>
    <version>2.0</version>
</dependency>
```

### Gradle

```
implementation 'io.github.scalamath:cmplxlib:2.0'
```

## Questions and answers

**Q**: Why does CmplxLib not use scala 3?

**A**: One of the design goals of CmplxLib is to be usable both in Scala and Java. Support for Scala 3 in IDEs is still actively being developed, therefore a Scala 3 library may not be suitable to work with.

**Q**: Why are complex vectors and matrices not included in [VecMatLib](https://github.com/HexagonNico/VecMatLib)?

**A**: There may be applications where complex numbers are not necessary, therefore in that case one can depend on VecMatLib without having to include an unnecessary dependency for complex numbers.

## Contributing

CmplxLib was developed by a single person as an extension of [VecMatLib](https://github.com/HexagonNico/VecMatLib).

Your contributions are always welcome! Please submit a pull request or open an issue if you want to contribute with bug
fixes, code improvements, documentation, and better unit test coverage.

## Support

Support the project with a donation:

* [PayPal](https://paypal.me/hexagonnico)
* [Ko-fi](https://ko-fi.com/HexagonNico)