package com.tutorial;

public class Main {

    public static void main(String[] args) {

        String nama = "Udin";
        int umur = 17;

        // output : Nama saya adalah Udin, umur saya adalah 17
        System.out.println("Nama saya adalah "+nama+", umur saya adalah "+umur);

        // cara lainya adalah dengan format sring
        System.out.printf("Nama saya adalah %s,umur saya adalah %d\n", nama, umur);

        // convertion : f = floating point, d = integer, c = character, s = string, b = boolean

        // struktur format = %[argument_indexs$][flags][width][.precision]convertion

        // [argument_indexs$]
        System.out.println("\n[argument_indexs$]");

        // udin, wahai udin, kemana saja kamu udin
        System.out.printf("%1$s, wahai %1$s, kemana saja kamu %1$s?\n", nama);
        // umur udin berapa?, udin menjawab : 17, wah masih muda ya umurnya 17
        System.out.printf("\numur %1$s berapa?,\n%1$s menjawab: %2$d \nwah masih muda ya umurnya %2$d\n", nama,umur);

        // [flags]
        System.out.println("[flags]");


    }
}
