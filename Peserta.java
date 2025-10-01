public class Peserta extends Person {
    // private String tanggalDaftar;
    private boolean statusAktif;

    // Constructor
    public Peserta() {
        super();
        this.statusAktif = true;
    }

    public Peserta(String id, String nama, String email, String telepon, boolean statusAktif) {
        super(id, nama, email, telepon);
        // this.tanggalDaftar = tanggalDaftar;
        this.statusAktif = statusAktif;
    }

    // Getter methods
    // public String getTanggalDaftar() {
    // return tanggalDaftar;
    // }

    public boolean isStatusAktif() {
        return statusAktif;
    }

    // Setter methods
    // public void setTanggalDaftar(String tanggalDaftar) {
    // this.tanggalDaftar = tanggalDaftar;
    // }

    public void setStatus(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    // Method daftarKursus dengan parameter objek Kursus
    public void daftarKursus(String namaKursus) {
        if (statusAktif) {
            System.out.println(getNama() + " berhasil mendaftar kursus: " + namaKursus);
        } else {
            System.out.println(getNama() + " tidak aktif, tidak dapat mendaftar kursus.");
        }
    }

    // Override method getInfo()
    @Override
    public String getInfo() {
        return super.getInfo() + "\n" +
        // "Tanggal Daftar: " + tanggalDaftar + "\n" +
                "Status Aktif: " + (statusAktif ? "Aktif" : "Tidak Aktif");
    }
}