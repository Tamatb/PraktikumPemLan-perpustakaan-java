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