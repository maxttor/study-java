package com.company;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.SocketOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"
        };

        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < roles.length; i++) {
            builder.append(roles[i]+":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i]+":")) {
                    builder.append((j + 1) + ") " + textLines[j].substring(roles[i].length() + 2) + "\n");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        for (int i = 0, j = 0, k = 0; i < result.length; i++) {
            if (a1.length > j && a2.length > k) {
                if (a1[j] < a2[k]) {
                    result[i] = a1[j];
                    j++;
                } else {
                    result[i] = a2[k];
                    k++;
                }
            } else {
                if (a1.length > j) {
                    result[i] = a1[j];
                    j++;
                } else {
                    result[i] = a2[k];
                    k++;
                }
            }
        }
        return result;
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverseText = new StringBuilder(text).reverse().toString();
        return text.equals(reverseText); // your implementation here
    }

    public static boolean isPowerOfTwo(int value) {
        for (int i = 0; i < 32; i++) {
            if (Math.pow(2, i) == Math.abs(value)) {
                return true;
            }
        }
        return false;
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ 1 << --bitIndex;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) <= 0.0001;
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        int count = 0;
        if (a) {
            count++;
        }
        if (b) {
            count++;
        }
        if (c) {
            count++;
        }
        if (d) {
            count++;
        }

        return count == 2;
    }

    public static int leapYearCount(int year) {
        return year/4 + year/400 - year/100;
    }

    private static void configureLogging() {
        Logger.getLogger("org.stepic.java.logging.ClassA").setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java.logging.ClassB").setLevel(Level.WARNING);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new XMLFormatter());
        handler.setLevel(Level.ALL);
        Logger.getLogger("org.stepic.java").addHandler(handler);
        Logger.getLogger("org.stepic.java").setUseParentHandlers(false);
    }
}
