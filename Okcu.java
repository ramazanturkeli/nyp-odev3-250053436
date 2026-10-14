package toros;

public class Okcu extends Karakter {
    private int okSayisi;

    public Okcu(String ad, Lonca lonca) {
        super(ad, lonca);
        this.okSayisi = 30;
    }

    public int atesEt() {
        hayattaOldugunuDogrula();
        if (okSayisi <= 0) {
            throw new IllegalStateException("Ok kalmadı!");
        }
        okSayisi--;
        kayitYaz("Ok attı.");
        return super.saldir() + 3;
    }

    public void okTopla(int adet) {
        if (adet <= 0) {
            throw new IllegalArgumentException("Adet pozitif olmalıdır.");
        }
        hayattaOldugunuDogrula();
        okSayisi += adet;
        if (okSayisi > 60) {
            okSayisi = 60;
        }
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("  -> Ok Sayısı: " + okSayisi + "/60");
    }

    @Override
    public String toString() {
        return "Okcu [" + getAd() + ", seviye " + getSeviye() + ", ok " + okSayisi + "/60]";
    }
}