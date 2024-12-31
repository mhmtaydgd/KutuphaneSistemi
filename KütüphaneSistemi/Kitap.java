import java.util.Date;

public class Kitap {
    private String ad;
    private String yazar;
    private String isbn;
    private String durum; // "Mevcut" veya "Ödünç alındı"
    private Date oduncAlmaTarihi; // Ödünç alma tarihini tutacak

    public Kitap(String ad, String yazar, String isbn) {
        this.ad = ad;
        this.yazar = yazar;
        this.isbn = isbn;
        this.durum = "Mevcut";
        this.oduncAlmaTarihi = null;
    }

    public String getAd() {
        return ad;
    }

    public String getYazar() {
        return yazar;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public Date getOduncAlmaTarihi() {
        return oduncAlmaTarihi;
    }

    public void setOduncAlmaTarihi(Date oduncAlmaTarihi) {
        this.oduncAlmaTarihi = oduncAlmaTarihi;
    }

    @Override
    public String toString() {
        return "Kitap Adı: " + ad + ", Yazar: " + yazar + ", ISBN: " + isbn + ", Durum: " + durum
                + "Ödünç Alma Tarihi: "
                + (oduncAlmaTarihi != null ? oduncAlmaTarihi.toString() : "Henüz ödünç alınmadı");
    }
}
