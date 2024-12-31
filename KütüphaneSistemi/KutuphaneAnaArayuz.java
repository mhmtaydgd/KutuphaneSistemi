import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KutuphaneAnaArayuz {
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                KutuphaneAnaArayuz window = new KutuphaneAnaArayuz();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor
    public KutuphaneAnaArayuz() {
        initialize();
    }

    private void initialize() {
        // Frame setup
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel setup
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 1));

        // Buttons setup
        JButton btnKitapYonetimi = new JButton("Kitap Yönetimi");
        panel.add(btnKitapYonetimi);

        JButton btnUyeYonetimi = new JButton("Üye Yönetimi");
        panel.add(btnUyeYonetimi);

        JButton btnKitapOduncAlma = new JButton("Kitap Ödünç Alma");
        panel.add(btnKitapOduncAlma);

        // Kitap Yönetimi butonuna tıklanınca
        btnKitapYonetimi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KitapYonetimi kitapYonetimi = new KitapYonetimi();
                kitapYonetimi.yonetimEkrani();
            }
        });

        // Üye Yönetimi butonuna tıklanınca
        btnUyeYonetimi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UyeYonetimi uyeYonetimi = new UyeYonetimi();
                uyeYonetimi.yonetimEkrani();
            }
        });

        // Kitap Ödünç Alma butonuna tıklanınca
        btnKitapOduncAlma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KitapOduncAlma kitapOduncAlma = new KitapOduncAlma();
                kitapOduncAlma.oduncAlmaEkrani();
            }
        });
    }
}
