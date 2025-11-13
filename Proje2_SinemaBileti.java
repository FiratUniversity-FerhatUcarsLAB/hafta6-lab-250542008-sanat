/**
 * Ad Soyad: [Adınızı Soyadınızı yazın]
 * Öğrenci No:250542008
 * Tarih: [13.11.2025]
 */

import java.util.Scanner;

public class SinemaBileti {

    // 1. Hafta sonu mu?
    public static boolean isWeekend(int gun) {
        return (gun == 6 || gun == 7);
    }

    // 2. Matine mi?
    public static boolean isMatinee(int saat) {
        return (saat < 12);
    }

    // 3. Temel fiyat hesaplama
    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45.0;       // Hafta içi matine
        else if (!weekend) return 65.0;             // Hafta içi normal
        else if (weekend && matinee) return 55.0;   // Hafta sonu matine
        else return 85.0;                           // Hafta sonu normal
    }

    // 4. İndirim oranı hesaplama
    public static double calculateDiscount(int yas, int meslek, int gun) {
        boolean weekend = isWeekend(gun);
        double indirim = 0.0;

        // Öğrenci
        if (meslek == 1) {
            if (!weekend) indirim = 0.20; // Hafta içi %20
            else indirim = 0.15;          // Hafta sonu %15
        }

        // Öğretmen (sadece Çarşamba)
        if (meslek == 2 && gun == 3) {
            indirim = 0.35;
        }

        // 65+ yaş
        if (yas >= 65) {
            indirim = Math.max(indirim, 0.30); // Daha yüksekse 0.30’u uygula
        }

        // 12 yaş altı
        if (yas < 12) {
            indirim = Math.max(indirim, 0.25);
        }

        return indirim;
    }

    // 5. Film formatı ekstra ücret
    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25.0; // 3D
            case 3: return 35.0; // IMAX
            case 4: return 50.0; // 4DX
            default: return 0.0; // 2D
        }
    }

    // 6. Nihai fiyat hesaplama
