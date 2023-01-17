import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Pasien implements KamarUks{
    private int idPasien,  i=0;
    public int umur, noKamar;
    public  String nama, jk, penyakit, ket;
    String jamMasuk, jamKeluarPasien;
    Date jam = new Date();

    Pasien pasien[] = new Pasien[100];
    Scanner input = new Scanner(System.in);

    public Pasien() {
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    @Override
    public boolean kamarKosong(int noKamar) {
        return false;
    }

    @Override
    public void checkKamarKosong(int nomerkamar) {
        for(int y=0;y< kamar.length;y++){
            if(nomerkamar == kamar[i]){
                kamarKosong(nomerkamar);
            }
        }
    }

    void chekIn () throws IOException {
        FileWriter writer = new FileWriter("CheckIn.txt", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            Pasien pasienMasuk = new Pasien();
            System.out.print("Nama          : ");
            pasienMasuk.nama = input.nextLine();
            System.out.print("Keluhan       : ");
            pasienMasuk.penyakit = input.nextLine();
            System.out.println("Data tambahan");
            System.out.print("Jenis kelamin : ");
            pasienMasuk.jk = input.next();
            System.out.print("Umur          : ");
            pasienMasuk.umur = input.nextInt();
            System.out.print("No kamar    : ");
            pasienMasuk.noKamar = input.nextInt();
            pasienMasuk.checkKamarKosong(pasienMasuk.noKamar);
            while(pasienMasuk.kamarKosong(pasienMasuk.noKamar)){
                jam = new Date();
                buffer.write(String.valueOf(jam) + "\n");
                buffer.write(pasienMasuk.noKamar + "\n");
                buffer.write(pasienMasuk.nama + "\n");
                buffer.write(pasienMasuk.penyakit + "\n");
                buffer.write(pasienMasuk.jk +  "\n");
                buffer.write( pasienMasuk.umur + "\n");
            }

            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void chekOut(int idPasienCO) throws IOException{
        i = 0;
        java.io.File file = new java.io.File("CheckIn.txt");
        try {
            Scanner input = new Scanner(file);
            System.out.println("Data Pasien : ");
            while (input.hasNext()) {
                pasien[i] = new Pasien();
                pasien[i].jamMasuk = input.nextLine();
                pasien[i].noKamar = input.nextInt();
                input.nextLine();
                pasien[i].idPasien = input.nextInt();
                input.nextLine();
                pasien[i].nama = input.nextLine();
                pasien[i].ket = input.nextLine();
                pasien[i].penyakit = input.nextLine();
                pasien[i].jk = input.nextLine();
                pasien[i].umur = input.nextInt();
                input.nextLine();
                input.nextLine();
                 i++;
            }
            input.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(pasien[0].nama);
        System.out.println(pasien[1].nama);

       for (int x = 0; x < i; x++) {
            if ( pasien[x].idPasien == idPasienCO) {
                System.out.println("ID               :" +  pasien[x].idPasien);
                System.out.println("Nomer Kamar      : " + pasien[x].noKamar);
                System.out.println("Nama             : " + pasien[x].nama);
                System.out.println("Keterangan       : " + pasien[x].ket);
                System.out.println("Jenis Kelamin    : " + pasien[x].jk);
                System.out.println("Umur             : " + pasien[x].umur);
                System.out.println("Penyakit         : " + pasien[x].penyakit);
                System.out.println("Jam masuk        : " + pasien[x].jamMasuk);
                jam = new Date();
                pasien[x].jamKeluarPasien = String.valueOf(jam);
                System.out.println("Jam Keluar       : " + pasien[x].jamKeluarPasien);
                Data Pasien = new Data();
                Pasien.UpdateDataPasien(pasien[x]);
            }
           pasien[i].kamarKosong(pasien[x].noKamar);
       }
    }


}




