import java.util.Scanner;

public class DeretBilangan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();

        int n = Integer.parseInt(nim.substring(nim.length() - 2));

    if (n < 10) {
        n += 10;
    }

    for (int i = 1; i <= n; i++) {
            if (i == 10 || i == 15) continue;

            if (i % 3 == 0) {
                System.out.print("# ");
            } else if (i % 2 == 0) {
                System.out.print(i + " ");
            } else {
                System.out.print("* ");
            }
        }
    }
}