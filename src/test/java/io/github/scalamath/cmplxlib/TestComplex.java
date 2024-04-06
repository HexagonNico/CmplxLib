package io.github.scalamath.cmplxlib;

import org.junit.Assert;
import org.junit.Test;

public class TestComplex {

    @Test
    public void testSumWithTwoValues() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(3.5, 3.0);
        Assert.assertEquals(res, z.plus(1.5, 2.0));
    }

    @Test
    public void testSumWithRealNumber() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(3.5, 1.0);
        Assert.assertEquals(res, z.plus(1.5));
    }

    @Test
    public void testSumOfTwoComplexNumbers() {
        var z = new Complex(2.0, 1.0);
        var w = new Complex(1.5, 2.0);
        var res = new Complex(3.5, 3.0);
        Assert.assertEquals(res, z.plus(w));
    }

    @Test
    public void testSubtractTwoValues() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(0.5, -1.0);
        Assert.assertEquals(res, z.minus(1.5, 2.0));
    }

    @Test
    public void testSubtractRealNumber() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(0.5, 1.0);
        Assert.assertEquals(res, z.minus(1.5));
    }

    @Test
    public void testSubtractTwoComplexNumbers() {
        var z = new Complex(2.0, 1.0);
        var w = new Complex(1.5, 2.0);
        var res = new Complex(0.5, -1.0);
        Assert.assertEquals(res, z.minus(w));
    }

    @Test
    public void testMultiplyComplexByReal() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(3.0, 1.5);
        Assert.assertEquals(res, z.multiply(1.5));
    }

    @Test
    public void testMultiplyComplexByTwoValues() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(1.0, 5.5);
        Assert.assertEquals(res, z.multiply(1.5, 2.0));
    }

    @Test
    public void testMultiplyTwoComplexNumbers() {
        var z = new Complex(2.0, 1.0);
        var w = new Complex(1.5, 2.0);
        var res = new Complex(1.0, 5.5);
        Assert.assertEquals(res, z.multiply(w));
    }

    @Test
    public void testDivideComplexByReal() {
        var z = new Complex(2.0, 1.0);
        var res = new Complex(1.0, 0.5);
        Assert.assertEquals(res, z.divide(2.0));
    }

    @Test
    public void testDivideComplexByTwoValues() {
        var z = new Complex(3.0, 2.0);
        var res = new Complex(1.25, -0.25);
        Assert.assertEquals(res, z.divide(2.0, 2.0));
    }

    @Test
    public void testDivideTwoComplexNumbers() {
        var z = new Complex(2.0, 2.0);
        var w = new Complex(3.0, 2.0);
        var res = new Complex(1.25, -0.25);
        Assert.assertEquals(res, w.divide(z));
    }

    @Test
    public void testEqualsApproxTwoValues() {
        var z = new Complex(3.00000001, 1.99999999);
        Assert.assertTrue(z.equalsApprox(3.0, 2.0));
    }

    @Test
    public void testComplexEqualsApprox() {
        var z = new Complex(3.00000001, 1.99999999);
        var w = new Complex(3.0, 2.0);
        Assert.assertTrue(z.equalsApprox(w));
    }
}
