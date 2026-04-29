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