import java.io.FileNotFoundException;
import java.util.Scanner;

public class Obat extends Barang{

    private int exp;

    Obat obat[]= new Obat[11];
    @Override
    public void setKode(String kode) {
        super.setKode(kode);
    }


    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExp() {
        return exp;
    }


    public Obat(String kode, String nama, int jumlah, int exp) {
        super(kode, nama, jumlah);
        this.exp = exp;
    }

    public void dataObat(){
        int i =0;
        java.io.File file = new java.io.File("ObatUks.txt");

        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                obat[i] = new Obat("","",0,0);
                obat[i].setKode(input.next());
                input.nextLine();
                obat[i].nama = input.nextLine();
                obat[i].setJumlah(input.nextInt());
                input.nextLine();
                obat[i].setExp(input.nextInt()) ;
                input.nextLine();
                System.out.println("Kode : " + obat[i].getKode());
                System.out.println("Nama : " + obat[i].nama);
                System.out.println("Jumlah : " + obat[i].getJumlah());
                System.out.println("Exp : " + obat[i].getExp());
                System.out.println();
                i++;
            }

            input.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void ambil(int jumlahAmbil) {

        setJumlah(getJumlah()-jumlahAmbil);
    }

    @Override
    public void kembali(int jumlahKembali) {
        setJumlah(getJumlah()+jumlahKembali);
    }
}
