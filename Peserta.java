import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Peserta extends Person {
    // private String tanggalDaftar;
    private boolean statusAktif;
    private List<Kursus> kursusDiikuti = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Constructor
    public Peserta() {
        super();
        this.statusAktif = true;
    }

    public Peserta(String id, String nama, String email, String telepon, boolean statusAktif) {
        super(id, nama, email, telepon);
        // this.tanggalDaftar = tanggalDaftar;
        this.statusAktif = statusAktif;
    }

    // Getter methods
    // public String getTanggalDaftar() {
    // return tanggalDaftar;
    // }

    public boolean isStatusAktif() {
        return statusAktif;
    }

    // Setter methods
    // public void setTanggalDaftar(String tanggalDaftar) {
    // this.tanggalDaftar = tanggalDaftar;
    // }

    public void setStatus(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    // Method daftarKursus dengan parameter objek Kursus
    public void daftarKursus(Kursus kursusDipilih) {
        if (!statusAktif) {
            System.out.println(getNama() + " tidak aktif, tidak dapat mendaftar kursus.");
            return;
        }

        // cek apakah sudah pernah daftar
        if (kursusDiikuti.contains(kursusDipilih)) {
            System.out.println("Kamu sudah mendaftar kursus ini dan tidak bisa daftar lagi!");
            return;
        }

        System.out.println("Harga kursus: Rp " + kursusDipilih.getHarga());
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Bank");
        System.out.println("2. Cash");
        System.out.println("3. Ewallet");
        System.out.print("Pilihan: ");
        String metode = sc.nextLine();

        Pembayaran pembayaran = null;
        boolean berhasilBayar = false;

        if (metode.equals("1")) {
            System.out.print("Nama Bank: ");
            String namaBank = sc.nextLine();
            System.out.print("Nomor Rekening: ");
            String norek = sc.nextLine();
            System.out.print("Nama Pemilik: ");
            String namaPemilik = sc.nextLine();
            System.out.print("Jumlah transfer: ");
            double jumlah = Double.parseDouble(sc.nextLine());
            pembayaran = new PembayaranBank(UUID.randomUUID().toString(), kursusDipilih.getHarga(),
                    new Date().toString(), namaBank, norek, namaPemilik);

            if (jumlah == kursusDipilih.getHarga()) {
                pembayaran.prosesPembayaran();
                berhasilBayar = true;
            } else {
                System.out.println("Jumlah transfer tidak sesuai harga kursus!");
            }
        } else if (metode.equals("2")) {
            System.out.print("Nama Penerima: ");
            String namaPenerima = sc.nextLine();
            System.out.print("Lokasi Pembayaran: ");
            String lokasi = sc.nextLine();
            System.out.print("Uang diterima: ");
            double uang = Double.parseDouble(sc.nextLine());
            pembayaran = new PembayaranCash(UUID.randomUUID().toString(), kursusDipilih.getHarga(),
                    new Date().toString(), "Pending", namaPenerima, uang, lokasi);

            if (uang >= kursusDipilih.getHarga()) {
                pembayaran.prosesPembayaran();
                berhasilBayar = true;
            } else {
                System.out.println("Uang yang dibayarkan kurang dari harga kursus!");
            }
        } else if (metode.equals("3")) {
            System.out.print("Nama Ewallet: ");
            String namaWallet = sc.nextLine();
            System.out.print("Nomor Wallet: ");
            String nomorWallet = sc.nextLine();
            System.out.print("Saldo Wallet: ");
            double saldo = Double.parseDouble(sc.nextLine());
            pembayaran = new PembayaranEwallet(UUID.randomUUID().toString(), kursusDipilih.getHarga(),
                    new Date().toString(), "Pending", namaWallet, nomorWallet, saldo);

            if (saldo >= kursusDipilih.getHarga()) {
                pembayaran.prosesPembayaran();
                berhasilBayar = true;
            } else {
                System.out.println("Saldo tidak mencukupi!");
            }
        } else {
            System.out.println("Metode pembayaran tidak valid!");
        }

        // jika bayar berhasil -> daftar kursus
        if (berhasilBayar) {
            kursusDiikuti.add(kursusDipilih);
            System.out.println(getNama() + " berhasil mendaftar kursus: " + kursusDipilih.getJudul());
        }
    }

    public void tampilkanKursusDiikuti() {
        if (kursusDiikuti.isEmpty()) {
            System.out.println(getNama() + " belum mengikuti kursus apapun.");
        } else {
            System.out.println("Kursus yang diikuti oleh " + getNama() + ":");
            for (Kursus k : kursusDiikuti) {
                System.out.println("- " + k.getJudul() + " (Rp " + k.getHarga() + ")");
            }
        }
    }

    // Override method getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
        // "Tanggal Daftar: " + tanggalDaftar + "\n" +
                "Status Aktif: " + (statusAktif ? "Aktif" : "Tidak Aktif");
    }
}