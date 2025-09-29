public class Kuis extends Konten {
    protected int jumlahSoal;

    public Kuis(String judul, int jumlahSoal) {
        super(judul);
        this.jumlahSoal = jumlahSoal;
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("Kuis: " + judul + " (" + jumlahSoal + " soal)");
    }
}
