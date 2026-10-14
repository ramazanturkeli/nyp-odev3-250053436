package toros;

public class Karakter {
    private final String ad;
    private int seviye;
    private int can;
    private final Lonca lonca;
    private Silah silah;

    public Karakter(String ad, Lonca lonca) {
        if (ad == null || ad.length() < 3 || ad.length() > 15) {
            throw new IllegalArgumentException("Karakter adı 3-15 karakter arasında olmalıdır.");
        }
        if (lonca == null) {
            throw new IllegalArgumentException("Karakterin bir loncası olmalıdır.");
        }
        this.ad = ad;
        this.lonca = lonca;
        this.seviye = 1;
        this.can = azamiCan();
        this.silah = null;
    }

    public final int azamiCan() {
        return 100 + (seviye * 10);
    }

    public final boolean hayattaMi() {
        return can > 0;
    }

    protected void hayattaOldugunuDogrula() {
        if (!hayattaMi()) {
            throw new IllegalStateException("Karakter hayatta değil!");
        }
    }

    protected void kayitYaz(String olay) {
        System.out.println("[" + ad + "] " + olay);
    }

    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Alınan hasar pozitif olmalıdır.");
        }
        can -= miktar;
        if (can < 0) {
            can = 0;
        }
    }

    public void iyiles(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("İyileşme miktarı pozitif olmalıdır.");
        }
        hayattaOldugunuDogrula();
        can += miktar;
        int sinir = azamiCan();
        if (can > sinir) {
            can = sinir;
        }
    }

    public void seviyeAtla() {
        if (seviye >= 50) {
            throw new IllegalStateException("Karakter maksimum seviyeye (50) ulaştı.");
        }
        seviye++;
        can = azamiCan();
    }

    public void silahKusan(Silah yeniSilah) {
        if (yeniSilah == null) {
            throw new IllegalArgumentException("Silah null olamaz.");
        }
        this.silah = yeniSilah;
    }

    public int saldir() {
        hayattaOldugunuDogrula();
        if (silah == null) {
            return 5 + seviye;
        } else {
            return silah.kullan() + seviye;
        }
    }

    public void bilgiGoster() {
        String silahBilgi = (silah == null) ? "yok" : silah.bilgiMetni();
        System.out.println(ad + " Seviye " + seviye + " | Can " + can + "/" + azamiCan() +
                " | Lonca: " + lonca.getAd() + " (" + lonca.getDuyuru() + ") | Silah: " + silahBilgi);
    }

    public String getAd() {
        return ad;
    }

    public int getSeviye() {
        return seviye;
    }

    public int getCan() {
        return can;
    }

    public Lonca getLonca() {
        return lonca;
    }

    public Silah getSilah() {
        return silah;
    }

    @Override
    public String toString() {
        return "Karakter [" + ad + ", seviye " + seviye + "]";
    }
}