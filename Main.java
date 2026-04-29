import java.time.LocalDate;


public class Main {
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