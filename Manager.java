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