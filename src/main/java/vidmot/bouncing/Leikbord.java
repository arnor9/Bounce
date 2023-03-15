package vidmot.bouncing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import vinnsla.Leikur;

public class Leikbord extends Pane {

    @FXML
    private Bolti bolti;
    @FXML
    private Pallur pallur;
    private Leikur leikur;
    private final ObservableList<Bolti> boltinn = FXCollections.observableArrayList();
    private BouncingController sc;
    private Bolti ball;
    private final ObservableList<Pallur> pallar = FXCollections.observableArrayList();


    public Leikbord() {
        bolti = new Bolti(this);
        getChildren().add(bolti);
    }

    public Bolti getBolti() {
        return bolti;
    }

    public Pallur getPallur() {
        return pallur;
    }

    /**
     * Setur controller fyrir viðmótshlutinn
     *
     * @param sc controllerinn
     */
    public void setController(BouncingController sc) {
        this.sc = sc;
    }

    /**
     * Nær í controllerinn
     *
     * @return controllerinn
     */
    public BouncingController getController() {
        return sc;
    }


    /**
     * Býr til nýjan bolta. Ef bolti er á borðinu þá er hann fjarlægður
     *
     * @return skilar nýjum bolta
     */
    public Bolti nyrBolti() {
        if (ball != null)
            getChildren().remove(ball);
        ball = new Bolti(this);// til að sé hægt að setja í bið
        getChildren().add(ball);
        return ball;
    }

    public void nyrPallur(int fjoldi) {
        for (int i = 0; i < fjoldi; i++) {
            Pallur e = new Pallur();
            e.setjaABord(this);
            pallar.add(e);
        }
    }

    public void aframPallar() {
        athugaBoltaAPalli();
    }

    public void athugaBoltaAPalli() {
        for (Pallur d : pallar) {
            d.afram();
            if (bolti.getBoundsInParent().intersects(d.getBoundsInParent())) {
                bolti.setjaBoltaAPall(d);
            } else bolti.hendaBoltaAfPalli();
        }
    }


    public void athugaArakstur() {
        for (Pallur d : pallar) {
            d.afram();
            athugaBoltaAPalli();
        }
    }


    public void afram() {
        bolti.afram(Stefna.DOWN);
    }

    public void nyrLeikur(int fjoldi) {
        nyrPallur(fjoldi);
    }
}
