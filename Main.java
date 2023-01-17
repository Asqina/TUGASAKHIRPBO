import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean kondisi = true;
        Scanner input = new Scanner(System.in);
        Data user1 = new Data();
        while(kondisi){
            System.out.println("===========================================");
            System.out.println("|           UNIT KESEHATAN SEKOLAH        |");
            System.out.println("|           SMA NEGERI 7 YOGAKARTA        |");
            System.out.println("===========================================");
            System.out.println("|1. Data Pasien                           |");
            System.out.println("|2. Data Barang                           |");
            System.out.println("|Tekan sembarang angka untuk keluar       |");
            System.out.println("===========================================");
            System.out.print("Pilih menu :" );
            int menu = input.nextInt();
            switch(menu){
                case 1 : {
                    System.out.println("===========================================");
                    System.out.println("|               DATA PASIEN UKS           |");
                    System.out.println("|           SMA NEGERI 7 YOGAKARTA        |");
                    System.out.println("===========================================");
                    System.out.println("|1. Chek In                               |");
                    System.out.println("|2. Chek Out                              |");
                    System.out.println("|3. Data Pasien                           |");
                    System.out.println("|4. Kembali                               |");
                    System.out.println("===========================================");
                    System.out.print("Pilih menu :" );
                    int menuPasien = input.nextInt();
                    Pasien pasienBaru = new Pasien();
                    if(menuPasien == 1){
                        System.out.println("===================================================================");
                        System.out.println("||                      KATEGORI PASIEN                          ||");
                        System.out.println("===================================================================");
                        System.out.println("||  1. Pelajar                                                   ||");
                        System.out.println("||  2. Karyawan                                                  ||");
                        System.out.println("===================================================================");
                        System.out.print("||Pilih menu : ");
                        int pasienKategori = input.nextInt();
                        if(pasienKategori == 1 ){
                            Pelajar pasienPelajar = new Pelajar();
                            pasienPelajar.chekIn();
                        }
                        else if(pasienKategori==2){
                            Karyawan pasienKryawan = new Karyawan();
                            pasienKryawan.chekIn();
                        }
                    }
                    else if (menuPasien == 2){
                        System.out.print("Masukan id pasien : ");
                        int idPasienCO = input.nextInt();
                        pasienBaru.chekOut(idPasienCO);
                    }
                    else if(menuPasien == 3){
                        user1.DataPasien();
                    }
                    break;
                }
                case 2 : {
                    System.out.println("===========================================");
                    System.out.println("|               DATA BARANG UKS           |");
                    System.out.println("|           SMA NEGERI 7 YOGAKARTA        |");
                    System.out.println("===========================================");
                    System.out.println("|1. Obat                                  |");
                    System.out.println("|2. Alat kesehatan                        |");
                    System.out.println("===========================================");
                    System.out.print("Pilih menu :" );
                    int menuBarang = input.nextInt();
                    if(menuBarang == 1) {
                        user1.DataObat();
                        System.out.println("1. Ambil Obat");
                        System.out.println("2. Tambah Obat");
                        System.out.println("3. Kembali");
                        System.out.print("Masukan pilihan : ");
                        int menuObat = input.nextInt();

                        switch (menuObat) {
                            case 1: {
                                String FOLDER_FILE = "";
                                String NAMA_FILE = "ObatUks.txt";
                                File file2 = new File(FOLDER_FILE + "" + NAMA_FILE);
                                try {
                                    if (file2.createNewFile()) {
                                        System.out.println("ghjfg");
                                    }
                                } catch (IOException ex) {
                                    System.out.println("Data tidak ditemukan !\n" + ex.getMessage());
                                }
                                System.out.print("Nama obat : ");
                                String namaAmbil = input.next();
                                input.nextLine();
                                for (int x = 0; x < user1.getI(); x++) {
                                    if (namaAmbil.equals(user1.obatUks.get(x).nama)) {
                                        System.out.print("Jumlah ambil : ");
                                        int jumlahAmbil = input.nextInt();
                                           user1.obatUks.get(x).ambil(jumlahAmbil);
                                    }
                                }
                                user1.updateDataObat(user1.obatUks);
                                break;
                            }
                               case 2 : {
                                    String FOLDER_FILE = "";
                                    String NAMA_FILE = "ObatUks.txt";
                                    File file2 = new File(FOLDER_FILE+""+NAMA_FILE);
                                    try {
                                        if(file2.createNewFile()) {
                                            System.out.println("Berhasil memperbarui data");
                                        }
                                    }catch (IOException ex) {
                                        System.out.println("gagal membuat file !\n"+ex.getMessage());
                                    }
                                    System.out.print("Nama obat : ");
                                    String namaAmbil = input.next();
                                    input.nextLine();
                                    String namaRestok = namaAmbil;
                                    for(int x = 0; x< user1.getI();x++){
                                        if (namaAmbil.equals(user1.obatUks.get(x).nama)) {
                                            System.out.print("Jumlah Restok : ");
                                            int jumlahRestok = input.nextInt();
                                            user1.obatUks.get(x).kembali(jumlahRestok);
                                        }
                                    }
                                user1.updateDataObat(user1.obatUks);
                                    break;
                                }
                            default: {
                                System.out.println("Kembali ke menu utama");
                                break;
                            }
                        }
                    }
                    if(menuBarang == 2){
                        user1.DataAlat();
                        System.out.println("1. Ambil Alat");
                        System.out.println("2. Kembalikan alat");
                        System.out.println("3. Kembali");
                        System.out.print("Masukan pilihan : ");
                        int menuAlat= input.nextInt();

                        switch (menuAlat) {
                            case 1: {
                                String FOLDER_FILE = "";
                                String NAMA_FILE = "AlatUks.txt";
                                File file2 = new File(FOLDER_FILE + "" + NAMA_FILE);
                                try {
                                    if (file2.createNewFile()) {
                                        System.out.println("Berhasil akses data peralatan");
                                    }
                                } catch (IOException ex) {
                                    System.out.println("Data tidak ditemukan !\n" + ex.getMessage());
                                }
                                System.out.print("Nama alat : ");
                                String namaAmbil = input.next();
                                input.nextLine();
                                for (int x = 0; x < user1.getI(); x++) {
                                    if (namaAmbil.equals(user1.alatUks.get(x).nama)) {
                                        System.out.print("Jumlah ambil : ");
                                        int jumlahAmbil = input.nextInt();
                                        user1.alatUks.get(x).ambil(jumlahAmbil);
                                    }
                                }
                                user1.updateDataAlat(user1.alatUks);
                                break;
                            }
                            case 2 : {
                                String FOLDER_FILE = "";
                                String NAMA_FILE = "AlatUks.txt";
                                File file2 = new File(FOLDER_FILE+""+NAMA_FILE);
                                try {
                                    if(file2.createNewFile()) {
                                        System.out.println("Berhasil memperbarui data");
                                    }
                                }catch (IOException ex) {
                                    System.out.println("gagal membuat file !\n"+ex.getMessage());
                                }
                                System.out.print("Nama Alat : ");
                                String namaAmbil = input.next();
                                input.nextLine();
                                String namaRestok = namaAmbil;
                                for(int x = 0; x< user1.getI();x++){
                                    if (namaAmbil.equals(user1.alatUks.get(x).nama)) {
                                        System.out.print("Jumlah kembali : ");
                                        int jumlahRestok = input.nextInt();
                                        user1.alatUks.get(x).kembali(jumlahRestok);
                                    }
                                }
                                user1.updateDataAlat(user1.alatUks);
                                break;
                            }
                            default: {
                                System.out.println("Kembali ke menu utama");
                                break;
                            }
                        }
                    }
                    break;
                }
                default:{
                    kondisi = false;
                }
            }
        }

    }
}
