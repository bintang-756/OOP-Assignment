public abstract class ProdukMusik {
    protected String judul;
    protected double harga;

    public ProdukMusik(String judul, double harga) {
        this.judul = judul;
        this.harga = harga;
    }

    public abstract double hitungHarga();
    
    public void tampilkanInfo() {
        System.out.printf("%s | Harga akhir: Rp%.0f%n", judul, hitungHarga());
    }
}
