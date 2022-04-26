package laskin;
import javafx.scene.control.Button;

public class NollaaActivate extends NollaaCmd {
//    public NollaaActivate() {
//        super(nappi);
//    }
    @Override
    public void suorita(Button nappi) {
        nappi.disableProperty().set(false);
    }
}

