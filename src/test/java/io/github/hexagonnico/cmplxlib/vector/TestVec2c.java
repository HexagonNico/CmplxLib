package io.github.hexagonnico.cmplxlib.vector;

import io.github.hexagonnico.cmplxlib.Complex;
import org.junit.Assert;
import org.junit.Test;

public class TestVec2c {

    @Test
    public void testVectorPlusValues() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.plus(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(3.0, 4.5), new Complex(4.5, 1.5)), res);
    }

    @Test
    public void testVectorSum() {
        Vec2c a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(3.0, 4.5), new Complex(4.5, 1.5)), a.plus(b));
    }

    @Test
    public void testNegated() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Assert.assertEquals(new Vec2c(new Complex(-1.0, -2.0), new Complex(-1.5, -1.0)), vec.negated());
    }

    @Test
    public void testVectorMinusValues() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.minus(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5)), res);
    }

    @Test
    public void testVectorSubtraction() {
        Vec2c a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5)), a.minus(b));
    }

    @Test
    public void testMultiplyByReal() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.multiply(1.5);
        Assert.assertEquals(new Vec2c(new Complex(1.5, 3.0), new Complex(2.25, 1.5)), res);
    }

    @Test
    public void testMultiplyByComplex() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.multiply(new Complex(1.5, 1.0));
        Assert.assertEquals(new Vec2c(new Complex(-0.5, 4.0), new Complex(1.25, 3.0)), res);
    }

    @Test
    public void testDividedByReal() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.divide(2.0);
        Assert.assertEquals(new Vec2c(new Complex(0.5, 1.0), new Complex(0.75, 0.5)), res);
    }

    @Test
    public void testDividedByComplex() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.divide(new Complex(1.0, 1.0));
        Assert.assertEquals(new Vec2c(new Complex(3.0 / 2.0, 0.5), new Complex(1.25, -0.25)), res);
    }

    @Test
    public void testComponentWiseMultiplicationValues() {
        Vec2c vec = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c res = vec.multiply(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75)), res);
    }

    @Test
    public void testComponentWiseMultiplication() {
        Vec2c a = new Vec2c(new Complex(1.0, 2.0), new Complex(1.5, 1.0));
        Vec2c b = new Vec2c(new Complex(2.0, 2.5), new Complex(3.0, 0.5));
        Assert.assertEquals(new Vec2c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75)), a.multiply(b));
    }

    @Test
    public void testComponentWiseDivision() {
        Vec2c a = new Vec2c(new Complex(8.0, 6.0), new Complex(6.0, 8.0));
        Vec2c b = new Vec2c(new Complex(2.0, 2.0), new Complex(4.0, 2.0));
        Assert.assertEquals(new Vec2c(new Complex(3.5, -0.5), new Complex(2.0, 1.0)), a.divide(b));
    }

    @Test
    public void testComponentWiseDivisionValues() {
        Vec2c vec = new Vec2c(new Complex(8.0, 6.0), new Complex(6.0, 8.0));
        Vec2c res = vec.divide(new Complex(2.0, 2.0), new Complex(4.0, 2.0));
        Assert.assertEquals(new Vec2c(new Complex(3.5, -0.5), new Complex(2.0, 1.0)), res);
    }
}
