public class PembayaranEwallet extends Pembayaran {
    private String namaWallet;
    private String nomorWallet;
    private double saldoWallet;

    public PembayaranEwallet(String idPembayaran, double jumlah, String tanggal, String status, String namaWallet, String nomorWallet, double saldoWallet) {
        super(idPembayaran, jumlah, tanggal, "Pending");
        this.namaWallet = namaWallet;
        this.nomorWallet = nomorWallet;
        this.saldoWallet = saldoWallet;
    }
    public String getNamaWallet() {
        return namaWallet;
    }
    public String getNomorWallet() {
        return nomorWallet;
    }
    public double getSaldoWallet() {
        return saldoWallet;
    }
    public void setNamaWallet(String namaWallet) {
        this.namaWallet = namaWallet;
    }
    public void setNomorWallet(String nomorWallet) {
        this.nomorWallet = nomorWallet;
    }
    public void setSaldoWallet(double saldoWallet) {
        this.saldoWallet = saldoWallet;
    }
    @Override
    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran melalui " + namaWallet + "...");
        if (saldoWallet >= jumlah) {
            this.saldoWallet -= jumlah;
            this.status = "Berhasil";
            System.out.println("Pembayaran berhasil! Saldo tersisa: Rp " + saldoWallet);
        } else {
            this.status = "Gagal";
            System.out.println("Pembayaran gagal! Saldo tidak mencukupi.");
        }
    }
    public String getInfo() {
        return super.getInfoPembayaran()+
        "Metode Pembayaran: E-Wallet " + namaWallet + "\n"+
        "No: " + nomorWallet +"\n"+
        "Saldo: Rp " + saldoWallet + "\n"+
        "------------------------------------------------\n";
    }
}
