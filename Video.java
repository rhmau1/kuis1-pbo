public class Video extends Konten {
    private int durasi;

    public Video(String judul, int durasi) {
        super(judul);
        this.durasi = durasi;
    }

    @Override
    public void tampilkanKonten() {
        System.out.println("\nVideo: " + judul + " (durasi " + durasi + " menit)");
    }
}
