package com.company;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        System.out.println(sqrt(4));
//        System.out.println(getCallerClassAndMethodName());
//        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] calls;
        try {
            throw new RuntimeException();
        } catch (RuntimeException error) {
            calls = Arrays.copyOfRange(error.getStackTrace(), 2, error.getStackTrace().length);
        }
        if (calls.length == 0) {
            return null;
        }
        StackTraceElement call = calls[0];

        return call.getClassName()+"#"+call.getMethodName();
    }
}