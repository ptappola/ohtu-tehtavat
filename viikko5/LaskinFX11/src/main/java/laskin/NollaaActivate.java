package laskin;
import javafx.scene.control.Button;

public class NollaaActivate extends NollaaCmd {
    @Override
    public void suorita(Button nappi) {
        nappi.disableProperty().set(false);
    }
}

