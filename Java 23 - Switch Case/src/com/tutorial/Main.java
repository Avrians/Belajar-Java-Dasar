package com.tutorial;

import java.util.Scanner;

public class Main {

    // switch case
    public static void main(String[] args) {

        String input;
        Scanner inputUser = new Scanner(System.in);

        System.out.print("Panggil nama : ");
        input = inputUser.next();
        // ekspresinya berupa satuan (int, long, byte,short), String, atau enum
        switch (input){
            case "otong":
                System.out.println("saya otong dan hadir bos");
                break;
            case "ucup":
                System.out.println("saya ucup dan hadir bos");
                break;
            case "mario":
                System.out.println("saya mario dan hadir bos");
                break;
            default:
                System.out.println(input + " tidak hadir bos");
        }
        System.out.println("selesai program");
    }
}
