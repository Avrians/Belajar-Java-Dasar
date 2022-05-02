package com.tutorial;

public class Java50 {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("helo");
        PrintData(builder);

        // append
        builder.append(" semuanya");
        PrintData(builder);

        builder.append(" warga Surabaya");
        PrintData(builder);

        // insert
        builder.insert(19, " Kota");
        PrintData(builder);

        // delete
        builder.delete(19,24);
        PrintData(builder);

        // rubah karakter pada index tertentu
        builder.setCharAt(14, 'W');
        PrintData(builder);

        // replace
        builder.replace(20,28, "Bandung");
        PrintData(builder);

        // casting menjadi string
        String kalimat = builder.toString();
        System.out.println(kalimat);
        int addressString = System.identityHashCode(kalimat);
        System.out.println("address = "+Integer.toHexString(addressString));
    }
    private static void PrintData (StringBuilder dataBuilder) {
        System.out.println("data = " + dataBuilder);
        System.out.println("panjang = "+ dataBuilder.length());
        System.out.println("kapasitar = "+ dataBuilder.capacity());

        int addressBuilder = System.identityHashCode(dataBuilder);
        System.out.println("adress = "+ Integer.toHexString(addressBuilder));
    }
}
