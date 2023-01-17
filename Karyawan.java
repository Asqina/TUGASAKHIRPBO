import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Karyawan extends Pasien{
    private int NIP;
    String jabatan;

    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public Karyawan() {
    }

    @Override
    void chekIn() throws IOException {
        FileWriter writer = new FileWriter("CheckIn.txt", true);
        BufferedWriter buffer = new BufferedWriter(writer);
        try {
            System.out.print("NIP          : ");
            setNIP(input.nextInt());
            System.out.print("Nama          : ");
            nama = input.next();
            input.nextLine();
            System.out.print("Keluhan       : ");
            penyakit = input.next();
            input.nextLine();
            System.out.println("Data tambahan");
            System.out.print("Jabatan          : ");
            jabatan = input.nextLine();
            System.out.print("Jenis kelamin : ");
            jk = input.next();
            System.out.print("Umur          : ");
            umur = input.nextInt();
            System.out.print("No kamar    : ");
            noKamar = input.nextInt();
            buffer.write(String.valueOf(jam) + "\n");
            buffer.write(noKamar + "\n");
            buffer.write(NIP + "\n");
            buffer.write(nama + "\n");
            buffer.write(jabatan + "\n");
            buffer.write(penyakit + "\n");
            buffer.write(jk +  "\n");
            buffer.write( umur + "\n\n");
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    void chekOut(int idPasienCO) throws IOException {
        super.chekOut(idPasienCO);
    }
}
