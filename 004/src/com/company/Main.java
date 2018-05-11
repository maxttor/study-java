package com.company;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;

public class Main {

    public static void main(String[] args) {
//        System.out.println((int) integrate(x -> 1, 0, 10));
        AsciiCharSequence obj = new AsciiCharSequence(new byte[] {65, 66, 67});
        System.out.println(obj.toString());
        System.out.println(obj.length());
        System.out.println(obj.charAt(1));
        System.out.println(obj.subSequence(0, 2).toString());
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;
        for (double i = a; i < b; i += 1e-7) {
            result += f.applyAsDouble(i) * 1e-7;
        }
        return result;
    }

    public static class AsciiCharSequence implements CharSequence {
        private byte[] chars;

        public AsciiCharSequence(byte[] chars) {
            this.chars = chars;
        }

        @Override
        public int length() {
            return chars.length;
        }

        @Override
        public char charAt(int index) {
            return (char) chars[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            byte[] subChars = Arrays.copyOfRange(chars, start, end);
            return new AsciiCharSequence(subChars);
        }
        // implementation


        @Override
        public String toString() {
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < this.length(); i++) {
//                builder.append((char) chars[i]);
//            }
//            return builder.toString();
            return new String(chars);
        }
    }
}
