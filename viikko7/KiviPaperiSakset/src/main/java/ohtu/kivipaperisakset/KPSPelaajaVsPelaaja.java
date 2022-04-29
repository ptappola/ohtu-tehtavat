package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends Pelaa {

    private static final Scanner scanner = new Scanner(System.in);
    public KPSPelaajaVsPelaaja() {
        super(new Aly());
    }

    @Override
    protected String haeTokanSiirto(Scanner scanner, String ekanSiirto) {
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = scanner.nextLine();
        return tokanSiirto;
    }
}
