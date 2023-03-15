package vinnsla;

import javafx.scene.layout.Pane;

public class Leikbord extends Pane {
    public Leikbord() {
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
    }
}
