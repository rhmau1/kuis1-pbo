    public class PembayaranBank extends Pembayaran {
    private String namaBank;
    private String nomorRekening;
    private String namaPemilik;
    private String kodeTransaksi;

    public PembayaranBank() { 
        super(null, 0, null, null);
    }
    public PembayaranBank(String idPembayaran, double jumlah, String tanggal,String namaBank, String nomorRekening, String namaPemilik) {
        super(idPembayaran, jumlah, tanggal, "Pending");
        this.namaBank = namaBank;
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.kodeTransaksi = "";
    }
    
    public String getNamaBank() {
        return namaBank;
    }
    
    public String getNomorRekening() {
        return nomorRekening;
    }
    
    public String getNamaPemilik() {
        return namaPemilik;
    }
    
    public String getKodeTransaksi() {
        return kodeTransaksi;
    }
    
    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }
    
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }
    
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }
    
    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }
    
    private void generateKodeTransaksi() {
        this.kodeTransaksi = namaBank.substring(0, 3).toUpperCase() + 
        System.currentTimeMillis() % 1000000;
    }
    
    @Override
    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran via transfer bank " + namaBank + "...");
        generateKodeTransaksi();
        this.status = "Berhasil";
        System.out.println("Transfer berhasil!");
        System.out.println("Kode Transaksi: " + kodeTransaksi);
        System.out.println("Dari: " + namaPemilik);
        System.out.println("Rekening: " + nomorRekening);
    }
    
    public void verifikasiPembayaran(String kodeInput) {
        if (kodeInput.equals(kodeTransaksi)) {
            System.out.println("Verifikasi berhasil! Pembayaran valid.");
        } else {
            System.out.println("Verifikasi gagal! Kode transaksi tidak cocok.");
        }
    }
    public String getInfo() {
        return super.getInfoPembayaran() + "\n" +
        "Metode: Transfer Bank\n" +
        "Nama Bank: " + namaBank + "\n" +
        "Nomor Rekening: " + nomorRekening + "\n" +
        "Nama Pemilik: " + namaPemilik + "\n" +
        "Kode Transaksi: " + kodeTransaksi+"\n"+
        "------------------------------------------------\n";
    }
}