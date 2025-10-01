public class MainStatis {
    public static void main(String[] args) {
        System.out.println("=== SISTEM MANAJEMEN KURSUS (DATA STATIS) ===\n");

        // Membuat objek Instruktur dengan data statis
        Instruktur instruktur1 = new Instruktur(
            "INS001",
            "Dr. Budi Santoso",
            "budi.santoso@email.com",
            "081234567890",
            "Pemrograman Java",
            4.8
        );

        Instruktur instruktur2 = new Instruktur(
            "INS002",
            "Prof. Siti Aminah",
            "siti.aminah@email.com",
            "082345678901",
            "Database Management",
            4.9
        );

        // Membuat objek Peserta dengan data statis
        Peserta peserta1 = new Peserta(
            "PES001",
            "Andi Wijaya",
            "andi.wijaya@email.com",
            "083456789012",
            "01/09/2024",
            true
        );

        Peserta peserta2 = new Peserta(
            "PES002",
            "Rina Kusuma",
            "rina.kusuma@email.com",
            "084567890123",
            "15/08/2024",
            true
        );

        Peserta peserta3 = new Peserta(
            "PES003",
            "Doni Pratama",
            "doni.pratama@email.com",
            "085678901234",
            "20/07/2024",
            false
        );

        // Menampilkan informasi Instruktur 1
        System.out.println("========== INSTRUKTUR 1 ==========");
        System.out.println(instruktur1.getInfo());
        System.out.println();
        instruktur1.mengajar("Java OOP Fundamentals");
        System.out.println();

        // Menampilkan informasi Instruktur 2
        System.out.println("========== INSTRUKTUR 2 ==========");
        System.out.println(instruktur2.getInfo());
        System.out.println();
        instruktur2.mengajar("Advanced SQL & Database Design");
        System.out.println();

        // Menampilkan informasi Peserta 1
        System.out.println("========== PESERTA 1 ==========");
        System.out.println(peserta1.getInfo());
        System.out.println();
        peserta1.daftarKursus("Java OOP Fundamentals");
        System.out.println();

        // Menampilkan informasi Peserta 2
        System.out.println("========== PESERTA 2 ==========");
        System.out.println(peserta2.getInfo());
        System.out.println();
        peserta2.daftarKursus("Advanced SQL & Database Design");
        System.out.println();

        // Menampilkan informasi Peserta 3 (tidak aktif)
        System.out.println("========== PESERTA 3 ==========");
        System.out.println(peserta3.getInfo());
        System.out.println();
        peserta3.daftarKursus("Java OOP Fundamentals");
        System.out.println();

        // Demonstrasi setter methods
        System.out.println("========== DEMONSTRASI UPDATE DATA ==========");
        System.out.println("Mengupdate rating Instruktur 1...");
        instruktur1.setRating(5.0);
        System.out.println("Rating baru: " + instruktur1.getRating());
        System.out.println();

        System.out.println("Mengaktifkan status Peserta 3...");
        peserta3.setStatus(true);
        System.out.println("Status baru: " + (peserta3.isStatusAktif() ? "Aktif" : "Tidak Aktif"));
        peserta3.daftarKursus("Database Management");
    }
}