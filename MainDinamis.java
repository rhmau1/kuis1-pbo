import java.util.Locale;
import java.util.Scanner;

public class MainDinamis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US); // Tambahkan baris ini!
        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN KURSUS ===");
            System.out.println("1. Tambah Data Instruktur");
            System.out.println("2. Tambah Data Peserta");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = input.nextInt();
            input.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    // Input data Instruktur
                    System.out.println("\n--- Input Data Instruktur ---");
                    System.out.print("ID: ");
                    String idInstruktur = input.nextLine();
                    System.out.print("Nama: ");
                    String namaInstruktur = input.nextLine();
                    System.out.print("Email: ");
                    String emailInstruktur = input.nextLine();
                    System.out.print("Telepon: ");
                    String teleponInstruktur = input.nextLine();
                    System.out.print("Keahlian: ");
                    String keahlian = input.nextLine();
                    System.out.print("Rating (0.0 - 5.0): ");
                    double rating = input.nextDouble();
                    input.nextLine(); // consume newline

                    // Membuat objek Instruktur
                    Instruktur instruktur = new Instruktur(idInstruktur, namaInstruktur, 
                                                           emailInstruktur, teleponInstruktur, 
                                                           keahlian, rating);

                    // Menampilkan info Instruktur
                    System.out.println("\n--- Informasi Instruktur ---");
                    System.out.println(instruktur.getInfo());
                    
                    System.out.print("\nMasukkan nama kursus yang akan diajar: ");
                    String kursusInstruktur = input.nextLine();
                    instruktur.mengajar(kursusInstruktur);
                    break;

                case 2:
                    // Input data Peserta
                    System.out.println("\n--- Input Data Peserta ---");
                    System.out.print("ID: ");
                    String idPeserta = input.nextLine();
                    System.out.print("Nama: ");
                    String namaPeserta = input.nextLine();
                    System.out.print("Email: ");
                    String emailPeserta = input.nextLine();
                    System.out.print("Telepon: ");
                    String teleponPeserta = input.nextLine();
                    System.out.print("Tanggal Daftar (dd/mm/yyyy): ");
                    String tanggalDaftar = input.nextLine();
                    System.out.print("Status Aktif (true/false): ");
                    boolean statusAktif = input.nextBoolean();
                    input.nextLine(); // consume newline

                    // Membuat objek Peserta
                    Peserta peserta = new Peserta(idPeserta, namaPeserta, 
                                                   emailPeserta, teleponPeserta, 
                                                   tanggalDaftar, statusAktif);

                    // Menampilkan info Peserta
                    System.out.println("\n--- Informasi Peserta ---");
                    System.out.println(peserta.getInfo());
                    
                    System.out.print("\nMasukkan nama kursus yang akan diikuti: ");
                    String kursusPeserta = input.nextLine();
                    peserta.daftarKursus(kursusPeserta);
                    break;

                case 3:
                    System.out.println("\nTerima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } while (pilihan != 3);

        input.close();
    }
}