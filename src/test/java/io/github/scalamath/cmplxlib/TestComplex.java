package io.github.scalamath.cmplxlib;

import org.junit.Assert;
import org.junit.Test;

public class TestComplex {

    @Test
    public void testComplexPlusTwoValues() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.plus(1.5, 2.0);
        Assert.assertEquals(new Complex(3.5, 3.0), res);
    }

    @Test
    public void testComplexPlusReal() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.plus(1.5);
        Assert.assertEquals(new Complex(3.5, 1.0), res);
    }

    @Test
    public void testComplexSum() {
        Complex z = new Complex(2.0, 1.0);
        Complex w = new Complex(1.5, 2.0);
        Assert.assertEquals(new Complex(3.5, 3.0), z.plus(w));
    }

    @Test
    public void testNegated() {
        Complex z = new Complex(2.0, 1.0);
        Assert.assertEquals(new Complex(-2.0, -1.0), z.negated());
    }

    @Test
    public void testComplexMinusTwoValues() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.minus(1.5, 2.0);
        Assert.assertEquals(new Complex(0.5, -1.0), res);
    }

    @Test
    public void testComplexMinusReal() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.minus(1.5);
        Assert.assertEquals(new Complex(0.5, 1.0), res);
    }

    @Test
    public void testComplexSubtraction() {
        Complex z = new Complex(2.0, 1.0);
        Complex w = new Complex(1.5, 2.0);
        Assert.assertEquals(new Complex(0.5, -1.0), z.minus(w));
    }

    @Test
    public void testComplexTimesReal() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.multiply(1.5);
        Assert.assertEquals(new Complex(3.0, 1.5), res);
    }

    @Test
    public void testComplexTimesTwoValues() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.multiply(1.5, 2.0);
        Assert.assertEquals(new Complex(1.0, 5.5), res);
    }

    @Test
    public void testComplexProduct() {
        Complex z = new Complex(2.0, 1.0);
        Complex w = new Complex(1.5, 2.0);
        Assert.assertEquals(new Complex(1.0, 5.5), z.multiply(w));
    }

    @Test
    public void testComplexDividedByReal() {
        Complex z = new Complex(2.0, 1.0);
        Complex res = z.divide(2.0);
        Assert.assertEquals(new Complex(1.0, 0.5), res);
    }

    @Test
    public void testComplexDivision() {
        Complex z = new Complex(3.0, 2.0);
        Complex w = new Complex(2.0, 2.0);
        Assert.assertEquals(new Complex(1.25, -0.25), z.divide(w));
    }

    @Test
    public void testComplexDividedByTwoValues() {
        Complex z = new Complex(3.0, 2.0);
        Complex res = z.divide(2.0, 2.0);
        Assert.assertEquals(new Complex(1.25, -0.25), res);
    }
}
