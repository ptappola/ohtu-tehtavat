package laskin;
public abstract class Komento {
    Sovelluslogiikka sovellus;
    public Komento(Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
    }
    public abstract void suorita(Integer argumentti);
}
