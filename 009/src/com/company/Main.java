package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})));
        InputStream inputStream = new ByteArrayInputStream(new byte[] {48, 49, 50, 51});
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        String result = "";
        int chr = 0;
        while ((chr = reader.read()) != -1) {
            result += (char) chr;
        }

        return result;
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checkSum = 0, read = 0;
        while ((read = inputStream.read()) != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ read;
        }

        return checkSum;
    }

    public static void printCharBytes() {
        for (byte b : "Ы".getBytes(StandardCharsets.UTF_8)){
            System.out.printf("%d ", Byte.toUnsignedInt(b));
        }
    }

    public static void printNotASCIIChar() throws IOException {
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write('Ы');
        writer.flush();
    }
}
