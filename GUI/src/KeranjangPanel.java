import javax.swing.*;

public class KeranjangPanel extends JScrollPane {
    private JTextArea area;

    public KeranjangPanel() {
        area = new JTextArea();
        area.setEditable(false);
        setViewportView(area);
        setBorder(BorderFactory.createTitledBorder("Keranjang"));
    }

    public void tambahBaris(String teks) {
        area.append(teks + "\n");
    }

    public void kosongkan() {
        area.setText("");
    }

}
