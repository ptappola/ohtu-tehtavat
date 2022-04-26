package laskin;

import java.util.HashMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Komento dummy;
    private NollaaCmd enable;
    private HashMap<Button, Komento> komennot;
    private HashMap<Integer, NollaaCmd> enabloija;
    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<Button, Komento>();
        this.dummy = new Dummy(sovellus);
        this.komennot.put(this.plus, new Plus(sovellus));
        this.komennot.put(this.miinus, new Miinus(sovellus));
        this.komennot.put(this.nollaa, new Nollaa(sovellus));
        this.komennot.put(this.undo, new Undo(sovellus));
        this.enabloija = new HashMap<Integer, NollaaCmd>();
        this.enable = new NollaaActivate();
        this.enabloija.put(0, new NollaaDeactivate());
    }
    
    @Override
    public void handle(Event event) {
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
 	this.komennot.getOrDefault(event.getTarget(), this.dummy).suorita(arvo);
        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        this.enabloija.getOrDefault(laskunTulos, this.enable).suorita(nollaa);
        undo.disableProperty().set(false);
    }

}
