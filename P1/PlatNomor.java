import java.util.Scanner;

public class PlatNomor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] kode = {"B", "D", "L", "A", "F"};
        String[] kota = {"Jakarta", "Bandung", "Surabaya", "Banten", "Bogor"};

        System.out.print("Masukkan kode plat: ");
        String cari = input.nextLine().toUpperCase();

        boolean ditemukan = false;

        for (int i = 0; i < kode.length; i++) {
            if (kode[i].equals(cari)) {
                System.out.println("Kota: " + kota[i]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Kode tidak ditemukan");
        }
    }
}