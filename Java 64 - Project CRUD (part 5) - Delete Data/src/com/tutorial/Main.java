package com.tutorial;

import java.io.*;
import java.time.Year;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.println("Database Perpustakaan");
            System.out.println("1.\tLihat seluruh buku");
            System.out.println("2.\tCari data buku");
            System.out.println("3.\tTambah data buku");
            System.out.println("4.\tUbah data buku");
            System.out.println("5.\tHapus data buku");

            System.out.print("\n\nPilihan anda : ");
            pilihanUser = terminalInput.next();

            switch (pilihanUser){
                case "1":
                    System.out.println("\n=================");
                    System.out.println("LIST SELURUH BUKU");
                    System.out.println("=================");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("\n=========");
                    System.out.println("CARI BUKU");
                    System.out.println("=========");
                    cariData();
                    break;
                case "3":
                    System.out.println("================");
                    System.out.println("TAMBAH DATA BUKU");
                    System.out.println("================");
                    tambahData();
                    tampilkanData();
                    break;
                case "4":
                    System.out.println("\n==============");
                    System.out.println("UBAH DATA BUKU");
                    System.out.println("==============");
                    // ubah data
                    break;
                case "5":
                    System.out.println("\n===============");
                    System.out.println("HAPUS DATA BUKU");
                    System.out.println("===============");
                    deleteData();
                    break;
                default:
                    System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-5]");
            }

            isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan ");
        }
    }

    private static void deleteData() throws IOException {
        // kita ambil database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        // kita buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        // tampilkan data
        System.out.println("List Buku");
        tampilkanData();

        // kita ambil user input untuk mendelete data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\nMasukan nomor buku yang akan dihapus: ");
        int deleteNum = terminalInput.nextInt();


        // looping untuk membaca tiap data baris dan skip data yang akan di delete
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while (data != null) {
            entryCounts++;
            boolean isDelete = false;

            StringTokenizer st = new StringTokenizer(data, ",");
            // tampilkan data yang ingin dihapus
            if (deleteNum == entryCounts) {
                System.out.println("\nData yang ingin anda hapus adalah: ");
                System.out.println("==========================================");
                System.out.println("Referensi      : "+ st.nextToken());
                System.out.println("Tahun          : "+ st.nextToken());
                System.out.println("Penulis        : "+ st.nextToken());
                System.out.println("Penerbit       : "+ st.nextToken());
                System.out.println("Judul          : "+ st.nextToken());
                isDelete = getYesorNo("Apakah anda yakin akan menghapus? ");
            }
            data = bufferedInput.readLine();
        }
    }

    private static void tampilkanData() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e ) {
            System.err.println("\nDatabase tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }

        System.out.println("\n| No |\tTahun |\tPenulis               |\tPenerbit              |\tJudul Buku");
        System.out.println("----------------------------------------------------------------------------------");

        String data = bufferInput.readLine();
        int nomorData = 0;
        while (data != null) {
            nomorData++;
            StringTokenizer stringToken = new StringTokenizer(data,",");
            stringToken.nextToken();

            System.out.printf("| %2d ",nomorData);
            System.out.printf("|\t%4s  ",stringToken.nextToken());
            System.out.printf("|\t%-20s  ",stringToken.nextToken());
            System.out.printf("|\t%-20s  ",stringToken.nextToken());
            System.out.printf("|\t%s  ",stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("----------------------------------------------------------------------------------");
    }

    private static void cariData() throws IOException {

        // membaca database ada atau tidak

        try {
            File file = new File("database.txt");
        } catch (Exception e ) {
            System.err.println("\nDatabase tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }

        // kita ambil keyword dari user

        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Masukan kata kunci untuk mencari buku: ");
        String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // kita cek keyword di database
        cekBukuDiDatabase(keywords, true);

    }

    private static void tambahData() throws IOException {

        FileWriter fileOutput = new FileWriter("database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // mengambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String penulis, judul, penerbit, tahun;

        System.out.print("Masukan nama penulis : ");
        penulis = terminalInput.nextLine();
        System.out.print("Masukan judul buku : ");
        judul =  terminalInput.nextLine();
        System.out.print("Masukan nama penerbit : ");
        penerbit = terminalInput.nextLine();
        System.out.print("Masukan tahun terbit, format=(YYYY) : ");
        tahun = ambilTahun();

        // cek buku di database

        String[] keywords = {tahun+","+penulis+","+penerbit+","+judul};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = cekBukuDiDatabase(keywords, false);

        // menulis buku di database
        if(!isExist) {
            // fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
            System.out.println(ambilEntriperTahun(penulis, tahun)+1);
            long nomorEntry = ambilEntriperTahun(penulis, tahun)+1;

            String penulistanpaSpasi =  penulis.replaceAll("\\s+","");
            String primarykey = penulistanpaSpasi+"_"+tahun+"_"+nomorEntry;
            System.out.println("\nData yang akan anda masukan adalah");
            System.out.println("==========================================");
            System.out.println("primary key   : "+primarykey);
            System.out.println("tahun terbit  : "+tahun);
            System.out.println("penulis       : "+penulis);
            System.out.println("judul         : "+judul);
            System.out.println("penerbit      : "+penerbit);

            boolean isTambah = getYesorNo("Apakah anda ingin menambahkan data tersebut? ");

            if (isTambah) {
                bufferOutput.write(primarykey+","+tahun+","+penulis+","+penerbit+","+judul);
                bufferOutput.newLine();
                bufferOutput.flush();
            }

        } else {
            System.out.println("buku yang anda akan masuakan sudah tersedia di database dengan data berikut :");
            cekBukuDiDatabase(keywords, true);
        }

        bufferOutput.close();

    }

    private static long ambilEntriperTahun(String penulis, String tahun) throws IOException{
        FileReader fileinput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileinput);

        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primaryKey;

        while(data != null) {
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");

            penulis = penulis.replaceAll("\\s+","");
            if (penulis.equalsIgnoreCase(dataScanner.next()) && tahun.equalsIgnoreCase(dataScanner.next())) {
                entry = dataScanner.nextInt();
            }

            data = bufferInput.readLine();
        }
        return entry;
    }

    private static boolean cekBukuDiDatabase(String[] keywords, boolean isDisplay) throws IOException {

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist =  false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("\n| No |\tTahun |\tPenulis               |\tPenerbit              |\tJudul Buku");
            System.out.println("----------------------------------------------------------------------------------");
        }

        while (data != null) {

            // cek keywords didalam baris
            isExist =  true;

            for (String keyword:keywords) {
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());

            }

            // jika keywordnya cocok maka tampilkan

            if(isExist) {
                if (isDisplay) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data,",");
                    stringToken.nextToken();

                    System.out.printf("| %2d ",nomorData);
                    System.out.printf("|\t%4s  ",stringToken.nextToken());
                    System.out.printf("|\t%-20s  ",stringToken.nextToken());
                    System.out.printf("|\t%-20s  ",stringToken.nextToken());
                    System.out.printf("|\t%s  ",stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }
            data = bufferInput.readLine();
        }

        if(isDisplay) {
            System.out.println("----------------------------------------------------------------------------------");
        }

        return isExist;
    }

    private static String ambilTahun() throws IOException {
        boolean tahunValid = false;
        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();
        while(!tahunValid){
            try {
                Year.parse(tahunInput);
                tahunValid = true;
            } catch (Exception e) {
                System.err.println("Format tahun yang anda masukan salah, format=(YYYY)");
                System.out.print("Silahkan masukan tahun lagi : ");
                tahunValid = false;
                tahunInput = terminalInput.nextLine();
            }
        }

        return tahunInput;
    }

    private static boolean getYesorNo(String message) {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n"+message+" (y/n)? ");
        String pilihanUser = terminalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n"+message+" (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("tidak bisa clear screen");
        }
    }
}
