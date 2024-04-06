package io.github.scalamath.cmplxlib;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestMat4c {
    
    @Test
    public void testSumOfMatrices() {
        var a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        var res = new Mat4c(
            new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(3.0, 3.0), new Complex(4.5, 1.0),
            new Complex(1.5, 3.0), new Complex(7.0, 5.5), new Complex(2.5, 4.0), new Complex(4.0, 1.5),
            new Complex(5.0, 3.5), new Complex(1.0, 2.0), new Complex(4.0, 2.5), new Complex(3.0, 1.5),
            new Complex(7.0, 4.5), new Complex(4.0, 5.0), new Complex(5.5, 3.0), new Complex(1.0, 5.0)
        );
        Assert.assertEquals(res, a.plus(b));
    }

    @Test
    public void testSubtractionOfMatrices() {
        var a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        var res = new Mat4c(
            new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(1.0, -1.0), new Complex(1.5, -1.0),
            new Complex(-0.5, 0.0), new Complex(-1.0, -1.5), new Complex(-0.5, 0.0), new Complex(0.0, 0.5),
            new Complex(-1.0, 2.5), new Complex(-1.0, 0.0), new Complex(-1.0, 2.5), new Complex(-1.0, -1.5),
            new Complex(-1.0, -2.5), new Complex(0.0, 1.0), new Complex(-0.5, 0.0), new Complex(-1.0, -1.0)
        );
        Assert.assertEquals(res, a.minus(b));
    }

    @Test
    public void testNegatedMatrix() {
        var mat = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var res = new Mat4c(
            new Complex(-1.0, -2.0), new Complex(-1.5, -1.0), new Complex(-2.0, -1.0), new Complex(-3.0, 0.0),
            new Complex(-0.5, -1.5), new Complex(-3.0, -2.0), new Complex(-1.0, -2.0), new Complex(-2.0, -1.0),
            new Complex(-2.0, -3.0), new Complex(0.0, -1.0), new Complex(-1.5, -2.5), new Complex(-1.0, 0.0),
            new Complex(-3.0, -1.0), new Complex(-2.0, -3.0), new Complex(-2.5, -1.5), new Complex(0.0, -2.0)
        );
        Assert.assertEquals(res, mat.negated());
    }

    @Test
    public void testMatrixMultipliedByComplex() {
        var mat = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var z = new Complex(1.5, 1.0);
        var res = new Mat4c(
            new Complex(-0.5, 4.0), new Complex(1.25, 3.0), new Complex(2.0, 3.5), new Complex(4.5, 3.0),
            new Complex(-0.75, 2.75), new Complex(2.5, 6.0), new Complex(-0.5, 4.0), new Complex(2.0, 3.5),
            new Complex(0.0, 6.5), new Complex(-1.0, 1.5), new Complex(-0.25, 5.25), new Complex(1.5, 1.0),
            new Complex(3.5, 4.5), new Complex(0.0, 6.5), new Complex(2.25, 4.75), new Complex(-2.0, 3.0)
        );
        Assert.assertEquals(res, mat.multipliedBy(z));
    }

    @Test
    public void testMatrixMultipliedByReal() {
        var mat = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var res = new Mat4c(
            new Complex(1.5, 3.0), new Complex(2.25, 1.5), new Complex(3.0, 1.5), new Complex(4.5, 0.0),
            new Complex(0.75, 2.25), new Complex(4.5, 3.0), new Complex(1.5, 3.0), new Complex(3.0, 1.5),
            new Complex(3.0, 4.5), new Complex(0.0, 1.5), new Complex(2.25, 3.75), new Complex(1.5, 0.0),
            new Complex(4.5, 1.5), new Complex(3.0, 4.5), new Complex(3.75, 2.25), new Complex(0.0, 3.0)
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
    public void testMatrixVectorProduct() {
        var mat = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var vec = new Vec4c(new Complex(1.0, 1.0), new Complex(2.0, 3.0), new Complex(1.0, -1.0), new Complex(1.0, 0.0));
        var res = new Vec4c(new Complex(5.0, 8.5), new Complex(4.0, 17.0), new Complex(1.0, 8.0), new Complex(1.0, 17.0));
        Assert.assertEquals(res, mat.multiply(vec));
    }
    
    @Test
    public void testMatrixVectorProductByValues() {
        var mat = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Complex x = new Complex(1.0, 1.0);
        Complex y = new Complex(2.0, 3.0);
        Complex z = new Complex(1.0, -1.0);
        Complex w = new Complex(1.0, 0.0);
        var res = new Vec4c(new Complex(5.0, 8.5), new Complex(4.0, 17.0), new Complex(1.0, 8.0), new Complex(1.0, 17.0));
        Assert.assertEquals(res, mat.multiply(x, y, z, w));
    }
    
    @Test
    public void testProductWithA4x4Matrix() {
        var a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        var res = new Mat4c(
            new Complex(14.5, 24.25), new Complex(11.5, 24.75), new Complex(11.25, 15.5), new Complex(7.5, 20.75),
            new Complex(3.75, 28.25), new Complex(6.75, 32.25), new Complex(5.0, 22.5), new Complex(2.25, 20.75),
            new Complex(2.25, 23.75), new Complex(2.0, 20.0), new Complex(0.75, 16.25), new Complex(-0.25, 18.75),
            new Complex(0.75, 29.25), new Complex(3.0, 31.5), new Complex(1.25, 25.25), new Complex(2.75, 20.25)
        );
        Assert.assertEquals(res, a.multiply(b));
    }
    
    @Test
    public void testEqualsApprox() {
        var a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        var b = new Mat4c(
            new Complex(1.00000001, 2.0), new Complex(1.5, 1.0), new Complex(2.00000001, 1.0), new Complex(2.99999999, 0.0),
            new Complex(0.5, 1.49999999), new Complex(2.99999999, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 2.99999999), new Complex(0.0, 1.0), new Complex(1.5, 2.49999999), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.49999999, 1.5), new Complex(0.0, 1.99999999)
        );
        Assert.assertTrue(a.equalsApprox(b));
    }
}
