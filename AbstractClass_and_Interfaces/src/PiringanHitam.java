// Satu class boleh implements BANYAK interface
public class PiringanHitam extends ProdukMusik implements DapatDiputar, DapatDikirim {
    public PiringanHitam(String judul, double harga) {
        super(judul, harga);
    }

    @Override
    public double hitungHarga() {
        return harga + 25000; // tambahan biaya kemasan khusus
    }

    @Override
    public void putar() {
        System.out.println("Memutar piringan hitam di turntable: " + judul);
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim piringan hitam dengan packing aman: " + judul);
    }
}
