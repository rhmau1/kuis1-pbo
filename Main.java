
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Kursus> daftarKursus = new ArrayList<>();
        List<Peserta> daftarPeserta = new ArrayList<>();
        List<Instruktur> daftarInstruktur = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Peserta");
            System.out.println("2. Instruktur");
            System.out.println("3. Kursus");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            String menu = sc.nextLine();

            if (menu.equals("1")) {
                // Menu Peserta
                System.out.println("\n--- Menu Peserta ---");
                System.out.println("a. Tambah Peserta");
                System.out.println("b. Daftar Kursus");
                System.out.println("c. Tampilkan List Peserta");
                System.out.print("Pilih: ");
                String sub = sc.nextLine();
                if (sub.equalsIgnoreCase("a")) {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telepon: ");
                    String telp = sc.nextLine();
                    Peserta p = new Peserta(id, nama, email, telp, true);
                    daftarPeserta.add(p);
                    System.out.println("Peserta berhasil ditambahkan!");
                } else if (sub.equalsIgnoreCase("b")) {
                    if (daftarPeserta.isEmpty()) {
                        System.out.println("Belum ada peserta. Tambahkan peserta dulu.");
                        continue;
                    }
                    System.out.print("Masukkan ID Peserta: ");
                    String idPeserta = sc.nextLine();
                    Peserta peserta = null;
                    for (Peserta p : daftarPeserta) {
                        if (p.getId().equals(idPeserta)) {
                            peserta = p;
                            break;
                        }
                    }
                    if (peserta == null) {
                        System.out.println("Peserta tidak ditemukan!");
                        continue;
                    }
                    if (daftarKursus.isEmpty()) {
                        System.out.println("Belum ada kursus tersedia.");
                        continue;
                    }
                    System.out.println("\nDaftar Kursus:");
                    for (Kursus k : daftarKursus) {
                        k.tampilkanInfoKursus();
                    }
                    System.out.print("\nMasukkan ID Kursus yang ingin didaftar: ");
                    String idKursus = sc.nextLine();
                    Kursus kursusDipilih = null;
                    for (Kursus k : daftarKursus) {
                        if (k.getIdKursus().equals(idKursus)) {
                            kursusDipilih = k;
                            break;
                        }
                    }
                    if (kursusDipilih == null) {
                        System.out.println("Kursus tidak ditemukan!");
                        continue;
                    }
                    peserta.daftarKursus(kursusDipilih);
                } else if (sub.equalsIgnoreCase("c")) {
                    if (daftarPeserta.isEmpty()) {
                        System.out.println("Belum ada peserta terdaftar.");
                    } else {
                        System.out.println("\n--- Daftar Peserta ---");
                        for (Peserta p : daftarPeserta) {
                            System.out.println(p.getInfo());
                            System.out.println();
                        }
                    }
                }
            } else if (menu.equals("2")) {
                // Menu Instruktur
                System.out.println("\n--- Menu Instruktur ---");
                System.out.println("a. Tambah Instruktur");
                System.out.println("b. Pilih Kursus untuk Mengajar");
                System.out.println("c. Tampilkan List Instruktur");
                System.out.print("Pilih: ");
                String sub = sc.nextLine();
                if (sub.equalsIgnoreCase("a")) {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telepon: ");
                    String telp = sc.nextLine();
                    System.out.print("Keahlian: ");
                    String keahlian = sc.nextLine();
                    Instruktur instruktur = new Instruktur(id, nama, email, telp, keahlian);
                    daftarInstruktur.add(instruktur);
                    System.out.println("Instruktur berhasil ditambahkan!");
                } else if (sub.equalsIgnoreCase("b")) {
                    if (daftarInstruktur.isEmpty()) {
                        System.out.println("Belum ada instruktur. Tambahkan instruktur dulu.");
                        continue;
                    }
                    System.out.print("Masukkan ID Instruktur: ");
                    String idInstruktur = sc.nextLine();
                    Instruktur instruktur = null;
                    for (Instruktur i : daftarInstruktur) {
                        if (i.getId().equals(idInstruktur)) {
                            instruktur = i;
                            break;
                        }
                    }
                    if (instruktur == null) {
                        System.out.println("Instruktur tidak ditemukan!");
                        continue;
                    }
                    if (daftarKursus.isEmpty()) {
                        System.out.println("Belum ada kursus tersedia.");
                        continue;
                    }
                    System.out.println("\nDaftar Kursus:");
                    for (Kursus k : daftarKursus) {
                        k.tampilkanInfoKursus();
                    }
                    System.out.print("Masukkan ID Kursus yang ingin diajar: ");
                    String idKursus = sc.nextLine();
                    Kursus kursusDipilih = null;
                    for (Kursus k : daftarKursus) {
                        if (k.getIdKursus().equals(idKursus)) {
                            kursusDipilih = k;
                            break;
                        }
                    }
                    if (kursusDipilih == null) {
                        System.out.println("Kursus tidak ditemukan!");
                        continue;
                    }
                    instruktur.mengajar(kursusDipilih.getJudul());
                } else if (sub.equalsIgnoreCase("c")) {
                    if (daftarInstruktur.isEmpty()) {
                        System.out.println("Belum ada instruktur terdaftar.");
                    } else {
                        System.out.println("\n--- Daftar Instruktur ---");
                        for (Instruktur i : daftarInstruktur) {
                            System.out.println(i.getInfo());
                            System.out.println();
                        }
                    }
                }
            } else if (menu.equals("3")) {
                // Menu Kursus
                System.out.println("\n--- Menu Kursus ---");
                System.out.println("a. Buat Kursus");
                System.out.println("b. Tambah Konten ke Kursus");
                System.out.println("c. Tampilkan List Kursus");
                System.out.println("d. Tampilkan Konten Kursus");
                System.out.print("Pilih: ");
                String sub = sc.nextLine();
                if (sub.equalsIgnoreCase("a")) {
                    System.out.print("ID Kursus: ");
                    String idKursus = sc.nextLine();
                    System.out.print("Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Deskripsi: ");
                    String deskripsi = sc.nextLine();
                    System.out.print("Harga: ");
                    double harga = Double.parseDouble(sc.nextLine());
                    Kursus kursus = new Kursus(idKursus, judul, deskripsi, harga);
                    daftarKursus.add(kursus);
                    System.out.println("Kursus berhasil dibuat!");
                } else if (sub.equalsIgnoreCase("b")) {
                    if (daftarKursus.isEmpty()) {
                        System.out.println("Belum ada kursus tersedia.");
                        continue;
                    }
                    System.out.println("\nDaftar Kursus:");
                    for (Kursus k : daftarKursus) {
                        k.tampilkanInfoKursus();
                    }
                    System.out.print("Masukkan ID Kursus: ");
                    String idKursus = sc.nextLine();
                    Kursus kursusDipilih = null;
                    for (Kursus k : daftarKursus) {
                        if (k.getIdKursus().equals(idKursus)) {
                            kursusDipilih = k;
                            break;
                        }
                    }
                    if (kursusDipilih == null) {
                        System.out.println("Kursus tidak ditemukan!");
                        continue;
                    }
                    System.out.println("Pilih jenis konten:");
                    System.out.println("1. Artikel");
                    System.out.println("2. Video");
                    System.out.println("3. Kuis");
                    System.out.print("Pilihan: ");
                    String jenis = sc.nextLine();
                    if (jenis.equals("1")) {
                        System.out.print("Judul Artikel: ");
                        String judul = sc.nextLine();
                        System.out.print("Jumlah Kata: ");
                        int kata = Integer.parseInt(sc.nextLine());
                        kursusDipilih.tambahKonten(new Artikel(judul, kata));
                        System.out.println("Artikel berhasil ditambahkan!");
                    } else if (jenis.equals("2")) {
                        System.out.print("Judul Video: ");
                        String judul = sc.nextLine();
                        System.out.print("Durasi (menit): ");
                        int durasi = Integer.parseInt(sc.nextLine());
                        kursusDipilih.tambahKonten(new Video(judul, durasi));
                        System.out.println("Video berhasil ditambahkan!");
                    } else if (jenis.equals("3")) {
                        System.out.println("Pilih jenis kuis:");
                        System.out.println("a. Pilihan Ganda");
                        System.out.println("b. Esai");
                        System.out.print("Pilihan: ");
                        String jenisKuis = sc.nextLine();
                        if (jenisKuis.equalsIgnoreCase("a")) {
                            System.out.print("Judul Kuis Pilgan: ");
                            String judul = sc.nextLine();
                            System.out.print("Jumlah Soal: ");
                            int jumlah = Integer.parseInt(sc.nextLine());
                            KuisPilgan kuisPilgan = new KuisPilgan(judul, jumlah);
                            for (int i = 0; i < jumlah; i++) {
                                System.out.println("Soal " + (i + 1) + ":");
                                System.out.print("Pertanyaan: ");
                                String pertanyaan = sc.nextLine();
                                List<String> opsi = new ArrayList<>();
                                for (int o = 0; o < 4; o++) {
                                    System.out.print("Opsi " + (char) ('A' + o) + ": ");
                                    opsi.add((char) ('A' + o) + ". " + sc.nextLine());
                                }
                                SoalPilgan soal = new SoalPilgan(pertanyaan, opsi);
                                kuisPilgan.tambahSoal(soal);
                            }
                            kursusDipilih.tambahKonten(kuisPilgan);
                            System.out.println("Kuis Pilgan berhasil ditambahkan!");
                        } else if (jenisKuis.equalsIgnoreCase("b")) {
                            System.out.print("Judul Kuis Esai: ");
                            String judul = sc.nextLine();
                            System.out.print("Jumlah Soal: ");
                            int jumlah = Integer.parseInt(sc.nextLine());
                            KuisEsai kuisEsai = new KuisEsai(judul, jumlah);
                            for (int i = 0; i < jumlah; i++) {
                                System.out.println("Soal " + (i + 1) + ":");
                                System.out.print("Pertanyaan: ");
                                String pertanyaan = sc.nextLine();
                                System.out.print("Panjang Jawaban Maks (kata): ");
                                int pj = Integer.parseInt(sc.nextLine());
                                SoalEsai soal = new SoalEsai(pertanyaan, pj);
                                kuisEsai.tambahSoal(soal);
                            }
                            kursusDipilih.tambahKonten(kuisEsai);
                            System.out.println("Kuis Esai berhasil ditambahkan!");
                        } else {
                            System.out.println("Jenis kuis tidak valid!");
                        }
                    } else {
                        System.out.println("Jenis konten tidak valid!");
                    }
                } else if (sub.equalsIgnoreCase("c")) {
                    if (daftarKursus.isEmpty()) {
                        System.out.println("Belum ada kursus tersedia.");
                    } else {
                        System.out.println("\n--- Daftar Kursus ---");
                        for (Kursus k : daftarKursus) {
                            k.tampilkanInfoKursus();
                            System.out.println();
                        }
                    }
                } else if (sub.equalsIgnoreCase("d")) {
                    if (daftarKursus.isEmpty()) {
                        System.out.println("Belum ada kursus tersedia.");
                        continue;
                    }
                    System.out.println("\nDaftar Kursus:");
                    for (Kursus k : daftarKursus) {
                        k.tampilkanInfoKursus();
                    }
                    System.out.print("Masukkan ID Kursus untuk melihat konten: ");
                    String idKursus = sc.nextLine();
                    Kursus kursusDipilih = null;
                    for (Kursus k : daftarKursus) {
                        if (k.getIdKursus().equals(idKursus)) {
                            kursusDipilih = k;
                            break;
                        }
                    }
                    if (kursusDipilih == null) {
                        System.out.println("Kursus tidak ditemukan!");
                        continue;
                    }
                    kursusDipilih.tampilkanKonten();
                }
            } else if (menu.equals("0")) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Menu tidak valid!");
            }
        }
        sc.close();
    }
}
