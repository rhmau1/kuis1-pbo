import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kursus kursusJava = new Kursus("K01", "Java Dasar", "Belajar fundamental Java", 250000);

        // Tambah artikel
        Artikel artikel = new Artikel("Sejarah Java", 2000);

        // Tambah video
        Video video = new Video("Intro Java", 30);

        // Tambah kuis pilgan
        KuisPilgan kuisPilgan = new KuisPilgan("Kuis Dasar Java Pilgan", 2);

        // soal 1
        List<String> opsi1 = new ArrayList<>();
        opsi1.add("A. James Gosling");
        opsi1.add("B. Guido van Rossum");
        opsi1.add("C. Bjarne Stroustrup");
        opsi1.add("D. Dennis Ritchie");
        SoalPilgan soal1 = new SoalPilgan("Siapa pencipta bahasa pemrograman Java?", opsi1);

        // Soal 2
        List<String> opsi2 = new ArrayList<>();
        opsi2.add("A. 1990");
        opsi2.add("B. 1991");
        opsi2.add("C. 1995");
        opsi2.add("D. 2000");
        SoalPilgan soal2 = new SoalPilgan("Tahun berapa Java pertama kali dirilis?", opsi2);

        // Tambahkan soal ke kuis
        kuisPilgan.tambahSoal(soal1);
        kuisPilgan.tambahSoal(soal2);

        // Tambah kuis esai
        KuisEsai kuisEsai = new KuisEsai("Kuis Dasar Java Esai", 2);

        // soal 1
        SoalEsai soalEsai1 = new SoalEsai("Jelaskan konsep OOP!", 500);

        // soal 2
        SoalEsai soalEsai2 = new SoalEsai("Berikan contoh penggunaan OOP dalam dunia nyata!", 700);

        // Tambahkan soal ke kuis
        kuisEsai.tambahSoal(soalEsai1);
        kuisEsai.tambahSoal(soalEsai2);

        // Masukkan semua konten ke kursus
        kursusJava.tambahKonten(artikel);
        kursusJava.tambahKonten(video);
        kursusJava.tambahKonten(kuisPilgan);
        kursusJava.tambahKonten(kuisEsai);

        // Tampilkan semua konten kursus
        kursusJava.tampilkanKonten();
    }
}
