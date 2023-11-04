package io.github.hexagonnico.cmplxlib.matrix;

import io.github.hexagonnico.cmplxlib.Complex;
import io.github.hexagonnico.cmplxlib.vector.Vec2c;
import org.junit.Assert;
import org.junit.Test;

public class TestMat2c {

    @Test
    public void testMatrixSum() {
        Mat2c a = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Mat2c b = new Mat2c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(3.0, 4.5), new Complex(4.5, 1.5),
            new Complex(1.5, 3.0), new Complex(7.0, 5.5)
        ), a.plus(b));
    }

    @Test
    public void testNegated() {
        Mat2c m = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(-1.0, -2.0), new Complex(-1.5, -1.0),
            new Complex(-0.5, -1.5), new Complex(-3.0, -2.0)
        ), m.negated());
    }

    @Test
    public void testMatrixSubtraction() {
        Mat2c a = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Mat2c b = new Mat2c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(-1.0, -0.5), new Complex(-1.5, 0.5),
            new Complex(-0.5, 0.0), new Complex(-1.0, -1.5)
        ), a.minus(b));
    }

    @Test
    public void testMultiplyReal() {
        Mat2c m = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(1.5, 3.0), new Complex(2.25, 1.5),
            new Complex(0.75, 2.25), new Complex(4.5, 3.0)
        ), m.multiply(1.5));
    }

    @Test
    public void testMultiplyComplex() {
        Mat2c m = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(-0.5, 4.0), new Complex(1.25, 3.0),
            new Complex(-0.75, 2.75), new Complex(2.5, 6.0)
        ), m.multiply(new Complex(1.5, 1.0)));
    }

    @Test
    public void testMatrixVectorProduct() {
        Mat2c m = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Vec2c v = new Vec2c(new Complex(1.0, 1.0), new Complex(2.0, 3.0));
        Assert.assertEquals(new Vec2c(new Complex(-1.0, 9.5), new Complex(-1.0, 15.0)), m.multiply(v));
    }

    @Test
    public void testMatrixVectorProductByValues() {
        Mat2c m = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Assert.assertEquals(new Vec2c(new Complex(-1.0, 9.5), new Complex(-1.0, 15.0)), m.multiply(new Complex(1.0, 1.0), new Complex(2.0, 3.0)));
    }

    @Test
    public void testMatrixProduct() {
        Mat2c a = new Mat2c(
            new Complex(1.0, 2.0), new Complex(1.5, 1.0),
            new Complex(0.5, 1.5), new Complex(3.0, 2.0)
        );
        Mat2c b = new Mat2c(
            new Complex(2.0, 2.5), new Complex(3.0, 0.5),
            new Complex(1.0, 1.5), new Complex(4.0, 3.5)
        );
        Assert.assertEquals(new Mat2c(
            new Complex(-3.0, 9.75), new Complex(4.5, 15.75),
            new Complex(-2.75, 10.75), new Complex(5.75, 23.25)
        ), a.multiply(b));
    }
}
