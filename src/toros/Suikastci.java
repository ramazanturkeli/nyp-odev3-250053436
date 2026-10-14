package toros;

public class Suikastci extends Karakter {
    private int gizlilikOrani;

    public Suikastci(String ad, int can, int guc, Silah silah, int gizlilikOrani) {
        super(ad, can, guc, silah);
        this.gizlilikOrani = gizlilikOrani;
    }

    @Override
    public void saldir() {
        System.out.println(getAd() + " gölgelerin arasından sessizce süzülüyor ve kritik darbe vuruyor! Gizlilik Oranı: %" + gizlilikOrani);
    }

    public int getGizlilikOrani() {
        return gizlilikOrani;
    }

    public void setGizlilikOrani(int gizlilikOrani) {
        this.gizlilikOrani = gizlilikOrani;
    }
}
