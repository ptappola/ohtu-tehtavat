package ohtu;

import java.util.List;
import java.util.ArrayList;

public class Ostoskori {
    private List<Ostos> ostokset;
    public Ostoskori() {
        this.ostokset = new ArrayList();
    }
    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2   

        return this.ostokset.size();
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
        this.ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
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
