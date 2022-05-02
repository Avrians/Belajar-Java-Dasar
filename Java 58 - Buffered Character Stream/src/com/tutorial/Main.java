package com.tutorial;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        // membaca file dulu
        FileReader fileInput = new FileReader("input.txt");
        BufferedReader buferReader = new BufferedReader(fileInput);
        buferReader.mark(200);

        // membaca kedalam string
        String data = buferReader.readLine();
        System.out.println(data);

        // membaca kedalam char
        buferReader.reset();
        char[] dataChar = new char[25];
        buferReader.read(dataChar,0,25);
        System.out.println(Arrays.toString(dataChar));

        // membaca baris
        buferReader.reset();
        System.out.println(buferReader.readLine());
        System.out.println(buferReader.readLine());

        // menulis file
        FileWriter fileOutput = new FileWriter("output.txt");
        BufferedWriter buferWriter = new BufferedWriter(fileOutput);

        buferReader.reset();
        String baris1 = buferReader.readLine();

        buferWriter.write(baris1,0,baris1.length());
        buferWriter.flush();

        // menambah new line, enter;
        buferWriter.newLine();

        String baris2 = buferReader.readLine();
        buferWriter.write(baris2,0,baris2.length());
        buferWriter.flush();

        buferReader.close();
        buferWriter.close();
        fileInput.close();
        fileOutput.close();
    }
}
