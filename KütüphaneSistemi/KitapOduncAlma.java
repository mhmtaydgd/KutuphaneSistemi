import javax.swing.*;
import java.util.Date;

public class KitapOduncAlma {

    private JFrame frame;

    public KitapOduncAlma() {
    }

    public void oduncAlmaEkrani() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField uyeNoField = new JTextField();
        uyeNoField.setText("Üye numarasını girin");
        panel.add(uyeNoField);

        JTextField isbnField = new JTextField();
        isbnField.setText("Kitap ISBN numarasını girin");
        panel.add(isbnField);

        JButton btnOduncAl = new JButton("Kitap Ödünç Al");
        panel.add(btnOduncAl);

        btnOduncAl.addActionListener(e -> {
            String uyeNo = uyeNoField.getText();
            String isbn = isbnField.getText();

            Uye uye = UyeYonetimi.uyeListesi.get(uyeNo);
            Kitap kitap = KitapYonetimi.kitapListesi.get(isbn);

            if (uye != null && kitap != null) {
                kitap.setDurum("Ödünç alındı");
                kitap.setOduncAlmaTarihi(new Date()); // Ödünç alma tarihini set ettik
                uye.setOduncGecmisi("Ödünç alınan kitap: " + kitap.getAd() + " (" + kitap.getIsbn() + ") - "
                        + kitap.getOduncAlmaTarihi());
                JOptionPane.showMessageDialog(frame, "Kitap başarıyla ödünç alındı!" + kitap.getOduncAlmaTarihi());
            } else {
                JOptionPane.showMessageDialog(frame, "Üye veya kitap bulunamadı.");
            }
        });

        frame.setVisible(true);
    }
}
