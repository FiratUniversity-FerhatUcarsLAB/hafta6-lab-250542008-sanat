/**
 * Ad Soyad:Mustafa
 * Numara:Şahingöz
 *Öğrenci No:250542008
 * Tarih: [13.11.2025]
 */

import java.util.Scanner;

public class NotSistemi {

    // 1. Ortalama hesaplama metodu
    public static double calculateAverage(double vize, double fin, double odev) {
        return (vize * 0.3) + (fin * 0.4) + (odev * 0.3);
    }

    // 2. Geçme durumu kontrol metodu
    public static boolean isPassingGrade(double ortalama) {
        return ortalama >= 50.0;
    }

    // 3. Harf notu belirleme metodu
    public static char getLetterGrade(double ort) {
        if (ort >= 90) return 'A';
        else if (ort >= 80) return 'B';
        else if (ort >= 70) return 'C';
        else if (ort >= 60) return 'D';
        else return 'F';
    }

    // 4. Onur listesi kontrol metodu
    public static boolean isHonorList(double ort, double vize, double fin, double odev) {
        return (ort >= 85 && vize >= 70 && fin >= 70 && odev >= 70);
    }

    // 5. Bütünleme hakkı kontrol metodu
    public static boolean hasRetakeRight(double ort) {
        return (ort >= 40 && ort < 50);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Vize notunu giriniz: ");
        double vize = input.nextDouble();

        System.out.print("Final notunu giriniz: ");
        double fin = input.nextDouble();

        System.out.print("Ödev notunu giriniz: ");
        double odev = input.nextDouble();

        double ort = calculateAverage(vize, fin, odev);

        System.out.println("\n=== ÖĞRENCİ NOT RAPORU ===");
        System.out.printf("Vize Notu   : %.1f%n", vize);
        System.out.printf("Final Notu  : %.1f%n", fin);
        System.out.printf("Ödev Notu   : %.1f%n", odev);
        System.out.println("------------------------------");
        System.out.printf("Ortalama    : %.1f%n", ort);
        System.out.printf("Harf Notu   : %c%n", getLetterGrade(ort));

        if (isPassingGrade(ort))
            System.out.println("Durum       : GEÇTİ");
        else
            System.out.println("Durum       : KALDI");

        System.out.print("Onur Listesi: ");
        System.out.println(isHonorList(ort, vize, fin, odev) ? "EVET" : "HAYIR");

        System.out.print("Bütünleme   : ");
        System.out.println(hasRetakeRight(ort) ? "VAR" : "YOK");
    }
}

