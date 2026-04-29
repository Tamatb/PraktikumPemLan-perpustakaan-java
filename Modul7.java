// Kelas abstract
abstract class Kue {
    protected String nama;
    protected double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    // abstract method
    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama: " + nama + ", Harga: " + harga;
    }
}

// Subclass KuePesanan
class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    @Override
    public double hitungHarga() {
        return harga * berat;
    }

    public double getBerat() {
        return berat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Berat: " + berat + ", Jenis: KuePesanan";
    }
}

// Subclass KueJadi
class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    public double getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return super.toString() + ", Jumlah: " + jumlah + ", Jenis: KueJadi";
    }
}

// Main class
public class Modul7 {
    public static void main(String[] args) {

        Kue[] daftarKue = new Kue[20];

        // isi array (contoh campuran)
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                daftarKue[i] = new KuePesanan("KuePesanan" + i, 10000, i + 1);
            } else {
                daftarKue[i] = new KueJadi("KueJadi" + i, 5000, i + 2);
            }
        }

        double totalHarga = 0;
        double totalBerat = 0;
        double totalHargaPesanan = 0;
        double totalJumlah = 0;
        double totalHargaJadi = 0;

        Kue kueTermahal = daftarKue[0];

        for (Kue k : daftarKue) {
            System.out.println(k);

            double harga = k.hitungHarga();
            totalHarga += harga;

            if (k instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) k;
                totalBerat += kp.getBerat();
                totalHargaPesanan += harga;
            } else if (k instanceof KueJadi) {
                KueJadi kj = (KueJadi) k;
                totalJumlah += kj.getJumlah();
                totalHargaJadi += harga;
            }

            if (k.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = k;
            }
        }

        System.out.println("\nTotal Harga Semua Kue: " + totalHarga);
        System.out.println("Total Berat KuePesanan: " + totalBerat);
        System.out.println("Total Harga KuePesanan: " + totalHargaPesanan);
        System.out.println("Total Jumlah KueJadi: " + totalJumlah);
        System.out.println("Total Harga KueJadi: " + totalHargaJadi);
        System.out.println("\nKue dengan Harga Terbesar:");
        System.out.println(kueTermahal + " -> " + kueTermahal.hitungHarga());
    }
}