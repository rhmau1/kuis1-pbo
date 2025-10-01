public class PembayaranCash extends Pembayaran {
    private String namaPenerima;
    private double uangDiterima;
    private double kembalian;
    private String lokasiPembayaran;

    public PembayaranCash(String idPembayaran, double jumlah, String tanggal, String status, String namaPenerima, String alamatPenerima) {
        super(idPembayaran, jumlah, tanggal, "Pending");
        this.namaPenerima = namaPenerima;
        this.uangDiterima = uangDiterima;
        this.kembalian = 0.0;
        this.lokasiPembayaran = lokasiPembayaran;
    }

    public String getNamaPenerima() {
        return namaPenerima;
    }
    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }
    public double getUangDiterima() {
        return uangDiterima;
    }
    public void setUangDiterima(double uangDiterima) {
        this.uangDiterima = uangDiterima;
    }
    private void hitungKembalian() {
        this.kembalian = uangDiterima - jumlah;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Memproses pembayaran cash di " + lokasiPembayaran + "...");
        if (uangDiterima >= jumlah) {
            hitungKembalian();
            this.status = "Berhasil";
            System.out.println("Pembayaran berhasil!");
            System.out.println("Uang diterima: Rp " + uangDiterima);
            System.out.println("Kembalian: Rp " + kembalian);
        } else {
            this.status = "Gagal";
            System.out.println("Pembayaran gagal! Uang yang dibayarkan kurang.");
        }
    }
    public String getInfo() {
        return super.getInfoPembayaran() + "\n" +
        "Metode: Cash/Tunai\n" + 
        "Lokasi Pembayaran: " + lokasiPembayaran + "\n" +
        "Uang Diterima: Rp " + uangDiterima + "\n" +
        "Kembalian: Rp " + kembalian+"\n"+
        "------------------------------------------------\n";
    }
}
