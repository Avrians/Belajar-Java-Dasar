package com.tutorial;

public class Java34 {
    public static void main(String[] args) {
        // y = (x + 2) * x

        int y,x;
        x = 5;
        y = hitung(x);

        System.out.println("x = "+ x + ", y = "+ y);

        x =20;
        y = hitung(x);
        System.out.println("x = "+ x + ", y = "+ y);

        x =40;
        y = hitung(x);
        System.out.println("x = "+ x + ", y = "+ y);


    }
    private static int hitung(int input) {
        int hasil;

//        hasil = (input + 2) * 2;
        hasil = input * input;

        return hasil;
    }

}
