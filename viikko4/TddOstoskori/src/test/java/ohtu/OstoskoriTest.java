package ohtu;

import java.util.List;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
        // ...
    }
    // step 2
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
        assertEquals(1, kori.tavaroitaKorissa());
        // ...
    }
    // step 3
    @Test
    public void yhdenTuotteenLisaamisenJalkeenHintaOnTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);
 
        kori.lisaaTuote(maito);
        assertEquals(3, kori.hinta());
    }
    // step 4
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote juusto = new Tuote("juusto", 5);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(juusto);
        assertEquals(2, kori.tavaroitaKorissa());
        // ...
    }
    // step 5
    @Test
    public void kahdenTuotteenLisaamisenJalkeenHintaOnTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote juusto = new Tuote("juusto", 5);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(juusto);
        assertEquals(8, kori.hinta());
    }
    // step 6
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(2, kori.tavaroitaKorissa());
        // ...
    }
    // step 7
    @Test
    public void kahdenSamanTuoteenLisaamisenJalkeenHintaOnTuotteidenHinta() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(6, kori.hinta());
    }
    // step 8
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaOnYksiOstos() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(1, ostokset.size());
    }
    // step 9
    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
 
        Ostos ostos = kori.ostokset().get(0);
 
        // testaa t????ll??, ett?? palautetun listan ensimm??inen ostos on halutunkaltainen.
        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(1, ostos.lukumaara());
    } 
    // step 10
    @Test
    public void kahdenEriTuotteenLisaamisenKorissaKaksiOstosOliota() {
        Tuote maito = new Tuote("maito", 3);
        Tuote juusto = new Tuote("juusto", 5);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(juusto);
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(2, ostokset.size());
    } 
    // step 11
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(1, ostokset.size());
    }
    // step 12
    @Test
    public void kandenSamanTuotteenLisaamisenJalkeenOstoksenNimiJaMaaraOnOikea() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        Ostos ostos = kori.ostokset().get(0);
        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(2, ostos.lukumaara());
    }
    // step 13
    @Test
    public void kahdenSamanTuotteenLisaamisenPoistonJalkeenMaaraOnOikea() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        kori.poista(maito);
        Ostos ostos = kori.ostokset().get(0);
        assertEquals(1, ostos.lukumaara());
    }
    // step 14
    @Test
    public void lisayksenJaPoistonJalkeenKoriOnTyhja() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.poista(maito);
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(0, ostokset.size());
        assertEquals(0, kori.hinta());
    }
    // step 15
    @Test
    public void tyhjennaTyhjentaaKorin() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);
        kori.tyhjenna();
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(0, ostokset.size());
        assertEquals(0, kori.hinta());
    }
}
