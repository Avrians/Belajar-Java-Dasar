package com.tutorial;

import java.util.Locale;
import java.util.Scanner;

public class Java49 {

    public static void main(String[] args) {

        String kalimat = "Saya suka makan pisang";

        // Mengambil komponen dari string
        System.out.println(kalimat.charAt(5));

        // Substring
        String kata = kalimat.substring(10,15);
        System.out.println(kata);

        // concatenation (concat)
        String kalimat2 = kata + " bakwan";
        System.out.println(kalimat2);

        kata = kata + " cireng";
        System.out.println(kata);

        // concat dengan non string
        int jumlah = 20;
        String kalimat3 = kata + " " + jumlah; //casting
        System.out.println(kalimat3);
        System.out.println(kata + " " + jumlah);

        // lowercawe dan uppercase
        System.out.println(kalimat.toUpperCase());
        System.out.println(kalimat.toLowerCase());

        // replace
        String kalimat4 = kalimat.replace("pisang", "combro");
        System.out.println(kalimat);
        System.out.println(kalimat4);

        // Compare
        String motor1 = "royal himalayan";
        String motor2 = "kawasaki w175";
        System.out.println(motor1.compareTo(motor2)); // klmnopqr
        System.out.println(motor2.compareTo(motor1));

        String gorengan1 = "bakwan";
        String gorengan2 = "bala-bala";
        System.out.println(gorengan1.compareTo(gorengan2));
        System.out.println(gorengan2.compareTo(gorengan1));


        // equality (persamaan)
        String kataInput = "test"; // ini ada di string pool
//        String kataInput = new String("test"); // ini bukan string literal, dan tidak berada di string pool
        String KataTest = "test"; // ini juda ada di string pool

        System.out.println("\nPersamaan pada lokasi string pool");
        if (kataInput ==  KataTest) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }

        Scanner userInput = new Scanner(System.in);
        System.out.print("\nmengambil input dari user: ");
        kataInput = userInput.next();
        System.out.println("ini adalah input user: "+kataInput);

        if (kataInput.equals(KataTest)) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }

    }
}
