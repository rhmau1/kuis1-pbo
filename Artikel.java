public class Artikel extends Konten {
    private int jumlahKata;

    public Artikel(String judul, int jumlahKata) {
        super(judul);
        this.jumlahKata = jumlahKata;
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("\nArtikel: " + judul + " (" + jumlahKata + " kata)");
    }
}
