package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        double result = 0;
        while (scaner.hasNext()) {
            try {
                result += Double.parseDouble(scaner.next());
            } catch (NumberFormatException e) {}
        }
        System.out.printf("%.6f", result);
    }
}
