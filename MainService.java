import java.util.*;

public class MainService {
    private Scanner sc = new Scanner(System.in);
    private List<Kursus> daftarKursus = new ArrayList<>();
    private List<Peserta> daftarPeserta = new ArrayList<>();
    private List<Instruktur> daftarInstruktur = new ArrayList<>();

    // === MENU PESERTA ===
    public void menuPeserta() {
        System.out.println("\n--- Menu Peserta ---");
        System.out.println("a. Tambah Peserta");
        System.out.println("b. Daftar Kursus");
        System.out.println("c. Tampilkan List Peserta");
        System.out.println("d. Tampilkan kursus yang diikuti peserta");
        System.out.print("Pilih: ");
        String sub = sc.nextLine();

        switch (sub.toLowerCase()) {
            case "a":
                tambahPeserta();
                break;
            case "b":
                daftarKursusPeserta();
                break;
            case "c":
                tampilkanPeserta();
                break;
            case "d":
                tampilkanKursusPeserta();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void tambahPeserta() {
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
    }

    private void daftarKursusPeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta. Tambahkan peserta dulu.");
            return;
        }
        System.out.print("Masukkan ID Peserta: ");
        String idPeserta = sc.nextLine();
        Peserta peserta = cariPesertaById(idPeserta);
        if (peserta == null) {
            System.out.println("Peserta tidak ditemukan!");
            return;
        }
        if (daftarKursus.isEmpty()) {
            System.out.println("Belum ada kursus tersedia.");
            return;
        }
        System.out.println("\nDaftar Kursus:");
        for (Kursus k : daftarKursus) {
            k.tampilkanInfoKursus();
        }
        System.out.print("\nMasukkan ID Kursus yang ingin didaftar: ");
        String idKursus = sc.nextLine();
        Kursus kursusDipilih = cariKursusById(idKursus);
        if (kursusDipilih == null) {
            System.out.println("Kursus tidak ditemukan!");
            return;
        }
        peserta.daftarKursus(kursusDipilih);
    }

