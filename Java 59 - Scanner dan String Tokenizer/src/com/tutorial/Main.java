package com.tutorial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader fileInput = new FileReader("input.txt");
        BufferedReader buferedReader = new BufferedReader(fileInput);

        Scanner scanner = new Scanner(buferedReader);

        // ini untuk cek ada kata selanjutnya atau tidak
        System.out.println(scanner.hasNext()); // true

        // untuk membaca kata, dengan pemisah/delimiter spasi
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());

        System.out.println(scanner.hasNext()); // false

        // Menggunakan delimiter tertentu
        FileReader fileInput2 = new FileReader("input2.txt");
        buferedReader = new BufferedReader(fileInput2);
        buferedReader.mark(200);

        scanner = new Scanner(buferedReader);
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        // menggunakan string tokenizer

        buferedReader.reset();
        String data = buferedReader.readLine();
        System.out.println(data);

        StringTokenizer stringTokenizer = new StringTokenizer(data,",");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        // baris kedua
        data = buferedReader.readLine();
        System.out.println(data);

        stringTokenizer = new StringTokenizer(data,",");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
