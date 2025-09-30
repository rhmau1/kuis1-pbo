public class Instruktur extends Person {
    private String keahlian;
    private double rating;

    // Constructor
    public Instruktur() {
        super();
        this.rating = 0.0;
    }

    public Instruktur(String id, String nama, String email, String telepon, String keahlian, double rating) {
        super(id, nama, email, telepon);
        this.keahlian = keahlian;
        this.rating = rating;
    }

    // Getter methods
    public String getKeahlian() {
        return keahlian;
    }

    public double getRating() {
        return rating;
    }

    // Setter methods
    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        } else {
            System.out.println("Rating harus antara 0.0 sampai 5.0");
        }
    }

    // Method mengajar dengan parameter nama kursus
    public void mengajar(String namaKursus) {
        System.out.println(getNama() + " sedang mengajar kursus: " + namaKursus);
    }

    // Override method getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
               "Keahlian: " + keahlian + "\n" +
               "Rating: " + rating;
    }
}