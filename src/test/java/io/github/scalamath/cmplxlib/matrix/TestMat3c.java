package io.github.scalamath.cmplxlib.matrix;

public class TestMat3c {

//    @Test
//    public void testMatrixSum() {
//        Mat3c a = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Mat3c b = new Mat3c(
//            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
//            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0),
//            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(3.0, 4.5), new Complex(4.5, 1.5), new Complex(3.0, 3.0),
//            new Complex(1.5, 3.0), new Complex(7.0, 5.5), new Complex(2.5, 4.0),
//            new Complex(5.0, 3.5), new Complex(1.0, 2.0), new Complex(4.0, 2.5)
//        ), a.plus(b));
//    }
//
//    @Test
//    public void testNegated() {
//        Mat3c m = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(-1.0, -2.0), new Complex(-1.5, -1.0), new Complex(-2.0, -1.0),
//            new Complex(-0.5, -1.5), new Complex(-3.0, -2.0), new Complex(-1.0, -2.0),
//            new Complex(-2.0, -3.0), new Complex(-0.0, -1.0), new Complex(-1.5, -2.5)
//        ), m.negated());
//    }
//
//    @Test
//    public void testMatrixSubtraction() {
//        Mat3c a = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Mat3c b = new Mat3c(
//            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
//            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0),
//            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(-1.0, -0.5), new Complex(-1.5, 0.5), new Complex(1.0, -1.0),
//            new Complex(-0.5, 0.0), new Complex(-1.0, -1.5), new Complex(-0.5, 0.0),
//            new Complex(-1.0, 2.5), new Complex(-1.0, 0.0), new Complex(-1.0, 2.5)
//        ), a.minus(b));
//    }
//
//    @Test
//    public void testMultiplyReal() {
//        Mat3c m = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(1.5, 3.0), new Complex(2.25, 1.5), new Complex(3.0, 1.5),
//            new Complex(0.75, 2.25), new Complex(4.5, 3.0), new Complex(1.5, 3.0),
//            new Complex(3.0, 4.5), new Complex(0.0, 1.5), new Complex(2.25, 3.75)
//        ), m.multiply(1.5));
//    }
//
//    @Test
//    public void testMultiplyComplex() {
//        Mat3c m = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(-0.5, 4.0), new Complex(1.25, 3.0), new Complex(2.0, 3.5),
//            new Complex(-0.75, 2.75), new Complex(2.5, 6.0), new Complex(-0.5, 4.0),
//            new Complex(0.0, 6.5), new Complex(-1.0, 1.5), new Complex(-0.25, 5.25)
//        ), m.multiply(new Complex(1.5, 1.0)));
//    }
//
//    @Test
//    public void testMatrixVectorProduct() {
//        Mat3c m = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Vec3c v = new Vec3c(new Complex(1.0, 1.0), new Complex(2.0, 3.0), new Complex(1.0, -1.0));
//        Assert.assertEquals(new Vec3c(new Complex(2.0, 8.5), new Complex(2.0, 16.0), new Complex(0.0, 8.0)), m.multiply(v));
//    }
//
//    @Test
//    public void testMatrixVectorProductByValues() {
//        Mat3c m = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Assert.assertEquals(new Vec3c(new Complex(2.0, 8.5), new Complex(2.0, 16.0), new Complex(0.0, 8.0)), m.multiply(new Complex(1.0, 1.0), new Complex(2.0, 3.0), new Complex(1.0, -1.0)));
//    }
//
//    @Test
//    public void testMatrixProduct() {
//        Mat3c a = new Mat3c(
//            new Complex(1.0, 2.0), new Complex(1.5, 1.0), new Complex(2.0, 1.0),
//            new Complex(0.5, 1.5), new Complex(3.0, 2.0), new Complex(1.0, 2.0),
//            new Complex(2.0, 3.0), new Complex(0.0, 1.0), new Complex(1.5, 2.5)
//        );
//        Mat3c b = new Mat3c(
//            new Complex(2.0, 2.5), new Complex(3.0, 0.5), new Complex(1.0, 2.0),
//            new Complex(1.0, 1.5), new Complex(4.0, 3.5), new Complex(1.5, 2.0),
//            new Complex(3.0, 0.5), new Complex(1.0, 1.0), new Complex(2.5, 0.0)
//        );
//        Assert.assertEquals(new Mat3c(
//            new Complex(2.5, 13.75), new Complex(5.5, 18.75), new Complex(2.25, 11.0),
//            new Complex(-0.75, 17.25), new Complex(4.75, 26.25), new Complex(0.5, 16.5),
//            new Complex(-1.75, 20.25), new Complex(0.0, 18.0), new Complex(-2.25, 14.75)
//        ), a.multiply(b));
//    }
}
