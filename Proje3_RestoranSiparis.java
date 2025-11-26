/**
* Ad Soyad: [Mustafa Şahingöz]
* Numara: [250542008]
* Proje: [Restoransiparis]
* Tarih: [26.11.2025]
*/



import java.util.Scanner;

public class SiparisSistemi {

    //  Ana Yemek 
    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    //  Başlangıç 
    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    //  İçecek Fiyatı
    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    // Tatlı Fiyatı
    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            default: return 0;
        }
    }

   
    public static boolean isComboOrder(double ana, double icecek, double tatli) {
        return ana > 0 && icecek > 0 && tatli > 0;
    }

    
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    
    public static double calculateDiscount(double toplam, boolean combo, boolean happy, boolean ogrenci, double icecek) {
        double ind = 0;

        if (combo) ind += toplam * 0.15;
        if (happy) ind += icecek * 0.20;
        if (toplam > 200) ind += toplam * 0.10;
        if (ogrenci) ind += toplam * 0.10;

        return ind;
    }

    
    public static double calculateServiceTip(double toplam) {
        return toplam * 0.10;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Ana Yemek (1-4, yoksa 0): ");
        int aY = input.nextInt();

        System.out.print("Başlangıç (1-3, yoksa 0): ");
        int bS = input.nextInt();

        System.out.print("İçecek (1-4, yoksa 0): ");
        int iC = input.nextInt();

        System.out.print("Tatlı (1-3, yoksa 0): ");
        int tT = input.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = input.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogr = input.next().toUpperCase().charAt(0);

        System.out.print("Gün (1-7): ");
        int gun = input.nextInt();

        // Fiyatlar
        double ana = getMainDishPrice(aY);
        double bas = getAppetizerPrice(bS);
        double ice = getDrinkPrice(iC);
        double tat = getDessertPrice(tT);

        double araToplam = ana + bas + ice + tat;

        boolean combo = isComboOrder(ana, ice, tat);
        boolean happy = isHappyHour(saat);
        boolean ogrenci = (ogr == 'E' && gun <= 5);

        double indirim = calculateDiscount(araToplam, combo, happy, ogrenci, ice);
        double toplam = araToplam - indirim;

        double bahsis = calculateServiceTip(toplam);

        System.out.println("\n=== SIPARIS OZETI ===");
        System.out.println("Ana Yemek: " + ana + " TL");
        System.out.println("Baslangic: " + bas + " TL");
        System.out.println("Icecek: " + ice + " TL");
        System.out.println("Tatli: " + tat + " TL");
        System.out.println("---------------------------");
        System.out.println("Ara Toplam: " + araToplam + " TL");
        System.out.println("Indirim: -" + indirim + " TL");
        System.out.println("Toplam: " + toplam + " TL");
        System.out.println("Bahsis Önerisi: " + bahsis + " TL");
    }
}


