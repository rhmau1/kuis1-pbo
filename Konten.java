public class Konten {
    protected String judul;

    public Konten(String judul) {
        this.judul = judul;
    }

    public void tampilkanKonten() {
        System.out.println("Judul Konten: " + judul);
    }
}
