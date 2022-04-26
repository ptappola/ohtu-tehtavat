package laskin;

public class Miinus extends Komento {
    public Miinus(Sovelluslogiikka sovellus) {
        super(sovellus);
    }
    @Override
    public void suorita(Integer parametri) {
        super.sovellus.miinus(parametri);
    }
}

