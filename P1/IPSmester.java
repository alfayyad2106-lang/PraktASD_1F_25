import java.util.Scanner;

public class IPSmester {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Jumlah mata kuliah: ");
        int n = input.nextInt();
        input.nextLine();

        String[] mk = new String[n];
        int[] sks = new int[n];
        String[] nilai = new String[n];

        double total = 0;
        int totalSks = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nMata kuliah ke-" + (i + 1));
            System.out.print("Nama: ");
            mk[i] = input.nextLine();

            System.out.print("SKS: ");
            sks[i] = input.nextInt();
            input.nextLine();

            System.out.print("Nilai huruf: ");
            nilai[i] = input.nextLine();

            double bobot = konversiNilai(nilai[i]);

            total += bobot * sks[i];
            totalSks += sks[i];
        }

        double ip = total / totalSks;
        System.out.println("\nIP Semester: " + ip);
    }

    static double konversiNilai(String nilai) {
        switch (nilai.toUpperCase()) {
            case "A": return 4.0;
            case "B+": return 3.5;
            case "B": return 3.0;
            case "C+": return 2.5;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }
}