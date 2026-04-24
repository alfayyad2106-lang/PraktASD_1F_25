import java.util.Scanner;

public class NilaiMahasiswa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double tugas, kuis, uts, uas;

        System.out.print("Masukkan nilai tugas: ");
        tugas = input.nextDouble();
        System.out.print("Masukkan nilai kuis: ");
        kuis = input.nextDouble();
        System.out.print("Masukkan nilai UTS: ");
        uts = input.nextDouble();
        System.out.print("Masukkan nilai UAS: ");
        uas = input.nextDouble();

        // Validasi
        if (tugas < 0 || tugas > 100 ||
            kuis < 0 || kuis > 100 ||
            uts < 0 || uts > 100 ||
            uas < 0 || uas > 100) {
            System.out.println("Nilai tidak valid");
            return;
        }

        double nilaiAkhir = (0.2 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.4 * uas);
        String huruf;
        String keterangan;

        // Konversi nilai
        if (nilaiAkhir >= 85) huruf = "A";
        else if (nilaiAkhir >= 80) huruf = "B+";
        else if (nilaiAkhir >= 75) huruf = "B";
        else if (nilaiAkhir >= 70) huruf = "C+";
        else if (nilaiAkhir >= 60) huruf = "C";
        else if (nilaiAkhir >= 50) huruf = "D";
        else huruf = "E";

        // Lulus / tidak
        if (huruf.equals("A") || huruf.equals("B+") || huruf.equals("B")
                || huruf.equals("C+") || huruf.equals("C")) {
            keterangan = "LULUS";
        } else {
            keterangan = "TIDAK LULUS";
        }

        System.out.println("Nilai akhir: " + nilaiAkhir);
        System.out.println("Nilai huruf: " + huruf);
        System.out.println("Keterangan: " + keterangan);
    }
}