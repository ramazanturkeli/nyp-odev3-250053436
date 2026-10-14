package toros;

public class Buyucu extends Karakter {
    private int mana;

    public Buyucu(String ad, Lonca lonca) {
        super(ad, lonca);
        this.mana = 100;
    }

    public int buyuYap(String buyuAdi, int manaMaliyeti) {
        hayattaOldugunuDogrula();
        if (manaMaliyeti < 1 || manaMaliyeti > 50) {
            throw new IllegalArgumentException("Mana maliyeti 1 ile 50 arasında olmalıdır.");
        }
        if (mana < manaMaliyeti) {
            throw new IllegalStateException("Yetersiz mana!");
        }
        mana -= manaMaliyeti;
        kayitYaz(buyuAdi + " büyüsü yaptı.");
        return (manaMaliyeti * 2) + getSeviye();
    }

    public void manaTopla(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException("Miktar pozitif olmalıdır.");
        }
        hayattaOldugunuDogrula();
        mana += miktar;
        if (mana > 100) {
            mana = 100;
        }
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("  -> Mana: " + mana + "/100");
    }

    @Override
    public String toString() {
        return "Buyucu [" + getAd() + ", seviye " + getSeviye() + ", mana " + mana + "]";
    }
}