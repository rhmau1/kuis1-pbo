public class Pembayaran {
    protected String idPembayaran;
    protected double jumlah;
    protected String tanggal;
    protected String status;

    public Pembayaran(String idPembayaran, double jumlah, String tanggal, String status) {
        this.idPembayaran = "";
        this.jumlah = 0.0;
        this.tanggal = "";
        this.status = "Pending";
    }
    public String getIdPembayaran() {
        return idPembayaran;
    }
    public double getJumlah() {
        return jumlah;
    }
    public String getTanggal() {
        return tanggal;
    }
    public String getStatus() {
        return status;
    }
    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void prosesPembayaran() {
        this.status = "Berhasil";
        System.out.println("Pembayaran dengan ID " + idPembayaran + " telah diproses.");
    }
    public String getInfoPembayaran() {
        return "ID Pembayaran: " + idPembayaran + "\n"+
        "Jumlah: " + jumlah +"\n"+ 
        "Tanggal: " + tanggal +"\n"+ 
        "Status: " + status + "\n"+
        "------------------------------------------------\n";
    }
}