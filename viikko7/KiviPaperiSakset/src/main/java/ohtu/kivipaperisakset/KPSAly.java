package ohtu.kivipaperisakset;
import java.util.Scanner;

public class KPSAly extends Pelaa {
    public KPSAly(Aly aly) {
        super(aly);
    }
    @Override
    protected String haeTokanSiirto(Scanner scanner, String ekanSiirto) {
        String tokanSiirto = super.aly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        super.aly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}