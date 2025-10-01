public class MainPembayaran {
    public static void main(String[] args) {
        PembayaranBank pembayaran = new PembayaranBank("PMB001", 1500000, "2024-06-15", "Bank ABC", "1234567890", "John Doe");
        System.out.println(pembayaran.getInfo());
        pembayaran.prosesPembayaran();
        System.out.println(pembayaran.getInfo());
        pembayaran.verifikasiPembayaran(pembayaran.getKodeTransaksi());
        System.out.println(pembayaran.getInfo());
        System.out.println("--------------------------------------------------");

        PembayaranEwallet pembayaranEwallet = new PembayaranEwallet("PMB002", 500000, "2024-06-16", "Pending", "GoPay", "0987654321", 600000);
        System.out.println(pembayaranEwallet.getInfo());
        pembayaranEwallet.prosesPembayaran();
        System.out.println(pembayaranEwallet.getInfo());
        System.out.println("--------------------------------------------------");

        PembayaranCash pembayaranCash = new PembayaranCash("PMB003", 200000, "2024-06-17", "Pending", "Jane Smith", "Jl. Merdeka No. 10");
        pembayaranCash.setUangDiterima(250000);
        System.out.println(pembayaranCash.getInfo());
        pembayaranCash.prosesPembayaran();
        System.out.println(pembayaranCash.getInfo());
    }
}