import java.time.LocalDate;
import java.time.Period;

class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jk, String nik, boolean menikah,
                   double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jk, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = Period.between(tahunMasuk, LocalDate.now()).getYears();

        if (lamaKerja <= 5) return 0.05 * gaji;
        else if (lamaKerja <= 10) return 0.10 * gaji;
        else return 0.15 * gaji;
    }

    public double getGaji() {
        return gaji + getBonus() + (jumlahAnak * 20);
    }

    public double getPendapatan() {
        return super.getTunjangan() + getGaji();
    }

    public String toString() {
        return super.toString() +
               "Tahun Masuk: " + tahunMasuk +
               "\nJumlah Anak: " + jumlahAnak +
               "\nTotal Gaji: " + getGaji() + "\n";
    }
}

class Manusia {
    private String nama;
    private boolean jenisKelamin; // true: laki-laki, false: perempuan
    private String nik;
    private boolean menikah;

    // Constructor
    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }

    // Getter Setter
    public String getNama() { return nama; }
    public boolean isJenisKelamin() { return jenisKelamin; }
    public String getNik() { return nik; }
    public boolean isMenikah() { return menikah; }

    public double getTunjangan() {
        if (menikah) {
            if (jenisKelamin) return 25; // laki-laki
            else return 20; // perempuan
        }
        return 15;
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    public String toString() {
        return "Nama: " + nama +
               "\nNIK: " + nik +
               "\nJenis Kelamin: " + (jenisKelamin ? "Laki-laki" : "Perempuan") +
               "\nPendapatan: " + getPendapatan() + "\n";
    }
}

class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, boolean jk, String nik, boolean menikah,
                   double gaji, java.time.LocalDate tahunMasuk, int jumlahAnak,
                   String departemen) {
        super(nama, jk, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    public double getGaji() {
        return super.getGaji() + (0.10 * super.getGaji());
    }

    public String toString() {
        return super.toString() +
               "Departemen: " + departemen + "\n";
    }
}

class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, boolean jk, String nik, boolean menikah,
                           String nim, double ipk) {
        super(nama, jk, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public double getBeasiswa() {
        if (ipk >= 3.5) return 75;
        else if (ipk >= 3.0) return 50;
        return 0;
    }

    public String getStatus() {
        String angkatan = "20" + nim.substring(0, 2);
        char kode = nim.charAt(6);

        String prodi = "";
        switch (kode) {
            case '2': prodi = "Teknik Informatika"; break;
            case '3': prodi = "Teknik Komputer"; break;
            case '4': prodi = "Sistem Informasi"; break;
            case '6': prodi = "Pendidikan Teknologi Informasi"; break;
            case '7': prodi = "Teknologi Informasi"; break;
        }

        return prodi + ", " + angkatan;
    }

    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }

    public String toString() {
        return super.toString() +
               "NIM: " + nim +
               "\nIPK: " + ipk +
               "\nStatus: " + getStatus() +
               "\nPendapatan: " + getPendapatan() + "\n";
    }
}



public class Modul6 {
    public static void main(String[] args) {
 
        // 1. Manusia
        System.out.println(new Manusia("Budi", true, "111", true));
        System.out.println(new Manusia("Siti", false, "222", true));
        System.out.println(new Manusia("Joko", true, "333", false));

        // 2. Mahasiswa
        System.out.println(new MahasiswaFILKOM("Andi", true, "444", false,
                "165150601111111", 2.9));
        System.out.println(new MahasiswaFILKOM("Rina", false, "555", false,
                "165150401111111", 3.2));
        System.out.println(new MahasiswaFILKOM("Dewi", false, "666", false,
                "165150701111111", 3.8));

        // 3. Pekerja
        System.out.println(new Pekerja("Anton", true, "777", true,
                3000, LocalDate.now().minusYears(2), 2));
        System.out.println(new Pekerja("Bambang", true, "888", true,
                4000, LocalDate.now().minusYears(9), 0));
        System.out.println(new Pekerja("Citra", false, "999", true,
                5000, LocalDate.now().minusYears(20), 10));

        // 4. Manager
        System.out.println(new Manager("Doni", true, "1010", true,
                7500, LocalDate.now().minusYears(15), 3, "IT"));
    }
}
