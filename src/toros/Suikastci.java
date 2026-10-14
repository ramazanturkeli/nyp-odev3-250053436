package toros;

public class Suikastci extends Karakter {
    private boolean gizli;

    public Suikastci(String ad, Lonca lonca) {
        super(ad, lonca);
        this.gizli = false;
    }

    public void gizlen() {
        hayattaOldugunuDogrula();
        this.gizli = true;
        kayitYaz("gölgelere karıştı");
    }

    @Override
    public int saldir() {
        int temelHasar = super.saldir();
        if (gizli) {
            gizli = false; // Saldırı sonrası gizlilik bozulur
            return temelHasar * 2;
        }
        return temelHasar;
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("  -> Gizli Mi?: " + gizli);
    }

    @Override
    public String toString() {
        return "Suikastci [" + getAd() + ", seviye " + getSeviye() + ", gizli: " + gizli + "]";
    }
}
