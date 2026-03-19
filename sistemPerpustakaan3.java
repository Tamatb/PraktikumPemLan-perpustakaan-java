import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class WriterData {
    String namaPenulis;
    String negaraAsal;

    WriterData(String inputNama, String inputNegara) {
        namaPenulis = inputNama;
        negaraAsal = inputNegara;
    }
}

class BookItem {
    String judulBuku;
    int kodeBuku;
    WriterData dataPenulis;
    String kategoriBuku;

    String sinopsis;

    BookItem(String judulInput, int kodeInput, WriterData penulisInput, String kategoriInput) {
        judulBuku = judulInput;
        kodeBuku = kodeInput;
        dataPenulis = penulisInput;
        kategoriBuku = kategoriInput;
    }

    BookItem(String judulInput, int kodeInput, WriterData penulisInput, String kategoriInput, String sinopsisInput) {
        judulBuku = judulInput;
        kodeBuku = kodeInput;
        dataPenulis = penulisInput;
        kategoriBuku = kategoriInput;
        sinopsis = sinopsisInput;
    }

    void tampilDataBuku() {
        System.out.println("Judul Buku : " + judulBuku);
        System.out.println("Kode Buku : " + kodeBuku);
        System.out.println("Penulis : " + dataPenulis.namaPenulis);
        System.out.println("Negara Penulis : " + dataPenulis.negaraAsal);
        System.out.println("Kategori : " + kategoriBuku);
        System.out.println("Sinopsis : " + sinopsis);
        System.out.println("-----------------------------");
    }

    int hitungJumlahKata() {
        if (sinopsis == null) return 0;
        String[] kata = sinopsis.split(" ");
        return kata.length;
    }

    int cekKesamaan(BookItem bukuLain) {

        int sama = 0;
        int total = 4;

        if (judulBuku.equals(bukuLain.judulBuku)) sama++;
        if (kodeBuku == bukuLain.kodeBuku) sama++;
        if (kategoriBuku.equals(bukuLain.kategoriBuku)) sama++;
        if (dataPenulis.namaPenulis.equals(bukuLain.dataPenulis.namaPenulis)) sama++;

        return (sama * 100) / total;
    }

    BookItem copy() {
        return new BookItem(
                this.judulBuku,
                this.kodeBuku,
                this.dataPenulis,
                this.kategoriBuku,
                this.sinopsis
        );
    }

     void bacaFile(String pathFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            String data = reader.readLine();

            if (data != null) {
                String[] isi = data.split(",");

                judulBuku = isi[0];
                dataPenulis.namaPenulis = isi[1];
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan membaca file");
        }
    }

    void simpanFile(String namaFile) {
        try {
            FileWriter writer = new FileWriter(namaFile);

            writer.write(judulBuku + "," + dataPenulis.namaPenulis);

            writer.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan menyimpan file");
        }
    }

    double hitungRoyalti(double hargaBuku) {
        return hargaBuku * 0.10;
    }

    double hitungRoyalti(double hargaBuku, double persen) {
        return hargaBuku * persen / 100;
    }

}

class CategoryShelf {
    String namaKategori;
    ArrayList<BookItem> koleksiBuku = new ArrayList<>();

    CategoryShelf(String kategoriInput) {
        namaKategori = kategoriInput;
    }

    void tambahBuku(BookItem bukuBaru) {
        koleksiBuku.add(bukuBaru);
    }

    void tampilKategori() {
        System.out.println("Kategori : " + namaKategori);
        System.out.println("====================");

        for (BookItem buku : koleksiBuku) {
            buku.tampilDataBuku();
        }
    }
}

