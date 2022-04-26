package laskin;
import javafx.scene.control.Button;

public class NollaaDeactivate extends NollaaCmd {
    @Override
    public void suorita(Button nappi) {
        nappi.disableProperty().set(true);
    }
}

