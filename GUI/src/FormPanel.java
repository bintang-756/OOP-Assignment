import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel implements ActionListener {
    private Produk[] daftarProduk = {
        new Produk("Gitar Akustik", 850000),
        new Produk("Keyboard", 1850000),
        new Produk("Drum Elektrik", 6750000),
        new Produk("Ukulele", 458000),
        new Produk("Gitar Elektrik", 4500000),
        new Produk("Efek Gitar", 300000),
        new Produk("Bass", 3600000)
    };

    private JComboBox<String> cmbProduk;
    private JTextField txtJumlah;
    private JLabel lblHarga;

    public FormPanel() {
        setLayout(new GridLayout(3, 2, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Pilih Produk"));

        String[] namaProduk = new String[daftarProduk.length];
        for (int i = 0; i < daftarProduk.length; i++) {
            namaProduk[i] = daftarProduk[i].getNama();
        }

        cmbProduk = new JComboBox<>(namaProduk);
        txtJumlah = new JTextField("1");
        lblHarga = new JLabel("Rp " + daftarProduk[0].getHarga());

        cmbProduk.addActionListener(this);

        add(new JLabel("Produk"));
        add(cmbProduk);
        add(new JLabel("Harga"));
        add(lblHarga);
        add(new JLabel("Jumlah"));
        add(txtJumlah);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lblHarga.setText("Rp " + getProdukDipilih().getHarga());
    }

    public Produk getProdukDipilih() {
        return daftarProduk[cmbProduk.getSelectedIndex()];
    }

    public int getJumlah() {
        int jumlah = Integer.parseInt(txtJumlah.getText());
        if (jumlah <= 0) {
            throw new NumberFormatException();
        }
        return jumlah;
    }
}
