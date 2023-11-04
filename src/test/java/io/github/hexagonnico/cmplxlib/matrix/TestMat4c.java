package io.github.hexagonnico.cmplxlib.matrix;

import io.github.hexagonnico.cmplxlib.Complex;
import io.github.hexagonnico.cmplxlib.vector.Vec4c;
import org.junit.Assert;
import org.junit.Test;

public class TestMat4c {

    @Test
    public void testMatrixSum() {
        Mat4c a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Mat4c b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(3.0, 3.0), new Complex(4.5, 1.0),
            new Complex(1.5, 3.0), new Complex(7.0, 5.5), new Complex(2.5, 4.0), new Complex(4.0, 1.5),
            new Complex(5.0, 3.5), new Complex(1.0, 2.0), new Complex(4.0, 2.5), new Complex(3.0, 1.5),
            new Complex(7.0, 4.5), new Complex(4.0, 5.0), new Complex(5.5, 3.0), new Complex(1.0, 5.0)
        ), a.plus(b));
    }

    @Test
    public void testNegated() {
        Mat4c m = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(-1.0, -2.0), new Complex(-1.5, -1.0), new Complex(-2.0, -1.0), new Complex(-3.0, -0.0),
            new Complex(-0.5, -1.5), new Complex(-3.0, -2.0), new Complex(-1.0, -2.0), new Complex(-2.0, -1.0),
            new Complex(-2.0, -3.0), new Complex(-0.0, -1.0), new Complex(-1.5, -2.5), new Complex(-1.0, -0.0),
            new Complex(-3.0, -1.0), new Complex(-2.0, -3.0), new Complex(-2.5, -1.5), new Complex(-0.0, -2.0)
        ), m.negated());
    }

    @Test
    public void testMatrixSubtraction() {
        Mat4c a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Mat4c b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(1.0, -1.0), new Complex(1.5, -1.0),
            new Complex(-0.5, 0.0), new Complex(-1.0, -1.5), new Complex(-0.5, 0.0), new Complex(0.0, 0.5),
            new Complex(-1.0, 2.5), new Complex(-1.0, 0.0), new Complex(-1.0, 2.5), new Complex(-1.0, -1.5),
            new Complex(-1.0, -2.5), new Complex(0.0, 1.0), new Complex(-0.5, 0.0), new Complex(-1.0, -1.0)
        ), a.minus(b));
    }

    @Test
    public void testMultiplyReal() {
        Mat4c m = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(1.5, 3.0), new Complex(2.25, 1.5), new Complex(3.0, 1.5), new Complex(4.5, 0.0),
            new Complex(0.75, 2.25), new Complex(4.5, 3.0), new Complex(1.5, 3.0), new Complex(3.0, 1.5),
            new Complex(3.0, 4.5), new Complex(0.0, 1.5), new Complex(2.25, 3.75), new Complex(1.5, 0.0),
            new Complex(4.5, 1.5), new Complex(3.0, 4.5), new Complex(3.75, 2.25), new Complex(0.0, 3.0)
        ), m.multiply(1.5));
    }

    @Test
    public void testMultiplyComplex() {
        Mat4c m = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(-0.5, 4.0), new Complex(1.25, 3.0), new Complex(2.0, 3.5), new Complex(4.5, 3.0),
            new Complex(-0.75, 2.75), new Complex(2.5, 6.0), new Complex(-0.5, 4.0), new Complex(2.0, 3.5),
            new Complex(0.0, 6.5), new Complex(-1.0, 1.5), new Complex(-0.25, 5.25), new Complex(1.5, 1.0),
            new Complex(3.5, 4.5), new Complex(0.0, 6.5), new Complex(2.25, 4.75), new Complex(-2.0, 3.0)
        ), m.multiply(new Complex(1.5, 1.0)));
    }

    @Test
    public void testMatrixVectorProduct() {
        Mat4c m = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Vec4c v = new Vec4c(new Complex(1.0, 1.0), new Complex(2.0, 3.0), new Complex(1.0, -1.0), new Complex(1.0, 0.0));
        Assert.assertEquals(new Vec4c(new Complex(5.0, 8.5), new Complex(4.0, 17.0), new Complex(1.0, 8.0), new Complex(1.0, 17.0)), m.multiply(v));
    }

    @Test
    public void testMatrixVectorProductByValues() {
        Mat4c m = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Assert.assertEquals(new Vec4c(new Complex(5.0, 8.5), new Complex(4.0, 17.0), new Complex(1.0, 8.0), new Complex(1.0, 17.0)), m.multiply(new Complex(1.0, 1.0), new Complex(2.0, 3.0), new Complex(1.0, -1.0), new Complex(1.0, 0.0)));
    }

    @Test
    public void testMatrixProduct() {
        Mat4c a = new Mat4c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0), new Complex(3.0, 0.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0), new Complex(2.0, 1.0),
            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5), new Complex(1.0, 0.0),
            new Complex(3.0, 1.0), new Complex(2.0, 3.0), new Complex(2.5, 1.5), new Complex(0.0, 2.0)
        );
        Mat4c b = new Mat4c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0), new Complex(2.0, 0.5),
            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0), new Complex(2.0, 1.5),
            new Complex(4.0, 3.5), new Complex(2.0, 2.0), new Complex(3.0, 1.5), new Complex(1.0, 3.0)
        );
        Assert.assertEquals(new Mat4c(
            new Complex(14.5, 24.25), new Complex(11.5, 24.75), new Complex(11.25, 15.5), new Complex(7.5, 20.75),
            new Complex(3.75, 28.25), new Complex(6.75, 32.25), new Complex(5.0, 22.5), new Complex(2.25, 20.75),
            new Complex(2.25, 23.75), new Complex(2.0, 20.0), new Complex(0.75, 16.25), new Complex(-0.25, 18.75),
            new Complex(0.75, 29.25), new Complex(3.0, 31.5), new Complex(1.25, 25.25), new Complex(2.75, 20.25)
        ), a.multiply(b));
    }
}
