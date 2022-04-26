package laskin;

public class Undo extends Komento {
    public Undo(Sovelluslogiikka sovellus) {
        super(sovellus);
    }
    @Override
    public void suorita(Integer parametri) {
        super.sovellus.edellinen();
    }
}

