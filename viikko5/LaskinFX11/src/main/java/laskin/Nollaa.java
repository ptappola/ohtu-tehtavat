package laskin;

public class Nollaa extends Komento {
    public Nollaa(Sovelluslogiikka sovellus) {
        super(sovellus);
    }
    @Override
    public void suorita(Integer parametri) {
        super.sovellus.nollaa();
    }
}

