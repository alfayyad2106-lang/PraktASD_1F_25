public class RoyalGarden {

    static int[][] stok = {
        {10, 5, 15, 7},
        {6, 11, 9, 12},
        {2, 10, 10, 5},
        {5, 7, 12, 9}
    };

    static int[] harga = {75000, 50000, 60000, 10000};

    public static void main(String[] args) {
        for (int i = 0; i < stok.length; i++) {
            int pendapatan = hitungPendapatan(i);
            System.out.println("Cabang " + (i + 1) + " = Rp " + pendapatan);

            if (pendapatan > 1500000) {
                System.out.println("Status: Sangat Baik\n");
            } else {
                System.out.println("Status: Perlu Evaluasi\n");
            }
        }
    }

    static int hitungPendapatan(int cabang) {
        int total = 0;
        for (int i = 0; i < stok[cabang].length; i++) {
            total += stok[cabang][i] * harga[i];
        }
        return total;
    }
}