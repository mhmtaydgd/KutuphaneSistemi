import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class KitapYonetimi {

    private JFrame frame;
    public static Map<String, Kitap> kitapListesi = new HashMap<>();

    public KitapYonetimi() {
        // Başlangıçta birkaç kitap ekleyelim
        kitapListesi.put("1234", new Kitap("Kitap Adı1", "Yazar Adı1", "1234"));
        kitapListesi.put("12345", new Kitap("Kitap Adı2", "Yazar Adı2", "12345"));
    }

    public void yonetimEkrani() {
        // Kitap yönetimi ekranı
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(6, 1));

        // Butonlar
        JButton btnYeniKitapEkle = new JButton("Yeni Kitap Ekle");
        panel.add(btnYeniKitapEkle);

        JButton btnKitaplariListele = new JButton("Kitapları Listeleme");
        panel.add(btnKitaplariListele);

        JButton btnKitapArama = new JButton("Kitap Arama");
        panel.add(btnKitapArama);

        JButton btnKitapSilme = new JButton("Kitap Silme");
        panel.add(btnKitapSilme);

        JButton btnKitapDurumunuGuncelle = new JButton("Kitap Durumunu Güncelle");
        panel.add(btnKitapDurumunuGuncelle);

        JButton btnMevcutKitapKontrolu = new JButton("Mevcut Kitap Kontrolü");
        panel.add(btnMevcutKitapKontrolu);

        // Buton işlevleri
        btnYeniKitapEkle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yeniKitapEkle();
            }
        });

        btnKitaplariListele.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kitaplariListele();
            }
        });

        btnKitapArama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kitapArama();
            }
        });

        btnKitapSilme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kitapSil();
            }
        });

        btnKitapDurumunuGuncelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kitapDurumunuGuncelle();
            }
        });

        btnMevcutKitapKontrolu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mevcutKitapKontrolu();
            }
        });

        frame.setVisible(true);
    }

    public void yeniKitapEkle() {
        String ad = JOptionPane.showInputDialog("Kitap adı:");
        String yazar = JOptionPane.showInputDialog("Kitap yazarı:");
        String isbn = JOptionPane.showInputDialog("ISBN numarası:");

        Kitap kitap = new Kitap(ad, yazar, isbn);
        kitapListesi.put(isbn, kitap);
        JOptionPane.showMessageDialog(null, "Yeni kitap başarıyla eklendi.");
    }

    public void kitaplariListele() {
        StringBuilder kitaplar = new StringBuilder();
        for (Kitap kitap : kitapListesi.values()) {
            kitaplar.append(kitap.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, kitaplar.toString());
    }

    public void kitapArama() {
        String isbn = JOptionPane.showInputDialog("Aramak istediğiniz kitabın ISBN numarasını girin:");
        Kitap kitap = kitapListesi.get(isbn);
        if (kitap != null) {
            JOptionPane.showMessageDialog(null, kitap.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Kitap bulunamadı.");
        }
    }

    public void kitapSil() {
        String isbn = JOptionPane.showInputDialog("Silmek istediğiniz kitabın ISBN numarasını girin:");
        Kitap kitap = kitapListesi.remove(isbn);
        if (kitap != null) {
            JOptionPane.showMessageDialog(null, "Kitap başarıyla silindi.");
        } else {
            JOptionPane.showMessageDialog(null, "Kitap bulunamadı.");
        }
    }

    public void kitapDurumunuGuncelle() {
        String isbn = JOptionPane.showInputDialog("Durumunu güncellemek istediğiniz kitabın ISBN numarasını girin:");
        Kitap kitap = kitapListesi.get(isbn);
        if (kitap != null) {
            String durum = JOptionPane.showInputDialog("Yeni durumu girin (Ödünç alındı / Mevcut):");
            kitap.setDurum(durum);
            JOptionPane.showMessageDialog(null, "Kitap durumu güncellendi.");
        } else {
            JOptionPane.showMessageDialog(null, "Kitap bulunamadı.");
        }
    }

    public void mevcutKitapKontrolu() {
        String isbn = JOptionPane.showInputDialog("Kontrol etmek istediğiniz kitabın ISBN numarasını girin:");
        Kitap kitap = kitapListesi.get(isbn);
        if (kitap != null) {
            JOptionPane.showMessageDialog(null, "Kitap mevcut: " + kitap.getDurum());
        } else {
            JOptionPane.showMessageDialog(null, "Kitap bulunamadı.");
        }
    }
}
