import java.util.ArrayList;
import java.util.List;

public class Kursus {
    private String idKursus;
    private String judul;
    private String deskripsi;
    private double harga;
    private List<Konten> daftarKonten;

    public Kursus(String idKursus, String judul, String deskripsi, double harga) {
        this.idKursus = idKursus;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.daftarKonten = new ArrayList<>();
    }

    public String getIdKursus() {
        return idKursus;
    }

    public void setIdKursus(String idKursus) {
        this.idKursus = idKursus;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tambahKonten(Konten konten) {
        daftarKonten.add(konten);
    }

    public void tampilkanKonten() {
        System.out.println("\nKursus: " + judul + " - " + deskripsi);
        System.out.println("Harga Kursus: " + harga + "\n");
        System.out.println("====== Daftar Konten ======");
        for (Konten k : daftarKonten) {
            k.tampilkanKonten();
        }
    }
}
