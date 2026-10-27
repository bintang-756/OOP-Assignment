# Abstract Class & Interface

## Struktur
| File | Keterangan |
|------|-----------|
| `ProdukMusik.java` | **Abstract class**: atribut `judul` & `harga`, abstract method `hitungHarga()`, method biasa `tampilkanInfo()` |
| `DapatDiputar.java`, `DapatDikirim.java` | **Interface**: kontrak kemampuan tambahan |
| `AlbumDigital.java` | Subclass ProdukMusik + implements `DapatDiputar` (diskon 10%) |
| `Merchandise.java` | Subclass ProdukMusik + implements `DapatDikirim` |
| `PiringanHitam.java` | Subclass ProdukMusik + implements `DapatDiputar` & `DapatDikirim` |
| `Main.java` | Demo polymorphism |

## Konsep penting
- **Abstract class**: tidak bisa di-`new`; boleh punya method abstract dan method biasa; dipakai sebagai "induk" yang berbagi atribut & perilaku.
- **Abstract method**: method tanpa isi, wajib di-`@Override` subclass (`hitungHarga()`).
- **Interface**: hanya kontrak (apa yang bisa dilakukan); satu class bisa `implements` banyak interface.
- **Inheritance**: `extends` untuk mewarisi atribut/method parent (`AlbumDigital extends ProdukMusik`).
- **Polymorphism**: `ProdukMusik p = new PiringanHitam(...)`; saat `p.tampilkanInfo()` dipanggil, `hitungHarga()` yang dipakai adalah versi milik PiringanHitam.

## Cara menjalankan
```
javac *.java
java Main
```
