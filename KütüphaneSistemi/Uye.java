public class Uye {
    private String ad;
    private String soyad;
    private String uyeNo;
    private String email;
    private String oduncGecmisi;

    public Uye(String ad, String soyad, String uyeNo, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.uyeNo = uyeNo;
        this.email = email;
        this.oduncGecmisi = "";
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getUyeNo() {
        return uyeNo;
    }

    public void setUyeNo(String uyeNo) {
        this.uyeNo = uyeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOduncGecmisi() {
        return oduncGecmisi;
    }

    public void setOduncGecmisi(String oduncGecmisi) {
        this.oduncGecmisi = oduncGecmisi;
    }

    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Üye No: " + uyeNo + ", Email: " + email + ", Ödünç Geçmişi: "
                + oduncGecmisi;
    }
}
