/**
 * Ad:Mustafa
 * Soyad:Şahingöz
 * Öğrenci No:250542008
 * Tarih:13.11.2025
 */






import java.util.Scanner;

public class RestoranSiparis{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Menü seçimleri
        System.out.println("=== AKILLI RESTORAN SİPARİŞ SİSTEMİ ===");

        System.out.println("Ana Yemekler: 1) Izgara Tavuk (85)  2) Adana Kebap (120)  3) Levrek (110)  4) Mantı (65)");
        System.out.print("Ana yemek seç (0=Yok): ");
        int ana = in.nextInt();

        System.out.println("Başlangıçlar: 1) Çorba (25)  2) Humus (45)  3) Sigara Böreği (55)");
        System.out.print("Başlangıç seç (0=Yok): ");
        int bas = in.nextInt();

        System.out.println("İçecekler: 1) Kola (15)  2) Ayran (12)  3) Meyve Suyu (35)  4) Limonata (25)");
        System.out.print("İçecek seç (0=Yok): ");
        int icecek = in.nextInt();

        System.out.println("Tatlılar: 1) Künefe (65)  2) Baklava (55)  3) Sütlaç (35)");
        System.out.print("Tatlı seç (0=Yok): ");
        int tatli = in.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = in.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogr = in.next().toUpperCase().charAt(0);

        System.out.print("Gün (1=Pzt...7=Paz): ");
        int gun = in.nextInt();

        // Fiyat hesaplama
        double toplam = 0;

        // Ana yemek fiyatı
        switch (ana) {
            case 1 -> toplam += 85;
            case 2 -> toplam += 120;
            case 3 -> toplam += 110;
            case 4 -> toplam += 65;
        }

        switch (bas) {
            case 1 -> toplam += 25;
            case 2 -> toplam += 45;
            case 3 -> toplam += 55;
        }

        switch (icecek) {
            case 1 -> toplam += 15;
            case 2 -> toplam += 12;
            case 3 -> toplam += 35;
            case 4 -> toplam += 25;
        }

        switch (tatli) {
            case 1 -> toplam += 65;
            case 2 -> toplam += 55;
            case 3 -> toplam += 35;
        }

        // İndirim kontrolü
        boolean combo = (ana > 0 && icecek > 0 && tatli > 0);
        boolean happyHour = (saat >= 14 && saat <= 17);
        boolean ogrenci = (ogr == 'E');
        boolean haftaIci = (gun >= 1 && gun <= 5);

        double indirim = 0;

        if (combo) indirim += 0.15;
        if (ogrenci && haftaIci) indirim += 0.10;
        if (toplam > 200) indirim += 0.10;

        // Happy hour → içecek indirimi (%20)
        if (happyHour && icecek > 0) {
            // içecek fiyatını çıkarıp %20 indirimli ekleyelim
            double icecekFiyat = switch (icecek) {
                case 1 -> 15;
                case 2 -> 12;
                case 3 -> 35;
                case 4 -> 25;
                default -> 0;
            };
            toplam -= icecekFiyat * 0.20;
        }

        double indirimliToplam = toplam * (1 - indirim);
        double bahsis = indirimliToplam * 0.10;

        // Çıktı
        System.out.println("\n=== HESAP ÖZETİ ===");
        System.out.printf("Ara Toplam   : %.2f TL%n", toplam);
        System.out.printf("Toplam İndirim: %.0f%%%n", indirim * 100);
        System.out.printf("İndirimli Toplam: %.2f TL%n", indirimliToplam);
        System.out.printf("Bahşiş (%%10) : %.2f TL%n", bahsis);
        System.out.printf("Ödenecek Toplam: %.2f TL%n", indirimliToplam + bahsis);
    }
}
