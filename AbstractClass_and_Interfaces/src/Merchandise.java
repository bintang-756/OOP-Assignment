// extends 1 abstract class + implements 1 interface (hanya bisa dikirim)
public class Merchandise extends ProdukMusik implements DapatDikirim {
    public Merchandise(String judul, double harga) {
        super(judul, harga);
    }

    @Override
    public double hitungHarga() {
        return harga; 
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim merchandise: " + judul);
    }
}
