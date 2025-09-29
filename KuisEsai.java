import java.util.ArrayList;
import java.util.List;

public class KuisEsai extends Kuis {
    private List<SoalEsai> daftarSoal;

    public KuisEsai(String judul, int jumlahSoal) {
        super(judul, jumlahSoal);
        this.daftarSoal = new ArrayList<>(jumlahSoal);
    }

    public void tambahSoal(SoalEsai soal) {
        daftarSoal.add(soal);
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("\nKuis Esai: " + judul + " (" + jumlahSoal + " soal)");
        for (int i = 0; i < jumlahSoal; i++) {
            System.out.println("Soal " + (i + 1) + ":");
            daftarSoal.get(i).tampilkanSoal();
        }
    }
}
