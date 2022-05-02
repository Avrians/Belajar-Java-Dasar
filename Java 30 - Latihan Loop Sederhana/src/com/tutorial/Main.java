package com.tutorial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // program untuk menjumlahkan angka dengan rentang

        int nilaiAwal, nilaiAkhir, total;

        Scanner inputUser = new Scanner(System.in);
        System.out.print("memasukan nilai awal = ");
        nilaiAwal = inputUser.nextInt();
        System.out.print("memasukan nilai akhir = ");
        nilaiAkhir = inputUser.nextInt();

        total = 0;
        while (nilaiAwal <= nilaiAkhir){
            total = total + nilaiAwal;
            System.out.println("ditambah " + nilaiAwal + " menjadi " + total);
            nilaiAwal++;
        }

        // tugas -> for loop, do while..
    }
}
