package toros;

public class Main {
    public static void main(String[] args) {
        // 1. İki lonca oluşturun
        Lonca kartalLoncası = new Lonca("Kartal Loncası", 1071, "Cuma akşamı kale kuşatması!");
        Lonca dagLoncası = new Lonca("Dağ Muhafızları", 1453, "Geçitler tutulsun!");

        // 2. Savaşçı, büyücü ve okçu oluşturun (Zırh = K % 31 -> 36 % 31 = 5)
        int savasciZirhi = 36 % 31; // 5
        Savasci demirSavasci = new Savasci("DemirBey", kartalLoncası, savasciZirhi);
        Buyucu yildizBuyucusu = new Buyucu("Alaca", kartalLoncası);
        Okcu karayelOkcusu = new Okcu("Bora", dagLoncası);

        // 3. Silahlar oluştur ve kuşandır (K 10'dan küçükse 10, K=36 olduğu için hasar 36)
        int kilicHasari = Math.max(36, 10);
        Silah celikKilic = new Silah("Kılıç", kilicHasari);
        Silah avciYayi = new Silah("Yay", 12);

        demirSavasci.silahKusan(celikKilic);
        karayelOkcusu.silahKusan(avciYayi);

        System.out.println("=== 4. Karakter Bilgileri ===");
        demirSavasci.bilgiGoster();
        yildizBuyucusu.bilgiGoster();
        karayelOkcusu.bilgiGoster();

        System.out.println("\n=== 5. Savaşçıyı Üç Kez Saldırt ===");
        for (int i = 1; i <= 3; i++) {
            int vurulanHasar = demirSavasci.saldir();
            System.out.println(i + ". Saldırı Hasarı: " + vurulanHasar +
                    " | Kılıç Dayanıklılığı: " + celikKilic.getDayaniklilik());
        }

        System.out.println("\n=== 6. Zırh Etkisini Göster (40'ar Hasar) ===");
        demirSavasci.hasarAl(40);
        yildizBuyucusu.hasarAl(40);
        System.out.println("DemirBey Can (Zırhlı, 40 hasar aldı -> 35 net): " + demirSavasci.getCan());
        System.out.println("Alaca Can (Zırhsız, 40 hasar aldı): " + yildizBuyucusu.getCan());

        System.out.println("\n=== 7. Büyücü Büyü İşlemleri ===");
        int ilkBuyuHasari = yildizBuyucusu.buyuYap("Ateş Topu", 30);
        System.out.println("1. Büyü Hasarı: " + ilkBuyuHasari);
        int ikinciBuyuHasari = yildizBuyucusu.buyuYap("Buz Dikeni", 30);
        System.out.println("2. Büyü Hasarı: " + ikinciBuyuHasari);
        try {
            yildizBuyucusu.buyuYap("Meteor", 50); // Mana yetersiz kalacak
        } catch (Exception hata) {
            System.out.println("Üçüncü Büyü Hatası (Beklenen): " + hata.getMessage());
        }

        System.out.println("\n=== 8. Okçuyu Ateş Ettir ===");
        System.out.println("Ok Atışı 1 Hasar: " + karayelOkcusu.atesEt());
        System.out.println("Ok Atışı 2 Hasar: " + karayelOkcusu.atesEt());

        System.out.println("\n=== 9. Büyücüyü İyileştir ve Seviye Atlat ===");
        yildizBuyucusu.iyiles(20);
        yildizBuyucusu.seviyeAtla();
        yildizBuyucusu.bilgiGoster();

        System.out.println("\n=== 10. Geçersiz İşlemler (Try-Catch) ===");
        try {
            new Karakter("Al", kartalLoncası); // Kısa isim
        } catch (Exception hata) {
            System.out.println("Hata 1: " + hata.getMessage());
        }

        try {
            demirSavasci.hasarAl(-5); // Negatif hasar
        } catch (Exception hata) {
            System.out.println("Hata 2: " + hata.getMessage());
        }

        try {
            yildizBuyucusu.iyiles(0); // 0 iyileşme
        } catch (Exception hata) {
            System.out.println("Hata 3: " + hata.getMessage());
        }

        System.out.println("\n=== 11. Lonca Duyurusu Değişimi ===");
        kartalLoncası.setDuyuru("Kale kuşatması cumartesi sabahına ertelendi!");
        demirSavasci.bilgiGoster();
        yildizBuyucusu.bilgiGoster();

        System.out.println("\n=== 12. toString() Testi ===");
        System.out.println(karayelOkcusu);
    }
}