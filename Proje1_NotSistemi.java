
/**
* Ad Soyad: [Mustafa Şahingöz]
* Numara: [250542008]
* Proje: [NotSistemi]
* Tarih: [25.11.2025]
*/



import java.util.Scanner;

public class NotSistemi {

    // Ortalama hesaplama metodu
    public static double calculateAverage(double vize, double fin, double odev) {
        return (vize * 0.30) + (fin * 0.40) + (odev * 0.30);
    }

    //Geçti/Kaldı kontrol metodu
    public static String isPassingGrade(double avg) {
        return (avg >= 50) ? "GECTI" : "KALDI";
    }

    // 3) Harf notu hesaplama metodu
    public static String getLetterGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
    public static String isHonorList(double avg, double vize, double fin, double odev) {

        if (avg >= 85 && vize >= 70 && fin >= 70 && odev >= 70) {
            return "EVET";
        }
        return "HAYIR";
    }

    //Bütünleme hakkı metodu
    public static String hasRetakeRight(double avg) {

        // 40 ≤ ort < 50 → bütünleme var
        if (avg >= 40 && avg < 50) return "VAR";
        return "YOK";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Vize: ");
        double vize = input.nextDouble();

        System.out.print("Final: ");
        double fin = input.nextDouble();

        System.out.print("Odev: ");
        double odev = input.nextDouble();

        double avg = calculateAverage(vize, fin, odev);
        String letter = getLetterGrade(avg);
        String pass = isPassingGrade(avg);
        String honor = isHonorList(avg, vize, fin, odev);
        String retake = hasRetakeRight(avg);

        System.out.println("\n=== OGRENCI NOT RAPORU ===");
        System.out.println("Vize Notu : " + vize);
        System.out.println("Final Notu : " + fin);
        System.out.println("Odev Notu : " + odev);
        System.out.println("------------------------------");
        System.out.printf("Ortalama : %.1f\n", avg);
        System.out.println("Harf Notu : " + letter);
        System.out.println("Durum : " + pass);
        System.out.println("Onur Listesi : " + honor);
        System.out.println("Butunleme : " + retake);
    }
}

