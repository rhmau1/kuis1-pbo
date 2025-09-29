import java.util.List;

public class SoalPilgan {
    private String pertanyaan;
    private List<String> opsi;

    public SoalPilgan(String pertanyaan, List<String> opsi) {
        this.pertanyaan = pertanyaan;
        this.opsi = opsi;
    }

    public void tampilkanSoal() {
        System.out.println("Pertanyaan: " + pertanyaan);
        for (String o : opsi) {
            System.out.println(" - " + o);
        }
    }
}
