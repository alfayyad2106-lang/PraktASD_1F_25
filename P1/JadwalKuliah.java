import java.util.Scanner;

public class JadwalKuliah {

    static String[][] jadwal;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Jumlah jadwal: ");
        int n = input.nextInt();
        input.nextLine();

        jadwal = new String[n][4];

        inputData(n, input);
        tampilkan(n);
        cariHari(n, input);
        cariMK(n, input);
    }

    static void inputData(int n, Scanner input) {
        for (int i = 0; i < n; i++) {
            System.out.println("\nJadwal ke-" + (i + 1));
            System.out.print("Mata Kuliah: ");
            jadwal[i][0] = input.nextLine();

            System.out.print("Ruang: ");
            jadwal[i][1] = input.nextLine();

            System.out.print("Hari: ");
            jadwal[i][2] = input.nextLine();

            System.out.print("Jam: ");
            jadwal[i][3] = input.nextLine();
        }
    }

    static void tampilkan(int n) {
        System.out.println("\n=== Jadwal Kuliah ===");
        for (int i = 0; i < n; i++) {
            System.out.println(jadwal[i][0] + " | " + jadwal[i][1] + " | "
                    + jadwal[i][2] + " | " + jadwal[i][3]);
        }
    }

    static void cariHari(int n, Scanner input) {
        System.out.print("\nCari berdasarkan hari: ");
        String hari = input.nextLine();

        for (int i = 0; i < n; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hari)) {
                System.out.println(jadwal[i][0] + " - " + jadwal[i][3]);
            }
        }
    }

    static void cariMK(int n, Scanner input) {
        System.out.print("\nCari mata kuliah: ");
        String mk = input.nextLine();

        for (int i = 0; i < n; i++) {
            if (jadwal[i][0].equalsIgnoreCase(mk)) {
                System.out.println(jadwal[i][2] + " - " + jadwal[i][3]);
            }
        }
    }
}