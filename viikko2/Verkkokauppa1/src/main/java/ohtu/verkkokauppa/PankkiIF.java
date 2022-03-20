package ohtu.verkkokauppa;

public interface PankkiIF {
//    public PankkiIF getInstance();
//    public PankkiIF();
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}