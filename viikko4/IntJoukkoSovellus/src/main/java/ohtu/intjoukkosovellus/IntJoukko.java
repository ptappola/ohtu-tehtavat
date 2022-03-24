
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
                                                 // näin paljon isompi kuin vanha
    private int kasvatusKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }
        
    public IntJoukko(int kapasiteetti, int kasvatusKoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti negatiivinen");//heitin vaan jotain :D
        }
        if (kasvatusKoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko negatiivinen");//heitin vaan jotain :D
        }
        this.lukujono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatusKoko = kasvatusKoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == lukujono.length) {
                int[] taulukkoOld = this.lukujono;
                this.lukujono = new int[alkioidenLkm + kasvatusKoko];
                kopioiTaulukko(taulukkoOld, lukujono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                lukujono[j] = lukujono[j + 1];
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String paluu = "{";
        for (int i = 0; i < alkioidenLkm; i++) {
            paluu += lukujono[i];
            if (i < alkioidenLkm - 1) {
                paluu += ", ";
            }
        }
        paluu += "}";
        return paluu;
    }

    public int[] toIntArray() {
        int[] paluu = new int[alkioidenLkm];
        for (int i = 0; i < alkioidenLkm; i++) {
            paluu[i] = lukujono[i];
        }
        return paluu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko paluu = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            paluu.lisaa(a.lukujono[i]);
        }
        for (int i = 0; i < b.alkioidenLkm; i++) {
            paluu.lisaa(b.lukujono[i]);
        }
        return paluu;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko paluu = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.kuuluu(a.lukujono[i])) {
                paluu.lisaa(a.lukujono[i]);
            }
        }
        return paluu;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko paluu = new IntJoukko();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (!b.kuuluu(a.lukujono[i])) {
                paluu.lisaa(a.lukujono[i]);
            }
        }
        return paluu;
    }
}
