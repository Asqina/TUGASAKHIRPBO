public abstract  class Barang {
    public String nama;
    private String kode;
    private int jumlah;

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Barang(String kode, String nama, int jumlah){
        this.kode = kode;
        this.nama= nama;
        this.jumlah = jumlah;
    }

    public abstract void ambil(int jumlahAmbil);
    public abstract void kembali(int jumlahKembali);
}
