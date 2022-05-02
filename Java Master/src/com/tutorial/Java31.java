package com.tutorial;

import java.util.Scanner;

public class Java31 {

    public static void main(String[] args) {

        // menghitung nilai deret fibonaci ke-n
        int fn, fn1, fn2, n;

        Scanner inputUser = new Scanner(System.in);
        System.out.print("mengambil nilai fibonaci ke - : ");
        n = inputUser.nextInt();

        fn2 = 0;
        fn1 = 1;
        fn = 1;
        for(int i = 1; i <= n;i++) {
            System.out.println("nilai ke - "+ i + " adalah "+ fn);
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }

        // tugas bikin dalm program while dan do while
    }
}
