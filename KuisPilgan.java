import java.util.ArrayList;
import java.util.List;

public class KuisPilgan extends Kuis {
    private List<SoalPilgan> daftarSoal;

    public KuisPilgan(String judul, int jumlahSoal) {
        super(judul, jumlahSoal);
        this.daftarSoal = new ArrayList<>(jumlahSoal);
    }

    public void tambahSoal(SoalPilgan soal) {
        daftarSoal.add(soal);
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("\nKuis Pilihan Ganda: " + judul + " (" + jumlahSoal + " soal)");
        for (int i = 0; i < jumlahSoal; i++) {
            System.out.println("Soal " + (i + 1) + ":");
            daftarSoal.get(i).tampilkanSoal();
        }
    }
}
