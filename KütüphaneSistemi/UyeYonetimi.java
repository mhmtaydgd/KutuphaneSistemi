import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UyeYonetimi {

    private JFrame frame;
    public static Map<String, Uye> uyeListesi = new HashMap<>();

    public UyeYonetimi() {
        // Başlangıçta birkaç üye ekleyelim
        uyeListesi.put("1234", new Uye("Üye", "Adı1", "1234", "Üyeadı1@example.com"));
        uyeListesi.put("12345", new Uye("Üye", "Adı2", "12345", "Üyeadı2@example.com"));
    }

    public void yonetimEkrani() {
        // Üye yönetimi ekranı
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(6, 1));

        // Butonlar
        JButton btnYeniUyeEkle = new JButton("Yeni Üye Ekle");
        panel.add(btnYeniUyeEkle);

        JButton btnUyeleriListele = new JButton("Üyeleri Listeleme");
        panel.add(btnUyeleriListele);

        JButton btnUyeAra = new JButton("Üye Arama");
        panel.add(btnUyeAra);

        JButton btnUyeBilgileriniGuncelle = new JButton("Üye Bilgilerini Güncelle");
        panel.add(btnUyeBilgileriniGuncelle);

        JButton btnUyeSilme = new JButton("Üyelik Silme");
        panel.add(btnUyeSilme);

        JButton btnOduncGecmisiGoruntule = new JButton("Üyelerin Ödünç Geçmişini Görüntüleme");
        panel.add(btnOduncGecmisiGoruntule);

        // Buton işlevleri
        btnYeniUyeEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yeniUyeEkle();
            }
        });

        btnUyeleriListele.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uyeleriListele();
            }
        });

        btnUyeAra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uyeAra();
            }
        });

        btnUyeBilgileriniGuncelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uyeBilgileriniGuncelle();
            }
        });

        btnUyeSilme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uyeSil();
            }
        });

        btnOduncGecmisiGoruntule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oduncGecmisiGoruntule();
            }
        });

        frame.setVisible(true);
    }

    public void yeniUyeEkle() {
        String ad = JOptionPane.showInputDialog("Üye adını girin:");
        String soyad = JOptionPane.showInputDialog("Üye soyadını girin:");
        String uyeNo = JOptionPane.showInputDialog("Üye numarasını girin:");
        String email = JOptionPane.showInputDialog("Üye email adresini girin:");

        Uye uye = new Uye(ad, soyad, uyeNo, email);
        uyeListesi.put(uyeNo, uye);
        JOptionPane.showMessageDialog(null, "Yeni üye başarıyla eklendi.");
    }

    public void uyeleriListele() {
        StringBuilder uyeler = new StringBuilder();
        for (Uye uye : uyeListesi.values()) {
            uyeler.append(uye.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, uyeler.toString());
    }

    public void uyeAra() {
        String uyeNo = JOptionPane.showInputDialog("Aramak istediğiniz üyenin numarasını girin:");
        Uye uye = uyeListesi.get(uyeNo);
        if (uye != null) {
            JOptionPane.showMessageDialog(null, uye.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Üye bulunamadı.");
        }
    }

    public void uyeBilgileriniGuncelle() {
        String uyeNo = JOptionPane.showInputDialog("Güncellemek istediğiniz üyenin numarasını girin:");
        Uye uye = uyeListesi.get(uyeNo);

        if (uye != null) {
            String yeniAd = JOptionPane.showInputDialog("Yeni adı girin:", uye.getAd());
            String yeniSoyad = JOptionPane.showInputDialog("Yeni soyadı girin:", uye.getSoyad());
            String yeniEmail = JOptionPane.showInputDialog("Yeni email adresini girin:", uye.getEmail());

            uye.setAd(yeniAd);
            uye.setSoyad(yeniSoyad);
            uye.setEmail(yeniEmail);
            JOptionPane.showMessageDialog(null, "Üye bilgileri başarıyla güncellendi!");
        } else {
            JOptionPane.showMessageDialog(null, "Bu üye bulunamadı.");
        }
    }

    public void uyeSil() {
        String uyeNo = JOptionPane.showInputDialog("Silmek istediğiniz üyenin numarasını girin:");
        Uye uye = uyeListesi.remove(uyeNo);

        if (uye != null) {
            JOptionPane.showMessageDialog(null, "Üye başarıyla silindi.");
        } else {
            JOptionPane.showMessageDialog(null, "Bu üye bulunamadı.");
        }
    }

    public void oduncGecmisiGoruntule() {
        String uyeNo = JOptionPane.showInputDialog("Ödünç geçmişini görüntülemek istediğiniz üyenin numarasını girin:");
        Uye uye = uyeListesi.get(uyeNo);

        if (uye != null) {
            JOptionPane.showMessageDialog(null, "Ödünç geçmişi: " + uye.getOduncGecmisi());
        } else {
            JOptionPane.showMessageDialog(null, "Bu üye bulunamadı.");
        }
    }
}
