package com.tutorial;

import java.util.Arrays;

public class Java45 {
    public static void main(String[] args) {
        System.out.println("belajar array multidimensi");

        // cara membuat array dua dimensi dengan assignment

        int[][] array2Dimensi =  {
                {1,2},
                {3,4}
        };

        printArray2D(array2Dimensi);

        // cara membuat array 2 dimens dengan deklarasi
        // int [baris] [kolom]
        int[][] arrayAngka = new int[5][4];

        printArray2D(arrayAngka);

        // looping lengkap secara manual

//        for (int i = 0;i<arrayAngka.length;i++) {
//            System.out.print("[");
//            for (int j = 0; j < arrayAngka[i].length; j++) {
//                System.out.print(arrayAngka[i][j] + ",");
//            }
//            System.out.print("]\n");
//        }

        // looping foreach

//        for (int[] baris : arrayAngka) {
//            System.out.print("[");
//            for (int angka : baris) {
//                System.out.print(angka + ",");
//            }
//            System.out.print("]\n");
//        }

        // array secara manual, untuk pembuktian

        int[][] array2D2 = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };

        printArray2D(array2D2);

        int [][] arrayRaged = {
                {1,2,3},
                {4,5,6,7},
                {8}
        };

        printArray2D(arrayRaged);

    }

    private static void printArray2D(int[][] dataArray) {
        System.out.print("{\n");
        for (int[] baris : dataArray) {
            System.out.print("[");
            for (int angka : baris) {
                System.out.print(angka + ",");
            }
            System.out.print("]\n");
        }
        System.out.print("}\n");
    }
}
