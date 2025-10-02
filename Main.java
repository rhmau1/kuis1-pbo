import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MainService service = new MainService();

        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Peserta");
            System.out.println("2. Instruktur");
            System.out.println("3. Kursus");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    service.menuPeserta();
                    break;
                case "2":
                    service.menuInstruktur();
                    break;
                case "3":
                    service.menuKursus();
                    break;
                case "0":
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Menu tidak valid!");
            }
        }
    }
}