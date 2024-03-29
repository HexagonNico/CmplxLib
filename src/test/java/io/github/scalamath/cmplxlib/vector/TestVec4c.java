package io.github.scalamath.cmplxlib.vector;

public class TestVec4c {

//    @Test
//    public void testVectorPlusValues() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.plus(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(1.5, 3.0), new Complex(7.0, 5.5)), res);
//    }
//
//    @Test
//    public void testVectorSum() {
//        Vec4c a = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c b = new Vec4c(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(1.5, 3.0), new Complex(7.0, 5.5)), a.plus(b));
//    }
//
//    @Test
//    public void testNegated() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Assert.assertEquals(new Vec4c(new Complex(-1.0, -2.0), new Complex(-1.5, -1.0), new Complex(-0.5, -1.5), new Complex(-3.0, -2.0)), vec.negated());
//    }
//
//    @Test
//    public void testVectorMinusValues() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.minus(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(-0.5, 0.0), new Complex(-1.0, -1.5)), res);
//    }
//
//    @Test
//    public void testVectorSubtraction() {
//        Vec4c a = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c b = new Vec4c(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(-0.5, 0.0), new Complex(-1.0, -1.5)), a.minus(b));
//    }
//
//    @Test
//    public void testMultiplyByReal() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.multiply(1.5);
//        Assert.assertEquals(new Vec4c(new Complex(1.5, 3.0), new Complex(2.25, 1.5), new Complex(0.75, 2.25), new Complex(4.5, 3.0)), res);
//    }
//
//    @Test
//    public void testMultiplyByComplex() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(1.0, 1.0), new Complex(3.0, 2.0));
//        Vec4c res = vec.multiply(new Complex(1.5, 1.0));
//        Assert.assertEquals(new Vec4c(new Complex(-0.5, 4.0), new Complex(1.25, 3.0), new Complex(0.5, 2.5), new Complex(2.5, 6.0)), res);
//    }
//
//    @Test
//    public void testDividedByReal() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.divide(2.0);
//        Assert.assertEquals(new Vec4c(new Complex(0.5, 1.0), new Complex(0.75, 0.5), new Complex(0.25, 0.75), new Complex(1.5, 1.0)), res);
//    }
//
//    @Test
//    public void testDividedByComplex() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.divide(new Complex(1.0, 1.0));
//        Assert.assertEquals(new Vec4c(new Complex(3.0 / 2.0, 0.5), new Complex(1.25, -0.25), new Complex(1.0, 0.5), new Complex(2.5, -0.5)), res);
//    }
//
//    @Test
//    public void testComponentWiseMultiplicationValues() {
//        Vec4c vec = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c res = vec.multiply(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75), new Complex(-1.75, 2.25), new Complex(5.0, 18.5)), res);
//    }
//
//    @Test
//    public void testComponentWiseMultiplication() {
//        Vec4c a = new Vec4c(new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(0.5, 1.5), new Complex(3.0, 2.0));
//        Vec4c b = new Vec4c(new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 1.5), new Complex(4.0, 3.5));
//        Assert.assertEquals(new Vec4c(new Complex(-3.0, 6.5), new Complex(4.0, 3.75), new Complex(-1.75, 2.25), new Complex(5.0, 18.5)), a.multiply(b));
//    }
//
//    @Test
//    public void testComponentWiseDivision() {
//        Vec4c a = new Vec4c(new Complex(8.0, 6.0), new Complex(6.0, 8.0), new Complex(1.0, 2.0), new Complex(2.0, 0.0));
//        Vec4c b = new Vec4c(new Complex(2.0, 2.0), new Complex(4.0, 2.0), new Complex(2.0, 4.0), new Complex(2.0, 2.0));
//        Assert.assertEquals(new Vec4c(new Complex(3.5, -0.5), new Complex(2.0, 1.0), new Complex(0.5, 0.0), new Complex(0.5, -0.5)), a.divide(b));
//    }
//
//    @Test
//    public void testComponentWiseDivisionValues() {
//        Vec4c vec = new Vec4c(new Complex(8.0, 6.0), new Complex(6.0, 8.0), new Complex(1.0, 2.0), new Complex(2.0, 0.0));
//        Vec4c res = vec.divide(new Complex(2.0, 2.0), new Complex(4.0, 2.0), new Complex(2.0, 4.0), new Complex(2.0, 2.0));
//        Assert.assertEquals(new Vec4c(new Complex(3.5, -0.5), new Complex(2.0, 1.0), new Complex(0.5, 0.0), new Complex(0.5, -0.5)), res);
//    }
}
