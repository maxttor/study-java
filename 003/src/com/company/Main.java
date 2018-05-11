package com.company;

public class Main {

    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1.1, 1.1);
        ComplexNumber b = new ComplexNumber(1.1, 1.1);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

    public static final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj) {
            return obj == this ||
                    (obj instanceof ComplexNumber)
                    && re == ((ComplexNumber) obj).re
                    && im == ((ComplexNumber) obj).im;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(re) + Double.hashCode(im);
        }
    }
}
