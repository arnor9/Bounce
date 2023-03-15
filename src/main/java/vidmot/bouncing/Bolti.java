package vidmot.bouncing;

import javafx.scene.shape.Circle;

public class Bolti extends Circle {

    private static final double SKREF_STAERD = 10; //skref
    private static final double FALL_STAERD = 5;
    private double stefnaG = 0.0; // stefna í gráðum
    private double vely;
    private Bolti bolti;
    private Pallur p;


    public Bolti(Leikbord b) {
        FXML_Lestur.lesa(this, "bolti-view.fxml");

    }

    public void afram(Stefna s) {
        double angle = getRotate();
        double x = getLayoutX();
        double y = getLayoutY();
        double dx = Math.cos(Math.toRadians(angle));
        if (s.getGradur() == 180) {
            x -= SKREF_STAERD;
        } else if (s.getGradur() == 0) {
            x += SKREF_STAERD;
        }
        y += FALL_STAERD;
        setLayoutX(x);
        setLayoutY(y);
    }

    // public boolean erArekstur(Pallur d) {
    //   return getBoundsInParent().intersects(d.getBoundsInParent());
    //}

    public void setjaBoltaAPall(Pallur d) {
        bolti.translateYProperty().bind(d.yProperty().subtract(25));
    }

    public void hendaBoltaAfPalli() {

    }

    public double getHeight() {
        return 2 * getRadius();
    }

    public void setValy(double vely) {
        this.vely = vely;
    }

    public void boltiKlessir(Bolti bolti) {

    }

    public void setStefna(double stefnagradur) {
        this.stefnaG = stefnagradur;
        setRotate(stefnagradur);
    }
}

