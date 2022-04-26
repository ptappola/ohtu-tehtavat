package laskin;

public class Plus extends Komento {
    public Plus(Sovelluslogiikka sovellus) {
        super(sovellus);
    }
    @Override
    public void suorita(Integer parametri) {
        this.sovellus.plus(parametri);
    }
}

