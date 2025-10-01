import java.util.ArrayList;
import java.util.Scanner;

public class MainPembayaranDinamis {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pembayaran> daftarPembayaran = new ArrayList<>();
    private static int counterID = 1;

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            tampilkanMenu();
            int pilihan = inputInteger("Pilih menu: ");
            
            switch (pilihan) {
                case 1:
                    buatPembayaranBank();
                    break;
                case 2:
                    buatPembayaranEwallet();
                    break;
                case 3:
                    buatPembayaranCash();
                    break;
                case 4:
                    tampilkanSemuaPembayaran();
                    break;
                case 5:
                    prosesPembayaran();
                    break;
                case 6:
                    verifikasiPembayaranBank();
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem pembayaran!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        }
        scanner.close();
    }
    
    private static void tampilkanMenu() {
        System.out.println("=================================================");
        System.out.println("          SISTEM PEMBAYARAN DINAMIS");
        System.out.println("=================================================");
        System.out.println("1. Buat Pembayaran Bank");
        System.out.println("2. Buat Pembayaran E-Wallet");
        System.out.println("3. Buat Pembayaran Cash");
        System.out.println("4. Tampilkan Semua Pembayaran");
        System.out.println("5. Proses Pembayaran");
        System.out.println("6. Verifikasi Pembayaran Bank");
        System.out.println("0. Keluar");
        System.out.println("=================================================");
    }
    
    private static void buatPembayaranBank() {
        System.out.println("\n--- PEMBAYARAN BANK ---");
        String idPembayaran = generateID();
        double jumlah = inputDouble("Masukkan jumlah pembayaran: Rp ");
        String tanggal = inputString("Masukkan tanggal (YYYY-MM-DD): ");
        String namaBank = inputString("Masukkan nama bank: ");
        String nomorRekening = inputString("Masukkan nomor rekening: ");
        String namaPemilik = inputString("Masukkan nama pemilik rekening: ");
        
        PembayaranBank pembayaran = new PembayaranBank(idPembayaran, jumlah, tanggal, namaBank, nomorRekening, namaPemilik);
        daftarPembayaran.add(pembayaran);
        System.out.println("\nPembayaran Bank berhasil dibuat!");
        System.out.println(pembayaran.getInfo());
    }
    
    private static void buatPembayaranEwallet() {
        System.out.println("\n--- PEMBAYARAN E-WALLET ---");
        String idPembayaran = generateID();
        double jumlah = inputDouble("Masukkan jumlah pembayaran: Rp ");
        String tanggal = inputString("Masukkan tanggal (YYYY-MM-DD): ");
        String namaWallet = inputString("Masukkan nama e-wallet (GoPay/OVO/Dana/dll): ");
        String nomorWallet = inputString("Masukkan nomor e-wallet: ");
        double saldoWallet = inputDouble("Masukkan saldo e-wallet saat ini: Rp ");

        PembayaranEwallet pembayaran = new PembayaranEwallet(idPembayaran, jumlah, tanggal, tanggal, namaWallet, nomorWallet, saldoWallet);
        daftarPembayaran.add(pembayaran);
        System.out.println("\nPembayaran E-Wallet berhasil dibuat!");
        System.out.println(pembayaran.getInfo());
    }
    
    private static void buatPembayaranCash() {
        System.out.println("\n--- PEMBAYARAN CASH ---");
        String idPembayaran = generateID();
        double jumlah = inputDouble("Masukkan jumlah pembayaran: Rp ");
        String tanggal = inputString("Masukkan tanggal (YYYY-MM-DD): ");
        String namaPenerima = inputString("Masukkan nama penerima: ");
        String lokasiPembayaran = inputString("Masukkan lokasi pembayaran: ");
        double uangDiterima = inputDouble("Masukkan jumlah uang yang diterima: Rp ");
        
        PembayaranCash pembayaran = new PembayaranCash(idPembayaran, jumlah, tanggal, tanggal, namaPenerima, namaPenerima);
        pembayaran.setUangDiterima(uangDiterima);
        daftarPembayaran.add(pembayaran);
        System.out.println("\nPembayaran Cash berhasil dibuat!");
        System.out.println(pembayaran.getInfo());
    }
    
    private static void tampilkanSemuaPembayaran() {
        System.out.println("\n=== DAFTAR SEMUA PEMBAYARAN ===");
        if (daftarPembayaran.isEmpty()) {
            System.out.println("Belum ada pembayaran yang dibuat.");
            return;
        }
        
        for (int i = 0; i < daftarPembayaran.size(); i++) {
            System.out.println("\nPembayaran #" + (i + 1));
            Pembayaran p = daftarPembayaran.get(i);
            if (p instanceof PembayaranBank) {
                System.out.println(((PembayaranBank) p).getInfo());
            } else if (p instanceof PembayaranEwallet) {
                System.out.println(((PembayaranEwallet) p).getInfo());
            } else if (p instanceof PembayaranCash) {
                System.out.println(((PembayaranCash) p).getInfo());
            }
        }
    }
    
    private static void prosesPembayaran() {
        System.out.println("\n--- PROSES PEMBAYARAN ---");
        if (daftarPembayaran.isEmpty()) {
            System.out.println("Belum ada pembayaran yang dibuat.");
            return;
        }
        
        tampilkanDaftarSingkat();
        int index = inputInteger("Pilih nomor pembayaran yang akan diproses: ") - 1;
        
        if (index < 0 || index >= daftarPembayaran.size()) {
            System.out.println("Nomor pembayaran tidak valid!");
            return;
        }
        
        Pembayaran pembayaran = daftarPembayaran.get(index);
        System.out.println("\nMemproses pembayaran...");
        pembayaran.prosesPembayaran();
        
        System.out.println("\nInformasi pembayaran setelah diproses:");
        if (pembayaran instanceof PembayaranBank) {
            System.out.println(((PembayaranBank) pembayaran).getInfo());
        } else if (pembayaran instanceof PembayaranEwallet) {
            System.out.println(((PembayaranEwallet) pembayaran).getInfo());
        } else if (pembayaran instanceof PembayaranCash) {
            System.out.println(((PembayaranCash) pembayaran).getInfo());
        }
    }
    
    private static void verifikasiPembayaranBank() {
        System.out.println("\n--- VERIFIKASI PEMBAYARAN BANK ---");
        if (daftarPembayaran.isEmpty()) {
            System.out.println("Belum ada pembayaran yang dibuat.");
            return;
        }
        
        tampilkanDaftarSingkat();
        int index = inputInteger("Pilih nomor pembayaran bank yang akan diverifikasi: ") - 1;
        
        if (index < 0 || index >= daftarPembayaran.size()) {
            System.out.println("Nomor pembayaran tidak valid!");
            return;
        }
        
        Pembayaran pembayaran = daftarPembayaran.get(index);
        if (!(pembayaran instanceof PembayaranBank)) {
            System.out.println("Pembayaran yang dipilih bukan pembayaran bank!");
            return;
        }
        
        PembayaranBank pembayaranBank = (PembayaranBank) pembayaran;
        String kodeInput = inputString("Masukkan kode transaksi: ");
        pembayaranBank.verifikasiPembayaran(kodeInput);
    }
    
    private static void tampilkanDaftarSingkat() {
        for (int i = 0; i < daftarPembayaran.size(); i++) {
            Pembayaran p = daftarPembayaran.get(i);
            String tipe = "";
            if (p instanceof PembayaranBank) tipe = "Bank";
            else if (p instanceof PembayaranEwallet) tipe = "E-Wallet";
            else if (p instanceof PembayaranCash) tipe = "Cash";
            
            System.out.println((i + 1) + ". " + p.getIdPembayaran() + 
            " - " + tipe + " - Rp " + p.getJumlah() + 
            " - Status: " + p.getStatus());
        }
    }
    
    private static String generateID() {
        String id = String.format("PMB%03d", counterID);
        counterID++;
        return id;
    }
    
    private static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    private static double inputDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Nilai tidak boleh negatif!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
            }
        }
    }
    
    private static int inputInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Masukkan angka.");
            }
        }
    }
}