import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TokoMusikFrame extends JFrame implements ActionListener {
    private FormPanel formPanel;
    private KeranjangPanel keranjangPanel;
    private JLabel lblTotal;
    private JButton btnTambah, btnBayar, btnReset;
    private int total = 0;

    public TokoMusikFrame() {
        setTitle("Toko Musik");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        formPanel = new FormPanel();
        keranjangPanel = new KeranjangPanel();

        add(formPanel, BorderLayout.NORTH);
        add(keranjangPanel, BorderLayout.CENTER);
        add(buatPanelBawah(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel buatPanelBawah() {
        JPanel panel = new JPanel(new BorderLayout());

        lblTotal = new JLabel("Total: Rp 0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        btnTambah = new JButton("Tambah");
        btnBayar = new JButton("Bayar");
        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        btnTambah.addActionListener(this);
        btnBayar.addActionListener(this);

        JPanel panelTombol = new JPanel(new FlowLayout());
        panelTombol.add(btnTambah);
        panelTombol.add(btnBayar);
        panelTombol.add(btnReset);

        panel.add(lblTotal, BorderLayout.NORTH);
        panel.add(panelTombol, BorderLayout.SOUTH);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sumber = e.getSource();

        if (sumber == btnTambah) {
            tambahKeranjang();
        } else if (sumber == btnBayar) {
            bayar();
        } else if (sumber == btnReset) {
            reset();
        }
    }

    private void tambahKeranjang() {
        try {
            int jumlah = formPanel.getJumlah();
            Produk produk = formPanel.getProdukDipilih();
            int subtotal = produk.getHarga() * jumlah;
            total += subtotal;

            keranjangPanel.tambahBaris(produk.getNama() + " x" + jumlah + " = Rp " + subtotal);
            lblTotal.setText("Total: Rp " + total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Jumlah harus angka lebih dari 0", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bayar() {
        if (total == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong");
            return;
        }
        JOptionPane.showMessageDialog(this, "Total bayar: Rp " + total + "\nTerima kasih!");
    }

    private void reset() {
    total = 0;
    keranjangPanel.kosongkan();
    lblTotal.setText("Total: Rp 0");
    }
}
