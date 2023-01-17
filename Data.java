import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    int i ;
    Obat[] obat2an = new Obat[11];
    Alat[] alat2 = new Alat[19];
    Pasien[] pasien2 = new Pasien[100];
    ArrayList<Obat> obatUks = new ArrayList<Obat>();
    ArrayList<Alat> alatUks = new ArrayList<Alat>();

    public int getI() {
        return i;
    }
    public void DataObat() throws IOException {
        i =0;
        java.io.File file = new java.io.File("ObatUks.txt");
        String path = file.getCanonicalPath();
        File filePath = new File(path);
       try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                obat2an[i] = new Obat("","",0,0);
                obatUks.add(obat2an[i]);

                obatUks.get(i).setKode(input.next());
                input.nextLine();
                obatUks.get(i).nama = input.nextLine();
                obatUks.get(i).setJumlah(input.nextInt());
                input.nextLine();
                obatUks.get(i).setExp(input.nextInt()) ;
                input.nextLine();
                System.out.println("Kode : " + obatUks.get(i).getKode());
                System.out.println("Nama : " + obatUks.get(i).nama);
                System.out.println("Jumlah : " + obatUks.get(i).getJumlah());
                System.out.println("Exp : " + obatUks.get(i).getExp());
                System.out.println();
                i++;
            }
            input.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
    public void DataAlat()throws IOException{
        i =0;
        java.io.File file = new java.io.File("AlatUks.txt");
        String path = file.getCanonicalPath();
        File filePath = new File(path);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                alat2[i] = new Alat("","",0,"");
                alatUks.add(alat2[i]);
                alatUks.get(i).setKode(input.next());
                input.nextLine();
                alatUks.get(i).nama = input.nextLine();
                alatUks.get(i).setJumlah(input.nextInt());
                input.nextLine();
                alatUks.get(i).setKondisi(input.next());
                input.nextLine();
                System.out.println("Kode    : " + alatUks.get(i).getKode());
                System.out.println("Nama    : " + alatUks.get(i).nama);
                System.out.println("Jumlah  : " + alatUks.get(i).getJumlah() + "( Tersedia " +  alatUks.get(i).getBarangTersedia() + " Dipinjam " +  alatUks.get(i).getBarangPinjam() + " )" );
                System.out.println("Kondisi : " + alatUks.get(i).getKondisi());
                System.out.println();
                i++;
            }
            input.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void DataPasien(){
            i = 0;
            java.io.File file = new java.io.File("bukuData.txt");
            try {
                Scanner input = new Scanner(file);
                System.out.println("Data Pasien : ");
                while (input.hasNext()) {
                    pasien2[i] = new Pasien();
                    pasien2[i].setIdPasien(input.nextInt());
                    input.nextLine();
                    pasien2[i].noKamar = input.nextInt();
                    input.nextLine();
                    pasien2[i].nama = input.nextLine();
                    pasien2[i].ket = input.nextLine();
                    pasien2[i].jk = input.nextLine();
                    pasien2[i].umur = input.nextInt();
                    input.nextLine();
                    pasien2[i].penyakit = input.nextLine();
                    pasien2[i].jamMasuk = input.nextLine();
                    pasien2[i].jamKeluarPasien = input.nextLine();
                    input.nextLine();
                    i++;
                }
                input.close();
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            for(int x=0; x<i; x++){
                System.out.println("ID               :" +  pasien2[x].getIdPasien());
                System.out.println("Nomer Kamar      : " + pasien2[x].noKamar);
                System.out.println("Nama             : " + pasien2[x].nama);
                System.out.println("Keterangan       : " + pasien2[x].ket);
                System.out.println("Jenis Kelamin    : " + pasien2[x].jk);
                System.out.println("Umur             : " + pasien2[x].umur);
                System.out.println("Penyakit         : " + pasien2[x].penyakit);
                System.out.println("Jam masuk        : " + pasien2[x].jamMasuk);
                System.out.println("Jam Keluar       : " + pasien2[x].jamKeluarPasien);
                System.out.println("");
            }

        }

    public void UpdateDataPasien(Pasien pasienCO) throws IOException{
        FileWriter writer = new FileWriter("bukuData.txt", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            buffer.write(pasienCO.getIdPasien() + "\n");
            buffer.write(pasienCO.noKamar + "\n");
            buffer.write(pasienCO.nama + "\n");
            buffer.write(pasienCO.ket + "\n");
            buffer.write(pasienCO.jk +  "\n");
            buffer.write( pasienCO.umur + "\n");
            buffer.write( pasienCO.penyakit + "\n");
            buffer.write(pasienCO.jamMasuk + "\n");
            buffer.write(pasienCO.jamKeluarPasien + "\n\n");
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDataObat(ArrayList<Obat> obat)  throws IOException {
        FileWriter writer = new FileWriter("ObatUks.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            for (int i=0;i< obat2an.length;i++){
                buffer.write(obat.get(i).getKode() + "\n");
                buffer.write(obat.get(i).nama + "\n");
                buffer.write(obat.get(i).getJumlah() + "\n");
                buffer.write(obat.get(i).getExp() + "\n\n");

            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateDataAlat(ArrayList<Alat> alat)  throws IOException {
        FileWriter writer = new FileWriter("AlatUks.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            for (int i=0;i< alat2.length;i++){
                buffer.write(alat.get(i).getKode() + "\n");
                buffer.write(alat.get(i).nama + "\n");
                buffer.write(alat.get(i).getJumlah() + "\n");
                buffer.write(alat.get(i).getKondisi() + "\n\n");

            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}