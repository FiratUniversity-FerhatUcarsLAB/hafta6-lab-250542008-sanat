/**
 * Ad:Mustafa
 * Soyad:Şahingöz
 * Numara:250542008
 * Tarih:13.11.2025
 */












import java.util.Scanner;

public class SinemaBileti{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Gün (1=Pzt...7=Paz): ");
        int gun = in.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = in.nextInt();

        System.out.print("Yaş: ");
        int yas = in.nextInt();

        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        int meslek = in.nextInt();

        System.out.print("Film türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int tur = in.nextInt();

        // Temel fiyat
        boolean haftaSonu = (gun == 6 || gun == 7);
        boolean matine = (saat < 12);
        double fiyat;

        if (!haftaSonu && matine) fiyat = 45;
        else if (!haftaSonu) fiyat = 65;
        else if (haftaSonu && matine) fiyat = 55;
        else fiyat = 85;

        // İndirim
        double indirim = 0;
        if (meslek == 1) indirim = (haftaSonu ? 0.15 : 0.20);
        if (meslek == 2 && gun == 3) indirim = 0.35;
        if (yas >= 65) indirim = 0.30;
        if (yas < 12) indirim = 0.25;

        // Ekstra ücret
        double ekstra = 0;
        if (tur == 2) ekstra = 25;
        else if (tur == 3) ekstra = 35;
        else if (tur == 4) ekstra = 50;

        // Toplam
        double toplam = fiyat - (fiyat * indirim) + ekstra;

        System.out.println("\n=== BİLET BİLGİSİ ===");
        System.out.printf("Temel Fiyat : %.2f TL%n", fiyat);
        System.out.printf("İndirim     : %.0f%%%n", indirim * 100);
        System.out.printf("Ekstra Ücret: %.2f TL%n", ekstra);
        System.out.printf("Toplam      : %.2f TL%n", toplam);
    }
}
