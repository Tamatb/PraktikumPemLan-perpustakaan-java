import java.util.Scanner;

// Class untuk operasi matematika
class OperasiUnik {

    // static method
    static int tambahAngka(int x, int y) {
        return x + y;
    }

    static int kurangAngka(int x, int y) {
        return x - y;
    }

    // non-static method
    int kaliAngka(int x, int y) {
        return x * y;
    }

    double bagiAngka(int x, int y) {
        if (y == 0) {
            System.out.println("Tidak bisa dibagi 0!");
            return 0;
        }
        return (double) x / y;
    }

    // method menyederhanakan pecahan
    void sederhanaPecahan(int pembilang, int penyebut) {
        int a = pembilang;
        int b = penyebut;

        // mencari FPB
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int hasilPembilang = pembilang / a;
        int hasilPenyebut = penyebut / a;

        System.out.println("Hasil sederhana: " + hasilPembilang + "/" + hasilPenyebut);
    }
}

// Class untuk jaket
class JaketKeren {
    final int hargaA = 100000;
    final int hargaB = 125000;
    final int hargaC = 175000;

    int hitungTotalA(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 95000;
        }
        return jumlah * hargaA;
    }

    int hitungTotalB(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 120000;
        }
        return jumlah * hargaB;
    }

    int hitungTotalC(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 160000;
        }
        return jumlah * hargaC;
    }
}

// Main class
public class M2B5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        OperasiUnik op = new OperasiUnik();
        JaketKeren jaket = new JaketKeren();

        System.out.println("=== MENU ===");
        System.out.println("1. Operasi Matematika");
        System.out.println("2. Hitung Harga Jaket");
        System.out.print("Pilih menu: ");
        int pilih = input.nextInt();

        if (pilih == 1) {
            System.out.print("Masukkan angka pertama: ");
            int a = input.nextInt();
            System.out.print("Masukkan angka kedua: ");
            int b = input.nextInt();

            System.out.println("Penjumlahan: " + OperasiUnik.tambahAngka(a, b));
            System.out.println("Pengurangan: " + OperasiUnik.kurangAngka(a, b));
            System.out.println("Perkalian: " + op.kaliAngka(a, b));
            System.out.println("Pembagian: " + op.bagiAngka(a, b));

            System.out.print("Masukkan pembilang pecahan: ");
            int p = input.nextInt();
            System.out.print("Masukkan penyebut pecahan: ");
            int q = input.nextInt();

            op.sederhanaPecahan(p, q);

        } else if (pilih == 2) {
            System.out.print("Jumlah Jaket A: ");
            int a = input.nextInt();
            System.out.print("Jumlah Jaket B: ");
            int b = input.nextInt();
            System.out.print("Jumlah Jaket C: ");
            int c = input.nextInt();

            int totalA = jaket.hitungTotalA(a);
            int totalB = jaket.hitungTotalB(b);
            int totalC = jaket.hitungTotalC(c);

            int totalSemua = totalA + totalB + totalC;

            System.out.println("Total Harga A: Rp " + totalA);
            System.out.println("Total Harga B: Rp " + totalB);
            System.out.println("Total Harga C: Rp " + totalC);
            System.out.println("Total Keseluruhan: Rp " + totalSemua);
        }else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}