package com.tutorial;

import java.util.Formatter;

public class Java51 {

    public static void main(String[] args) {

        String nama = "Udin";
        int umur = 17;

        // output : Nama saya adalah Udin, umur saya adalah 17
        System.out.println("Nama saya adalah "+nama+", umur saya adalah "+umur);

        // cara lainnya adalah dengan format string
        System.out.printf("Nama saya adalah %s, umur saya adalah %d\n",nama,umur);

        // conversion f = floating point, d=integer, c=character, s=string, b=boolean

        // stuctur format = %[argument_index$][flags][witdh][.precision]conversion

        //[argument_index$]
        System.out.println("\n[argument_index$]");

        // udin, wahai udin, kemana saja kamu udin
        System.out.printf("%1$s, wahai %1$s, kemana saja kamu %1$s\n",nama);
        // umur udin berapa?, udin menjawab 17, wah masih muda ya umurnya 17
        System.out.printf("\numur %1$s berapa?, \n%1$s menjawab %2$d,\nwah masih muda ya umurnya %2$d",nama,umur);

        // [flags]
        System.out.println("\n[Flagh]");
        int int1 = 5;
        int int2 = 8;
        int hasil = int1 - int2;
        System.out.printf("%d - %d = %+d\n",int1, int2, hasil);

        //[width]
        System.out.println("\n[width");
        int int3 = 1000;
        System.out.println("Integer");
        System.out.printf("%d\n", int3);
        System.out.printf("%5d\n", int3);
        System.out.printf("%-5d\n", int3); // flags = "-", artinya rata kiri
        System.out.printf("%+5d\n", int3); // flags akan mengambil slot di dalam format
        System.out.printf("%+-6d\n", int3); // flags bisa digabungkan
        System.out.printf("%10d\n", int3);
        System.out.printf("% 10d\n", int3);
        System.out.printf("%010d\n", int3); // flags = "0", kita tambahkan leading "0" didepannya
        System.out.printf("%+010d\n", int3);
        int int4 = 1000000000;
        System.out.printf("%-,15d\n", int4); // flags =",", menandakan delimeter per seribu

        System.out.println("\n FLOATING POINT");
         float float1 = 1.543f;
        System.out.printf("%f\n",float1);
        System.out.printf("%+9f\n",float1); // floating point akan mengambil width dengan 6 decimal

        // [.precision]
        System.out.println("\n[.precision]");
        float float2 = 115.678f;
        System.out.printf("%f\n",float2);
        System.out.printf("%.1f\n",float2);
        System.out.printf("%.2f\n",float2);
        System.out.printf("%8.2f\n",float2); // gabungkan dengan width
        System.out.printf("%+08.2f\n",float2); // gabungkan dengan width dan flag

        //contoh
        String nama2 = "Ucup";
        float IPK = 3.7851230849827f;

        // structur format = %[argument_index$][flags][witdh][.precision]conversion
        System.out.printf("\nIPK %1$s berapa ?,\n%1$s : saya dapat %2$+5.2f\n",nama2,IPK);

        // kesimpulan

        // save format ini kedalam variabel string
        String info_biasa = "nama: "+nama2+", IPK = "+IPK;
        System.out.println("biasa -> "+info_biasa);

        String info_format = String.format("nama: %s, IPK = %2$+5.2f",nama2,IPK);
        System.out.println("string format -> "+info_format);

        //save format ini kedalam string builder
        StringBuilder builder_info = new StringBuilder();
        Formatter formatBuilder = new Formatter(builder_info);

        formatBuilder.format("nama: %s, IPK = %2$+5.2f",nama2,IPK);
        System.out.println("string builder format -> "+builder_info);


    }
}