public class sistemPerpustakaan3 {
    public static void main(String[] args) {

        WriterData penulis1 = new WriterData("Penulis A", "Indonesia");
        WriterData penulis2 = new WriterData("Penulis B", "Indonesia");
        WriterData penulis3 = new WriterData("Penulis C", "Indonesia");
        WriterData penulis4 = new WriterData("Penulis D", "Indonesia");
        WriterData penulis5 = new WriterData("Penulis E", "Indonesia");

        String sinopsis = "Buku ini membahas berbagai konsep penting yang membantu pembaca memahami isi materi secara mendalam";

        CategoryShelf teknologi = new CategoryShelf("Teknologi");

        teknologi.tambahBuku(new BookItem("Buku Teknologi 1",101,penulis1,"Teknologi",sinopsis));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 2",102,penulis1,"Teknologi",sinopsis));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 3",103,penulis1,"Teknologi",sinopsis));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 4",104,penulis1,"Teknologi",sinopsis));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 5",105,penulis1,"Teknologi",sinopsis));

        CategoryShelf sejarah = new CategoryShelf("Sejarah");

        sejarah.tambahBuku(new BookItem("Buku Sejarah 1",201,penulis2,"Sejarah",sinopsis));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 2",202,penulis2,"Sejarah",sinopsis));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 3",203,penulis2,"Sejarah",sinopsis));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 4",204,penulis2,"Sejarah",sinopsis));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 5",205,penulis2,"Sejarah",sinopsis));

        CategoryShelf psikologi = new CategoryShelf("Psikologi");

        psikologi.tambahBuku(new BookItem("Buku Psikologi 1",301,penulis3,"Psikologi",sinopsis));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 2",302,penulis3,"Psikologi",sinopsis));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 3",303,penulis3,"Psikologi",sinopsis));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 4",304,penulis3,"Psikologi",sinopsis));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 5",305,penulis3,"Psikologi",sinopsis));

        CategoryShelf fiksi = new CategoryShelf("Fiksi");

        fiksi.tambahBuku(new BookItem("Buku Fiksi 1",401,penulis4,"Fiksi",sinopsis));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 2",402,penulis4,"Fiksi",sinopsis));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 3",403,penulis4,"Fiksi",sinopsis));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 4",404,penulis4,"Fiksi",sinopsis));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 5",405,penulis4,"Fiksi",sinopsis));

        CategoryShelf filsafat = new CategoryShelf("Filsafat");

        filsafat.tambahBuku(new BookItem("Buku Filsafat 1",501,penulis5,"Filsafat",sinopsis));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 2",502,penulis5,"Filsafat",sinopsis));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 3",503,penulis5,"Filsafat",sinopsis));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 4",504,penulis5,"Filsafat",sinopsis));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 5",505,penulis5,"Filsafat",sinopsis));

        CategoryShelf agama = new CategoryShelf("Agama");

        agama.tambahBuku(new BookItem("Buku Agama 1",601,penulis1,"Agama",sinopsis));
        agama.tambahBuku(new BookItem("Buku Agama 2",602,penulis1,"Agama",sinopsis));
        agama.tambahBuku(new BookItem("Buku Agama 3",603,penulis1,"Agama",sinopsis));
        agama.tambahBuku(new BookItem("Buku Agama 4",604,penulis1,"Agama",sinopsis));
        agama.tambahBuku(new BookItem("Buku Agama 5",605,penulis1,"Agama",sinopsis));

        CategoryShelf politik = new CategoryShelf("Politik");

        politik.tambahBuku(new BookItem("Buku Politik 1",701,penulis2,"Politik",sinopsis));
        politik.tambahBuku(new BookItem("Buku Politik 2",702,penulis2,"Politik",sinopsis));
        politik.tambahBuku(new BookItem("Buku Politik 3",703,penulis2,"Politik",sinopsis));
        politik.tambahBuku(new BookItem("Buku Politik 4",704,penulis2,"Politik",sinopsis));
        politik.tambahBuku(new BookItem("Buku Politik 5",705,penulis2,"Politik",sinopsis));

        teknologi.tampilKategori();
        sejarah.tampilKategori();
        psikologi.tampilKategori();
        fiksi.tampilKategori();
        filsafat.tampilKategori();
        agama.tampilKategori();
        politik.tampilKategori();

        double royalti1 = teknologi.koleksiBuku.get(0).hitungRoyalti(100000);
        System.out.println("Royalti 10% : " + royalti1);

        double royalti2 = teknologi.koleksiBuku.get(0).hitungRoyalti(100000, 15);
        System.out.println("Royalti 15% : " + royalti2);

        teknologi.koleksiBuku.get(0).simpanFile("dataBuku.txt");
        System.out.println("Data buku berhasil disimpan ke file");

        BookItem bukuTest = new BookItem("Kosong",0,penulis1,"Test");
        bukuTest.bacaFile("dataBuku.txt");
        System.out.println("Data yang dibaca dari file:");
        bukuTest.tampilDataBuku();

    }
}
