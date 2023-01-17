public class Alat extends Barang{

    private String kondisi;
    private int BarangPinjam=0;
    private int BarangTersedia=getJumlah();

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public int getBarangPinjam() {
        return BarangPinjam;
    }

    public void setBarangPinjam(int barangPinjam) {
        BarangPinjam = barangPinjam;
    }

    public int getBarangTersedia() {
        return BarangTersedia;
    }

    public void setBarangTersedia(int barangTersedia) {
        BarangTersedia = barangTersedia;
    }

    public Alat(String kode, String nama, int jumlah, String kondisi) {
        super(kode, nama, jumlah);
        this.kondisi = kondisi;

    }

    @Override
    public void ambil(int jumlahAmbil) {
        setBarangPinjam(getBarangPinjam()+jumlahAmbil);
        setBarangTersedia(getBarangTersedia()-jumlahAmbil);
    }

    @Override
    public void kembali(int jumlahKembali) {
        setBarangTersedia(getBarangTersedia()+jumlahKembali);
        setBarangPinjam(getBarangPinjam()-jumlahKembali);
    }
}
