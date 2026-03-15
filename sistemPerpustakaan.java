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

    BookItem(String judulInput, int kodeInput, WriterData penulisInput, String kategoriInput) {
        judulBuku = judulInput;
        kodeBuku = kodeInput;
        dataPenulis = penulisInput;
        kategoriBuku = kategoriInput;
    }

    void tampilDataBuku() {
        System.out.println("Judul Buku : " + judulBuku);
        System.out.println("Kode Buku : " + kodeBuku);
        System.out.println("Penulis : " + dataPenulis.namaPenulis);
        System.out.println("Negara Penulis : " + dataPenulis.negaraAsal);
        System.out.println("Kategori : " + kategoriBuku);
        System.out.println("-----------------------------");
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

public class sistemPerpustakaan {
    public static void main(String[] args) {

        WriterData penulis1 = new WriterData("Penulis A", "Indonesia");
        WriterData penulis2 = new WriterData("Penulis B", "Indonesia");
        WriterData penulis3 = new WriterData("Penulis C", "Indonesia");
        WriterData penulis4 = new WriterData("Penulis D", "Indonesia");
        WriterData penulis5 = new WriterData("Penulis E", "Indonesia");

        CategoryShelf teknologi = new CategoryShelf("Teknologi");

        teknologi.tambahBuku(new BookItem("Buku Teknologi 1",101,penulis1,"Teknologi"));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 2",102,penulis1,"Teknologi"));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 3",103,penulis1,"Teknologi"));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 4",104,penulis1,"Teknologi"));
        teknologi.tambahBuku(new BookItem("Buku Teknologi 5",105,penulis1,"Teknologi"));

        CategoryShelf sejarah = new CategoryShelf("Sejarah");

        sejarah.tambahBuku(new BookItem("Buku Sejarah 1",201,penulis2,"Sejarah"));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 2",202,penulis2,"Sejarah"));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 3",203,penulis2,"Sejarah"));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 4",204,penulis2,"Sejarah"));
        sejarah.tambahBuku(new BookItem("Buku Sejarah 5",205,penulis2,"Sejarah"));

        CategoryShelf psikologi = new CategoryShelf("Psikologi");

        psikologi.tambahBuku(new BookItem("Buku Psikologi 1",301,penulis3,"Psikologi"));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 2",302,penulis3,"Psikologi"));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 3",303,penulis3,"Psikologi"));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 4",304,penulis3,"Psikologi"));
        psikologi.tambahBuku(new BookItem("Buku Psikologi 5",305,penulis3,"Psikologi"));

        CategoryShelf fiksi = new CategoryShelf("Fiksi");

        fiksi.tambahBuku(new BookItem("Buku Fiksi 1",401,penulis4,"Fiksi"));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 2",402,penulis4,"Fiksi"));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 3",403,penulis4,"Fiksi"));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 4",404,penulis4,"Fiksi"));
        fiksi.tambahBuku(new BookItem("Buku Fiksi 5",405,penulis4,"Fiksi"));

        CategoryShelf filsafat = new CategoryShelf("Filsafat");

        filsafat.tambahBuku(new BookItem("Buku Filsafat 1",501,penulis5,"Filsafat"));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 2",502,penulis5,"Filsafat"));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 3",503,penulis5,"Filsafat"));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 4",504,penulis5,"Filsafat"));
        filsafat.tambahBuku(new BookItem("Buku Filsafat 5",505,penulis5,"Filsafat"));

        teknologi.tampilKategori();
        sejarah.tampilKategori();
        psikologi.tampilKategori();
        fiksi.tampilKategori();
        filsafat.tampilKategori();
    }
}