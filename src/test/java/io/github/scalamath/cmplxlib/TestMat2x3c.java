package io.github.scalamath.cmplxlib;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestMat2x3c {
    
    @Test
    public void testSumOfMatrices() {
        var a = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var b = new Mat2x3c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0)
        );
        var res = new Mat2x3c(
            new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(3.0, 3.0),
            new Complex(1.5, 3.0), new Complex(7.0, 5.5), new Complex(2.5, 4.0)
        );
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testSubtractionOfMatrices() {
        var a = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var b = new Mat2x3c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0)
        );
        var res = new Mat2x3c(
            new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(1.0, -1.0),
            new Complex(-0.5, 0.0), new Complex(-1.0, -1.5), new Complex(-0.5, 0.0)
        );
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var res = new Mat2x3c(
            new Complex(-1.0, -2.0), new Complex(-1.5, -1.0), new Complex(-2.0, -1.0),
            new Complex(-0.5, -1.5), new Complex(-3.0, -2.0), new Complex(-1.0, -2.0)
        );
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByComplex() {
        var mat = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var z = new Complex(1.5, 1.0);
        var res = new Mat2x3c(
            new Complex(-0.5, 4.0), new Complex(1.25, 3.0), new Complex(2.0, 3.5),
            new Complex(-0.75, 2.75), new Complex(2.5, 6.0), new Complex(-0.5, 4.0)
        );
        Assert.assertEquals(res, mat.multipliedBy(z));
    }

    @Test
    public void testMatrixMultipliedByReal() {
        var mat = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var res = new Mat2x3c(
            new Complex(1.5, 3.0), new Complex(2.25, 1.5), new Complex(3.0, 1.5),
            new Complex(0.75, 2.25), new Complex(4.5, 3.0), new Complex(1.5, 3.0)
        );
        Assert.assertEquals(res, mat.multipliedBy(1.5));
    }

    @Test
    @Ignore
    public void testMatrixDividedByComplex() {
        // TODO
    }

    @Test
    @Ignore
    public void testMatrixDividedByReal() {
        // TODO
    }

    @Test
    @Ignore
    public void testMatrixVectorProduct() {
        // TODO
    }

    @Test
    @Ignore
    public void testMatrixVectorProductByValues() {
        // TODO
    }

    @Test
    public void testProductWithA3x3Matrix() {
        var a = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var b = new Mat3c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0)
        );
        var res = new Mat2x3c(
            new Complex(2.5, 13.75), new Complex(5.5, 18.75), new Complex(2.25, 11.0),
            new Complex(-0.75, 17.25), new Complex(4.75, 26.25), new Complex(0.5, 16.5)
        );
        Assert.assertEquals(res, a.multiply(b));
    }
    
    @Test
    @Ignore
    public void testProductWithA3x4Matrix() {
        // TODO
    }
    
    @Test
    public void testEqualsApprox() {
        var a = new Mat2x3c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0)
        );
        var b = new Mat2x3c(
            new Complex(1.00000001, 2.0), new Complex(1.5, 1.0), new Complex(2.00000001, 1.0),
            new Complex(0.5, 1.49999999), new Complex(2.99999999, 2.0), new Complex(1.0, 2.0)
        );
        Assert.assertTrue(a.equalsApprox(b));
    }
}
