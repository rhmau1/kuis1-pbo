import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MainDinamis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        ArrayList<Instruktur> daftarInstruktur = new ArrayList<>();
        ArrayList<Peserta> daftarPeserta = new ArrayList<>();
        ArrayList<Artikel> daftarArtikel = new ArrayList<>();
        ArrayList<Video> daftarVideo = new ArrayList<>();
        ArrayList<KuisPilgan> daftarKuisPilgan = new ArrayList<>();
        ArrayList<KuisEsai> daftarKuisEsai = new ArrayList<>();
        ArrayList<Kursus> daftarKursus = new ArrayList<>();

        int menuUtama;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN KURSUS ===");
            System.out.println("1. Instruktur");
            System.out.println("2. Peserta");
            System.out.println("3. Kursus");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu utama: ");
            menuUtama = input.nextInt();
            input.nextLine();

            switch (menuUtama) {
                case 1: // Instruktur
                    int menuInstruktur;
                    do {
                        System.out.println("\n--- Menu Instruktur ---");
                        System.out.println("1. Buat Data Instruktur");
                        System.out.println("2. Tampilkan Data Instruktur");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih menu: ");
                        menuInstruktur = input.nextInt();
                        input.nextLine();

                        switch (menuInstruktur) {
                            case 1:
                                // Buat Instruktur
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
                                input.nextLine();

                                Instruktur instruktur = new Instruktur(idInstruktur, namaInstruktur,
                                        emailInstruktur, teleponInstruktur,
                                        keahlian, rating);

                                System.out.print("\nMasukkan nama kursus yang akan diajar: ");
                                String kursusInstruktur = input.nextLine();
                                instruktur.mengajar(kursusInstruktur);

                                daftarInstruktur.add(instruktur);
                                System.out.println("Instruktur berhasil dibuat!");
                                break;
                            case 2:
                                // Tampilkan Instruktur
                                System.out.println("\n--- Daftar Instruktur ---");
                                if (daftarInstruktur.isEmpty()) {
                                    System.out.println("Belum ada data instruktur.");
                                } else {
                                    for (Instruktur i : daftarInstruktur) {
                                        System.out.println(i.getInfo());
                                    }
                                }
                                break;
                            case 3:
                                // Kembali
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                        }
                    } while (menuInstruktur != 3);
                    break;

                case 2: // Peserta
                    int menuPeserta;
                    do {
                        System.out.println("\n--- Menu Peserta ---");
                        System.out.println("1. Buat Data Peserta");
                        System.out.println("2. Tampilkan Data Peserta");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih menu: ");
                        menuPeserta = input.nextInt();
                        input.nextLine();

                        switch (menuPeserta) {
                            case 1:
                                // Buat Peserta
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
                                input.nextLine();

                                Peserta peserta = new Peserta(idPeserta, namaPeserta,
                                        emailPeserta, teleponPeserta,
                                        tanggalDaftar, statusAktif);

                                System.out.print("\nMasukkan nama kursus yang akan diikuti: ");
                                String kursusPeserta = input.nextLine();
                                peserta.daftarKursus(kursusPeserta);

                                daftarPeserta.add(peserta);
                                System.out.println("Peserta berhasil dibuat!");
                                break;
                            case 2:
                                // Tampilkan Peserta
                                System.out.println("\n--- Daftar Peserta ---");
                                if (daftarPeserta.isEmpty()) {
                                    System.out.println("Belum ada data peserta.");
                                } else {
                                    for (Peserta p : daftarPeserta) {
                                        System.out.println(p.getInfo());
                                    }
                                }
                                break;
                            case 3:
                                // Kembali
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                        }
                    } while (menuPeserta != 3);
                    break;

                case 3: // Kursus
                    int menuKursus;
                    do {
                        System.out.println("\n--- Menu Kursus ---");
                        System.out.println("1. Buat Artikel");
                        System.out.println("2. Tampilkan Artikel");
                        System.out.println("3. Buat Video");
                        System.out.println("4. Tampilkan Video");
                        System.out.println("5. Buat Kuis Pilihan Ganda");
                        System.out.println("6. Tampilkan Kuis Pilihan Ganda");
                        System.out.println("7. Buat Kuis Esai");
                        System.out.println("8. Tampilkan Kuis Esai");
                        System.out.println("9. Buat Kursus");
                        System.out.println("10. Tampilkan Kursus");
                        System.out.println("11. Kembali");
                        System.out.print("Pilih menu: ");
                        menuKursus = input.nextInt();
                        input.nextLine();

                        switch (menuKursus) {
                            case 1:
                                // Buat Artikel
                                System.out.println("\n--- Buat Artikel ---");
                                System.out.print("Judul Artikel: ");
                                String judulArtikel = input.nextLine();
                                System.out.print("Jumlah Kata: ");
                                int jumlahKata = input.nextInt();
                                input.nextLine();

                                Artikel artikel = new Artikel(judulArtikel, jumlahKata);
                                daftarArtikel.add(artikel);
                                System.out.println("Artikel berhasil dibuat!");
                                break;
                            case 2:
                                // Tampilkan Artikel
                                System.out.println("\n--- Daftar Artikel ---");
                                if (daftarArtikel.isEmpty()) {
                                    System.out.println("Belum ada artikel.");
                                } else {
                                    for (Artikel a : daftarArtikel) {
                                        a.tampilkanKonten();
                                    }
                                }
                                break;
                            case 3:
                                // Buat Video
                                System.out.println("\n--- Buat Video ---");
                                System.out.print("Judul Video: ");
                                String judulVideo = input.nextLine();
                                System.out.print("Durasi (menit): ");
                                int durasi = input.nextInt();
                                input.nextLine();

                                Video video = new Video(judulVideo, durasi);
                                daftarVideo.add(video);
                                System.out.println("Video berhasil dibuat!");
                                break;
                            case 4:
                                // Tampilkan Video
                                System.out.println("\n--- Daftar Video ---");
                                if (daftarVideo.isEmpty()) {
                                    System.out.println("Belum ada video.");
                                } else {
                                    for (Video v : daftarVideo) {
                                        v.tampilkanKonten();
                                    }
                                }
                                break;
                            case 5:
                                // Buat Kuis Pilihan Ganda
                                System.out.println("\n--- Buat Kuis Pilihan Ganda ---");
                                System.out.print("Judul Kuis: ");
                                String judulKuisPilgan = input.nextLine();
                                System.out.print("Jumlah Soal: ");
                                int jumlahSoalPilgan = input.nextInt();
                                input.nextLine();

                                KuisPilgan kuisPilgan = new KuisPilgan(judulKuisPilgan, jumlahSoalPilgan);
                                for (int i = 0; i < jumlahSoalPilgan; i++) {
                                    System.out.println("Soal ke-" + (i + 1));
                                    System.out.print("Pertanyaan: ");
                                    String pertanyaan = input.nextLine();
                                    System.out.print("Jumlah opsi: ");
                                    int jumlahOpsi = input.nextInt();
                                    input.nextLine();
                                    ArrayList<String> opsi = new ArrayList<>();
                                    for (int j = 0; j < jumlahOpsi; j++) {
                                        System.out.print("Opsi " + (j + 1) + ": ");
                                        opsi.add(input.nextLine());
                                    }
                                    SoalPilgan soal = new SoalPilgan(pertanyaan, opsi);
                                    kuisPilgan.tambahSoal(soal);
                                }
                                daftarKuisPilgan.add(kuisPilgan);
                                System.out.println("Kuis Pilihan Ganda berhasil dibuat!");
                                break;
                            case 6:
                                // Tampilkan Kuis Pilihan Ganda
                                System.out.println("\n--- Daftar Kuis Pilihan Ganda ---");
                                if (daftarKuisPilgan.isEmpty()) {
                                    System.out.println("Belum ada kuis pilihan ganda.");
                                } else {
                                    for (KuisPilgan k : daftarKuisPilgan) {
                                        k.tampilkanKonten();
                                    }
                                }
                                break;
                            case 7:
                                // Buat Kuis Esai
                                System.out.println("\n--- Buat Kuis Esai ---");
                                System.out.print("Judul Kuis: ");
                                String judulKuisEsai = input.nextLine();
                                System.out.print("Jumlah Soal: ");
                                int jumlahSoalEsai = input.nextInt();
                                input.nextLine();

                                KuisEsai kuisEsai = new KuisEsai(judulKuisEsai, jumlahSoalEsai);
                                for (int i = 0; i < jumlahSoalEsai; i++) {
                                    System.out.println("Soal ke-" + (i + 1));
                                    System.out.print("Pertanyaan: ");
                                    String pertanyaan = input.nextLine();
                                    System.out.print("Panjang jawaban maksimal (kata): ");
                                    int panjangJawaban = input.nextInt();
                                    input.nextLine();
                                    SoalEsai soal = new SoalEsai(pertanyaan, panjangJawaban);
                                    kuisEsai.tambahSoal(soal);
                                }
                                daftarKuisEsai.add(kuisEsai);
                                System.out.println("Kuis Esai berhasil dibuat!");
                                break;
                            case 8:
                                // Tampilkan Kuis Esai
                                System.out.println("\n--- Daftar Kuis Esai ---");
                                if (daftarKuisEsai.isEmpty()) {
                                    System.out.println("Belum ada kuis esai.");
                                } else {
                                    for (KuisEsai k : daftarKuisEsai) {
                                        k.tampilkanKonten();
                                    }
                                }
                                break;
                            case 9:
                                // Buat Kursus
                                System.out.println("\n--- Buat Kursus ---");
                                System.out.print("ID Kursus: ");
                                String idKursus = input.nextLine();
                                System.out.print("Judul Kursus: ");
                                String judulKursus = input.nextLine();
                                System.out.print("Deskripsi: ");
                                String deskripsi = input.nextLine();
                                System.out.print("Harga: ");
                                double harga = input.nextDouble();
                                input.nextLine();

                                Kursus kursus = new Kursus(idKursus, judulKursus, deskripsi, harga);

                                System.out.print("Jumlah konten yang ingin ditambahkan: ");
                                int jumlahKonten = input.nextInt();
                                input.nextLine();

                                for (int i = 0; i < jumlahKonten; i++) {
                                    System.out.println("Pilih jenis konten ke-" + (i + 1) + " (1=Artikel, 2=Video): ");
                                    int jenisKonten = input.nextInt();
                                    input.nextLine();
                                    if (jenisKonten == 1) {
                                        System.out.print("Judul Artikel: ");
                                        String judulA = input.nextLine();
                                        System.out.print("Jumlah Kata: ");
                                        int kataA = input.nextInt();
                                        input.nextLine();
                                        kursus.tambahKonten(new Artikel(judulA, kataA));
                                    } else if (jenisKonten == 2) {
                                        System.out.print("Judul Video: ");
                                        String judulV = input.nextLine();
                                        System.out.print("Durasi (menit): ");
                                        int durasiV = input.nextInt();
                                        input.nextLine();
                                        kursus.tambahKonten(new Video(judulV, durasiV));
                                    }
                                }
                                daftarKursus.add(kursus);
                                System.out.println("Kursus berhasil dibuat!");
                                break;
                            case 10:
                                // Tampilkan Kursus
                                System.out.println("\n--- Daftar Kursus ---");
                                if (daftarKursus.isEmpty()) {
                                    System.out.println("Belum ada kursus.");
                                } else {
                                    for (Kursus k : daftarKursus) {
                                        k.tampilkanKonten();
                                    }
                                }
                                break;
                            case 11:
                                // Kembali
                                break;
                            default:
                                System.out.println("Pilihan tidak valid!");
                        }
                    } while (menuKursus != 11);
                    break;

                case 4:
                    System.out.println("\nTerima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } while (menuUtama != 4);

        input.close();
    }
}