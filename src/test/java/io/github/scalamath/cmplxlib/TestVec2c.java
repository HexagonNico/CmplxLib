package io.github.scalamath.cmplxlib;

import org.junit.Assert;
import org.junit.Test;

public class TestVec2c {

    @Test
    public void testSumVectorAndValues() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var x = new Complex(2.0, 2.5);
        var y = new Complex(3.0, 0.5);
        var res = new Vec2c(new Complex(3.0, 4.5), new Complex(4.5, 1.5));
        Assert.assertEquals(res, vec.plus(x, y));
    }

    @Test
    public void testSumOfTwoVectors() {
        var a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        var res = new Vec2c(new Complex(3.0, 4.5), new Complex(4.5, 1.5));
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testVectorMinusValues() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var x = new Complex(2.0, 2.5);
        var y = new Complex(3.0, 0.5);
        var res = new Vec2c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5));
        Assert.assertEquals(res, vec.minus(x, y));
    }

    @Test
    public void testSubtractionOfTwoVectors() {
        var a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        var res = new Vec2c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5));
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testNegatedVector() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var res = new Vec2c(new Complex(-1.0, -2.0), new Complex(-1.5, -1.0));
        Assert.assertEquals(res, vec.negated());
    }

    @Test
    public void testComponentWiseMultiplicationWithValues() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var x = new Complex(2.0, 2.5);
        var y = new Complex(3.0, 0.5);
        var res = new Vec2c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75));
        Assert.assertEquals(res, vec.multiply(x, y));
    }

    @Test
    public void testComponentWiseMultiplicationWithVector() {
        var a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        var res = new Vec2c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75));
        Assert.assertEquals(res, a.multiply(b));
    }

    @Test
    public void testVectorMultiplyComplex() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var z = new Complex(1.5, 1.0);
        var res = new Vec2c(new Complex(-0.5,  4.0), new Complex(1.25, 3.0));
        Assert.assertEquals(res, vec.multipliedBy(z));
    }

    @Test
    public void testVectorMultiplyReal() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var res = new Vec2c(new Complex(1.5, 3.0), new Complex(2.25, 1.5));
        Assert.assertEquals(res, vec.multipliedBy(1.5));
    }

    @Test
    public void testComponentWiseDivisionWithValues() {
        var vec = new Vec2c(new Complex(8.0, 6.0), new Complex(6.0, 8.0));
        var x = new Complex(2.0, 2.0);
        var y = new Complex(4.0, 2.0);
        var res = new Vec2c(new Complex(3.5, 0.5), new Complex(2.0, 1.0));
        Assert.assertEquals(res, vec.divide(x, y));
    }

    @Test
    public void testComponentWiseDivisionWithVector() {
        var a = new Vec2c(new Complex(8.0, 6.0), new Complex(6.0, 8.0));
        var b = new Vec2c(new Complex(2.0, 2.0), new Complex(4.0, 2.0));
        var res = new Vec2c(new Complex(3.5, 0.5), new Complex(2.0, 1.0));
        Assert.assertEquals(res, a.divide(b));
    }

    @Test
    public void testVectorDividedByComplex() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var z = new Complex(1.0, 1.0);
        var res = new Vec2c(new Complex(3.0 / 2.0, 0.5), new Complex(1.25, -0.25));
        Assert.assertEquals(res, vec.dividedBy(z));
    }

    @Test
    public void testVectorDividedByReal() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        var res = new Vec2c(new Complex(0.5, 1.0), new Complex(0.75, 0.5));
        Assert.assertEquals(res, vec.dividedBy(2.0));
    }

    @Test
    public void testVectorEqualsValues() {
        var vec = new Vec2c(new Complex(1.0, 2.0), new Complex(3.0, 2.0));
        var x = new Complex(1.0, 2.0);
        var y = new Complex(3.0, 2.0);
        Assert.assertTrue(vec.equals(x, y));
    }

    @Test
    public void testVectorEqualsApproxValues() {
        var vec = new Vec2c(new Complex(1.00000001, 1.99999999), new Complex(2.99999999, 2.0));
        var x = new Complex(1.0, 2.0);
        var y = new Complex(3.0, 2.0);
        Assert.assertTrue(vec.equalsApprox(x, y));
    }

    @Test
    public void testVectorEqualsApprox() {
        var a = new Vec2c(new Complex(1.00000001, 1.99999999), new Complex(2.99999999, 2.0));
        var b = new Vec2c(new Complex(1.0, 2.0), new Complex(3.0, 2.0));
        Assert.assertTrue(a.equalsApprox(b));
    }
}
