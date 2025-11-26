/**
* Ad Soyad: [Mustafa Şahingöz]
* Numara: [250542008]
* Proje: [SinemaBileti]
* Tarih: [26.11.2025]
*/


import java.util.Scanner;

public class SinemaBileti {

    // 1
    public static boolean isWeekend(int g) { return g == 6 || g == 7; }

    // 2
    public static boolean isMatinee(int s) { return s < 12; }

    // 3
    public static double calculateBasePrice(int g, int s) {
        if (!isWeekend(g) && isMatinee(s)) return 45;
        if (!isWeekend(g)) return 65;
        if (isMatinee(s)) return 55;
        return 85;
    }

    // 4
    public static double calculateDiscount(double base, int yas, int meslek, int gun) {
        if (yas >= 65) return base * 0.30;
        if (yas < 12) return base * 0.25;
        if (meslek == 1) return base * (gun <= 4 ? 0.20 : 0.15); // öğrenci
        if (meslek == 2 && gun == 3) return base * 0.35;         // öğretmen (Çarşamba)
        return 0;
    }

    // 5
    public static double getFormatExtra(int t) {
        if (t == 2) return 25;
        if (t == 3) return 35;
        if (t == 4) return 50;
        return 0;
    }

    // 6
    public static double calculateFinalPrice(double base, double disc, double extra) {
        double total = base - disc + extra;
        return total < 0 ? 0 : total;
    }

    // 7
    public static void generateTicketInfo(int g, int s, int yas, int meslek, int t,
                                          double base, double disc, double extra, double total) {
        System.out.println("\n--- BİLET ---");
        System.out.println("Gün: " + g + "  Saat: " + s + ":00");
        System.out.println("Yaş: " + yas + "  Meslek: " + (meslek==1?"Öğrenci":meslek==2?"Öğretmen":"Diğer"));
        System.out.println("Film: " + (t==1?"2D":t==2?"3D":t==3?"IMAX":"4DX"));
        System.out.printf("Temel: %.0f TL  İndirim: -%.0f TL  Ekstra: +%.0f TL\n", base, disc, extra);
        System.out.printf("TOPLAM: %.0f TL\n", total);
        System.out.println("-------------\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Gün (1=Pzt ... 7=Paz): ");
        int gun = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Yaş: ");
        int yas = sc.nextInt();

        System.out.print("Meslek (1=Öğrenci,2=Öğretmen,3=Diğer): ");
        int meslek = sc.nextInt();

        System.out.print("Film Türü (1=2D,2=3D,3=IMAX,4=4DX): ");
        int tur = sc.nextInt();

        double base = calculateBasePrice(gun, saat);
        double disc = calculateDiscount(base, yas, meslek, gun);
        double extra = getFormatExtra(tur);
        double total = calculateFinalPrice(base, disc, extra);

        generateTicketInfo(gun, saat, yas, meslek, tur, base, disc, extra, total);

        sc.close();
    }
}


