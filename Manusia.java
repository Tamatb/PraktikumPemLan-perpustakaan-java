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