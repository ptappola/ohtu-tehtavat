package ohtu.verkkokauppa;
import org.springframework.stereotype.Component;
@Component
public class Pankki {

    private KirjanpitoIF kirjanpito;

    public Pankki(KirjanpitoIF kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
