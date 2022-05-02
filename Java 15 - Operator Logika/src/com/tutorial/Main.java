package com.tutorial;

public class Main {

    public static void main(String[] args) {

        // Operator Logika ---> operasi yang bisa kita lakukan kepada tipe data bolean
        // Anf, or, Xor, negasi

        boolean a, b, c;

        // Or / atau (||)

        System.out.println("==== OR (||) ====");
        a = false;
        b = false;
        c = (a || b);
        System.out.println(a + " || " + b + " = " + c);
        a = false;
        b = true;
        c = (a || b);
        System.out.println(a + " || " + b + " = " + c);
        a = true;
        b = false;
        c = (a || b);
        System.out.println(a + " || " + b + " = " + c);
        a = true;
        b = true;
        c = (a || b);
        System.out.println(a + " || " + b + " = " + c);

        // And / dan (&&)

        System.out.println("==== AND (&&) ====");
        a = false;
        b = false;
        c = (a && b);
        System.out.println(a + " && " + b + " = " + c);
        a = false;
        b = true;
        c = (a && b);
        System.out.println(a + " && " + b + " = " + c);
        a = true;
        b = false;
        c = (a && b);
        System.out.println(a + " && " + b + " = " + c);
        a = true;
        b = true;
        c = (a && b);
        System.out.println(a + " && " + b + " = " + c);

        // XOR / Exlusive Or (^)

        System.out.println("==== XOR (^) ====");
        a = false;
        b = false;
        c = (a ^ b);
        System.out.println(a + " ^ " + b + " = " + c);
        a = false;
        b = true;
        c = (a ^ b);
        System.out.println(a + " ^ " + b + " = " + c);
        a = true;
        b = false;
        c = (a ^ b);
        System.out.println(a + " ^ " + b + " = " + c);
        a = true;
        b = true;
        c = (a ^ b);
        System.out.println(a + " ^ " + b + " = " + c);

        // Not / negasi ---> flipping (!)
        System.out.println("==== Negasi (!) ====");
        a = true;
        c = !a;
        System.out.println(a + " ---> (!) = " + c);

        a = false;
        c = !a;
        System.out.println(a + " ---> (!) = " + c);

    }
}
