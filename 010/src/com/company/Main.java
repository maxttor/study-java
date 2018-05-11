package com.company;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int prev = 0, next = 0;
        System.setIn(new ByteArrayInputStream(new byte[] {1, 2, 3, 13, 10, 4, 5, 6}));
        prev = System.in.read();
        while (prev != -1) {
            next = System.in.read();
            if (prev != 13 || next != 10) {
                System.out.println(prev);
            }
            prev = next;
        }
        System.out.flush();
    }
}
