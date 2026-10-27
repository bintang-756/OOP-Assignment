public class AlbumDigital extends ProdukMusik implements DapatDiputar {
    public AlbumDigital(String judul, double harga) {
        super(judul, harga);
    }

    @Override
    public double hitungHarga() {
        return harga * 0.9; // diskon 10% untuk produk digital
    }

    @Override
    public void putar() {
        System.out.println("Memutar album digital: " + judul);
    }
}
