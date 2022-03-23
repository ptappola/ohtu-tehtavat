package ohtu;

import java.util.List;
import java.util.ArrayList;

public class Ostoskori {
    private ArrayList<Ostos> ostokset;
    public Ostoskori() {
        this.ostokset = new ArrayList();
    }
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   
        int paluu = 0;
        for (Ostos o : ostokset) {
            paluu += o.lukumaara();
        }
        return paluu;
    }
 
    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        int paluu = 0;
        for (Ostos o : this.ostokset) {
            paluu += o.hinta();
        }
        return paluu;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        for (Ostos o : ostokset) {
            if (o.tuotteenNimi().equals(lisattava.getNimi())) {
                o.muutaLukumaaraa(1);
                return;
            }
        }
        this.ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        for (int i = 0; i < this.ostokset.size(); i++) {
            Ostos o = this.ostokset.get(i);
            if (o.tuotteenNimi().equals(poistettava.getNimi())) {
                o.muutaLukumaaraa(-1);
                if (o.lukumaara() == 0) {
                    this.ostokset.remove(i);
                }
                return;
            }
        }
        for (Ostos o : this.ostokset) {
        }
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return this.ostokset;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
