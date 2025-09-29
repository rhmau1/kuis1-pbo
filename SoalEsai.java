public class SoalEsai {
    private String pertanyaan;
    private int panjangJawaban;

    public SoalEsai(String pertanyaan, int panjangJawaban) {
        this.pertanyaan = pertanyaan;
        this.panjangJawaban = panjangJawaban;
    }

    public void tampilkanSoal() {
        System.out.println("Pertanyaan: " + pertanyaan + " max " + panjangJawaban + " kata");

    }
}
