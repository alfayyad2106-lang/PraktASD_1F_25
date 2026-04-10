public class mahasiswa {

    static class Mahasiswa {
        String nim;
        String nama;
        String prodi;

        Mahasiswa(String nim, String nama, String prodi) {
            this.nim = nim;
            this.nama = nama;
            this.prodi = prodi;
        }

        void tampilkan() {
            System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
        }
    }

    static class Buku {
        String kodeBuku;
        String judul;
        int tahunTerbit;

        Buku(String kodeBuku, String judul, int tahunTerbit) {
            this.kodeBuku = kodeBuku;
            this.judul = judul;
            this.tahunTerbit = tahunTerbit;
        }

        void tampilkan() {
            System.out.println("Kode: " + kodeBuku + " | Judul: " + judul + " | Tahun: " + tahunTerbit);
        }
    }

    static class Peminjaman {
        Mahasiswa mhs;
        Buku buku;
        int lamaPinjam;
        int terlambat;
        int denda;

        Peminjaman(Mahasiswa mhs, Buku buku, int lamaPinjam) {
            this.mhs = mhs;
            this.buku = buku;
            this.lamaPinjam = lamaPinjam;
            hitungDenda();
        }

        void hitungDenda() {
            if (lamaPinjam > 5) {
                terlambat = lamaPinjam - 5;
                denda = terlambat * 2000;
            } else {
                terlambat = 0;
                denda = 0;
            }
        }

        void tampilkan() {
            System.out.println(mhs.nama + " | " + buku.judul +
                    " | Lama: " + lamaPinjam +
                    " | Terlambat: " + terlambat +
                    " | Denda: " + denda);
        }
    }

    public static void main(String[] args) {
        Mahasiswa[] daftarMahasiswa = {
                new Mahasiswa("22001", "Andi", "Teknik Informatika"),
                new Mahasiswa("22002", "Budi", "Teknik Informatika"),
                new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        Buku[] daftarBuku = {
                new Buku("B001", "Algoritma", 2020),
                new Buku("B002", "Basis Data", 2019),
                new Buku("B003", "Pemrograman", 2021),
                new Buku("B004", "Fisika", 2024)
        };

        Peminjaman[] daftarPeminjaman = {
                new Peminjaman(daftarMahasiswa[0], daftarBuku[0], 7),
                new Peminjaman(daftarMahasiswa[1], daftarBuku[1], 3),
                new Peminjaman(daftarMahasiswa[2], daftarBuku[2], 10),
                new Peminjaman(daftarMahasiswa[2], daftarBuku[3], 6),
                new Peminjaman(daftarMahasiswa[0], daftarBuku[1], 4)
        };

        java.util.Scanner input = new java.util.Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            menu = input.nextInt();

            if (menu == 1) {
                System.out.println("\nDaftar Mahasiswa:");
                for (Mahasiswa m : daftarMahasiswa) {
                    m.tampilkan();
                }
            } 
            else if (menu == 2) {
                System.out.println("\nDaftar Buku:");
                for (Buku b : daftarBuku) {
                    b.tampilkan();
                }
            } 
            else if (menu == 3) {
                System.out.println("\nData Peminjaman:");
                for (Peminjaman p : daftarPeminjaman) {
                    p.tampilkan();
                }
            } 
            else if (menu == 4) {
                sortBerdasarkanDenda(daftarPeminjaman);
                System.out.println("\nData setelah diurutkan berdasarkan denda terbesar:");
                for (Peminjaman p : daftarPeminjaman) {
                    p.tampilkan();
                }
            } 
            else if (menu == 5) {
                System.out.print("Masukkan NIM: ");
                String cariNim = input.next();
                cariBerdasarkanNim(daftarPeminjaman, cariNim);
            } 
            else if (menu == 0) {
                System.out.println("Program selesai.");
            } 
            else {
                System.out.println("Menu tidak tersedia.");
            }

        } while (menu != 0);

        input.close();
    }

    static void sortBerdasarkanDenda(Peminjaman[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].denda > data[max].denda) {
                    max = j;
                }
            }

            Peminjaman temp = data[i];
            data[i] = data[max];
            data[max] = temp;
        }
    }

    static void cariBerdasarkanNim(Peminjaman[] data, String nim) {
        sortBerdasarkanNim(data);

        int kiri = 0;
        int kanan = data.length - 1;
        boolean ketemu = false;

        while (kiri <= kanan) {
            int tengah = (kiri + kanan) / 2;
            int hasil = data[tengah].mhs.nim.compareTo(nim);

            if (hasil == 0) {
                System.out.println("Data ditemukan:");
                data[tengah].tampilkan();
                ketemu = true;
                break;
            } else if (hasil < 0) {
                kiri = tengah + 1;
            } else {
                kanan = tengah - 1;
            }
        }

        if (!ketemu) {
            System.out.println("Data dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    static void sortBerdasarkanNim(Peminjaman[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].mhs.nim.compareTo(data[min].mhs.nim) < 0) {
                    min = j;
                }
            }

            Peminjaman temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }
}