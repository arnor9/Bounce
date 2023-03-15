package vidmot.bouncing;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Pallur extends Rectangle {
    private static final Random random = new Random();

    public Pallur() {
        FXML_Lestur.lesa(this, "pallur-view.fxml");
    }


    public void setjaABord(Leikbord b) {
        setX(random.nextInt((int) (b.getWidth() - getWidth())));
        setY(random.nextInt((int) (b.getHeight() - getHeight())));
        b.getChildren().add(this);
    }

    public void afram() {
        Leikbord p = (Leikbord) this.getParent();
        setX((int) (getX() + p.getWidth() + (int) Math.cos(Math.toRadians((getRotate()))) * 5) % (int) p.getWidth());
        setY((int) (getY() + p.getHeight() - (int) Math.sin(Math.toRadians(getRotate())) * 5) % (int) p.getHeight());

    }


}
