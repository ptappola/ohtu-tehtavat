package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Pelaa {
    private Tuomari tuomari;
    protected Aly aly;
    public Pelaa(Aly aly) {
        this.tuomari = new Tuomari();
        this.aly = aly;
    }
    public void pelaa(Scanner scanner) {
        String ekanSiirto = "k";
        String tokanSiirto = "k";
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = haeTokanSiirto(scanner, ekanSiirto);
            aly.asetaSiirto(ekanSiirto);
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    protected abstract String haeTokanSiirto(Scanner scanner, String ekanSiirto);
}