public class Main {
    public static void main(String[] args) {

        ProdukMusik[] daftar = {
            new AlbumDigital("Album Senja", 50000),
            new PiringanHitam("Vinyl Langit Malam", 300000),
            new Merchandise("Kaos Band Nada", 120000)
        };

        for (ProdukMusik p : daftar) {
            System.out.println("[" + p.getClass().getSimpleName() + "]");
            p.tampilkanInfo(); // hitungHarga() 

            if (p instanceof DapatDiputar) {
                ((DapatDiputar) p).putar();
            }
            if (p instanceof DapatDikirim) {
                ((DapatDikirim) p).kirim();
            }
            System.out.println("---");
        }

        DapatDiputar pemutar = new AlbumDigital("Album Pagi", 60000);
        pemutar.putar();
    }
}