    private void tampilkanPeserta() {
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

    private void tampilkanKursusPeserta() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta terdaftar.");
            return;
        }
        System.out.print("Masukkan ID Peserta: ");
        String idPeserta = sc.nextLine();
        Peserta peserta = cariPesertaById(idPeserta);
        if (peserta == null) {
            System.out.println("Peserta tidak ditemukan!");
            return;
        }
        peserta.tampilkanKursusDiikuti();
    }

    // === MENU INSTRUKTUR ===
    public void menuInstruktur() {
        System.out.println("\n--- Menu Instruktur ---");
        System.out.println("a. Tambah Instruktur");
        System.out.println("b. Pilih Kursus untuk Mengajar");
        System.out.println("c. Tampilkan List Instruktur");
        System.out.print("Pilih: ");
        String sub = sc.nextLine();

        switch (sub.toLowerCase()) {
            case "a":
                tambahInstruktur();
                break;
            case "b":
                pilihKursusMengajar();
                break;
            case "c":
                tampilkanInstruktur();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void tambahInstruktur() {
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
    }

    private void pilihKursusMengajar() {
        if (daftarInstruktur.isEmpty()) {
            System.out.println("Belum ada instruktur. Tambahkan instruktur dulu.");
            return;
        }
        System.out.print("Masukkan ID Instruktur: ");
        String idInstruktur = sc.nextLine();
        Instruktur instruktur = cariInstrukturById(idInstruktur);
        if (instruktur == null) {
            System.out.println("Instruktur tidak ditemukan!");
            return;
        }
        if (daftarKursus.isEmpty()) {
            System.out.println("Belum ada kursus tersedia.");
            return;
        }
        System.out.println("\nDaftar Kursus:");
        for (Kursus k : daftarKursus) {
            k.tampilkanInfoKursus();
        }
        System.out.print("Masukkan ID Kursus yang ingin diajar: ");
        String idKursus = sc.nextLine();
        Kursus kursusDipilih = cariKursusById(idKursus);
        if (kursusDipilih == null) {
            System.out.println("Kursus tidak ditemukan!");
            return;
        }
        instruktur.mengajar(kursusDipilih.getJudul());
    }

    private void tampilkanInstruktur() {
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

    // === MENU KURSUS ===
    public void menuKursus() {
        System.out.println("\n--- Menu Kursus ---");
        System.out.println("a. Buat Kursus");
        System.out.println("b. Tambah Konten ke Kursus");
        System.out.println("c. Tampilkan List Kursus");
        System.out.println("d. Tampilkan Konten Kursus");
        System.out.print("Pilih: ");
        String sub = sc.nextLine();

        switch (sub.toLowerCase()) {
            case "a":
                buatKursus();
                break;
            case "b":
                tambahKontenKursus();
                break;
            case "c":
                tampilkanKursus();
                break;
            case "d":
                tampilkanKontenKursus();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private void buatKursus() {
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
    }

    private void tambahKontenKursus() {
        if (daftarKursus.isEmpty()) {
            System.out.println("Belum ada kursus tersedia.");
            return;
        }
        System.out.println("\nDaftar Kursus:");
        for (Kursus k : daftarKursus) {
            k.tampilkanInfoKursus();
        }
        System.out.print("Masukkan ID Kursus: ");
        String idKursus = sc.nextLine();
        Kursus kursusDipilih = cariKursusById(idKursus);
        if (kursusDipilih == null) {
            System.out.println("Kursus tidak ditemukan!");
            return;
        }

        System.out.println("Pilih jenis konten:");
        System.out.println("1. Artikel");
        System.out.println("2. Video");
        System.out.println("3. Kuis");
        System.out.print("Pilihan: ");
        String jenis = sc.nextLine();

        switch (jenis) {
            case "1":
                System.out.print("Judul Artikel: ");
                String judulArtikel = sc.nextLine();
                System.out.print("Jumlah Kata: ");
                int kata = Integer.parseInt(sc.nextLine());
                kursusDipilih.tambahKonten(new Artikel(judulArtikel, kata));
                System.out.println("Artikel berhasil ditambahkan!");
                break;
            case "2":
                System.out.print("Judul Video: ");
                String judulVideo = sc.nextLine();
                System.out.print("Durasi (menit): ");
                int durasi = Integer.parseInt(sc.nextLine());
                kursusDipilih.tambahKonten(new Video(judulVideo, durasi));
                System.out.println("Video berhasil ditambahkan!");
                break;
            case "3":
                tambahKuis(kursusDipilih);
                break;
            default:
                System.out.println("Jenis konten tidak valid!");
        }
    }

    private void tambahKuis(Kursus kursus) {
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
            kursus.tambahKonten(kuisPilgan);
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
            kursus.tambahKonten(kuisEsai);
            System.out.println("Kuis Esai berhasil ditambahkan!");
        } else {
            System.out.println("Jenis kuis tidak valid!");
        }
    }

    private void tampilkanKursus() {
        if (daftarKursus.isEmpty()) {
            System.out.println("Belum ada kursus tersedia.");
        } else {
            System.out.println("\n--- Daftar Kursus ---");
            for (Kursus k : daftarKursus) {
                k.tampilkanInfoKursus();
                System.out.println();
            }
        }
    }

    private void tampilkanKontenKursus() {
        if (daftarKursus.isEmpty()) {
            System.out.println("Belum ada kursus tersedia.");
            return;
        }
        System.out.println("\nDaftar Kursus:");
        for (Kursus k : daftarKursus) {
            k.tampilkanInfoKursus();
        }
        System.out.print("Masukkan ID Kursus untuk melihat konten: ");
        String idKursus = sc.nextLine();
        Kursus kursusDipilih = cariKursusById(idKursus);
        if (kursusDipilih == null) {
            System.out.println("Kursus tidak ditemukan!");
            return;
        }
        kursusDipilih.tampilkanKonten();
    }

    // === HELPER ===
    private Peserta cariPesertaById(String id) {
        for (Peserta p : daftarPeserta) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    private Instruktur cariInstrukturById(String id) {
        for (Instruktur i : daftarInstruktur) {
            if (i.getId().equals(id))
                return i;
        }
        return null;
    }

    private Kursus cariKursusById(String id) {
        for (Kursus k : daftarKursus) {
            if (k.getIdKursus().equals(id))
                return k;
        }
        return null;
    }
}