package com.tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream fiileInput = null;
        FileOutputStream fileOutput = null;

        // membuka file
        fiileInput = new FileInputStream("input.txt");

        //membaca file
        int data = fiileInput.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fiileInput.read();
        }

        // menutup file
        fiileInput.close();

        // salah satu contoh skenario program pembukaan file

        try {
            // membuka file
            fiileInput = new FileInputStream("input2.txt");
            fileOutput = new FileOutputStream("output2.txt");

            // membaca file
            int buffer = fiileInput.read();

            while (buffer != -1) {
                fileOutput.write(buffer);
                buffer = fiileInput.read();
            }
        } finally {
            if (fiileInput != null) {
                fiileInput.close();
            }
            if (fileOutput != null) {
                fileOutput.close();
            }
        }

        // yang terakhir (try with resources)

        try (
                FileInputStream in = new FileInputStream("input.txt");
                FileOutputStream out = new FileOutputStream("output.txt")
        ){

            //membaca file
            int data2 = in.read();
            while (data2 != -1) {
                System.out.print((char) data2);
                data2 = in.read();
            }

        }


    }
}
