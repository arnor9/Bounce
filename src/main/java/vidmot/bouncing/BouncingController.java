package vidmot.bouncing;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import vinnsla.Leikur;

import java.util.HashMap;
import java.util.Map;

public class BouncingController {

    private Map<KeyCode, Stefna> keyToStefna = new HashMap<>();

    @FXML
    private Label fxStigin;
    @FXML
    private Leikbord leikbord;
    public Rectangle gamePane;
    public Leikur leikur;
    private Bolti bolti;
    private Pallur pallur;
    private VBox scene;
    @FXML
    private VBox fxVBox;
    private Timeline t;


    public void orvatakkar() {
        Map<KeyCode, Stefna> keyToStefna = new HashMap<>();
        keyToStefna.put(KeyCode.UP, null);
        keyToStefna.put(KeyCode.DOWN, null);
        keyToStefna.put(KeyCode.RIGHT, Stefna.RIGHT);
        keyToStefna.put(KeyCode.LEFT, Stefna.LEFT);

        fxStigin.getScene().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            try {
                Stefna stefna = keyToStefna.get(event.getCode());
                if (stefna != null) {
                    int gradur = stefna.getGradur();
                    System.out.println("Gráður: " + gradur);
                    Bolti bolti = leikbord.getBolti();
                    bolti.setStefna(stefna.getGradur());
                    bolti.afram(stefna);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                event.consume();
            }
        });
    }

    // public void testBolti() {
    //   leikbord.getBolti().setRotate(Stefna.RIGHT.getGradur());
    // for (int i = 0; i < 50; i++) {
    //   leikbord.getBolti().afram();
    // }
    // }

    public void stillaTimeline() {
        KeyFrame k = new KeyFrame(Duration.millis(1000),
                e -> {
                    leikbord.aframPallar();
                    leikbord.afram();
                    leikur.haekkaStigin();
                });
        t = new Timeline(k);
        t.setCycleCount(Timeline.INDEFINITE);
        leikbord.nyrLeikur(3);
        t.play();
    }

    public void leikLokid() {
        leikur.leikurLokid();
        t.stop();
    }

    public void testPallar() {
        leikbord.getPallur().setRotate(Stefna.DOWN.getGradur());
        for (int i = 0; i < 50; i++) {
            leikbord.getPallur().afram();
        }
    }

    //double bottomBound = scene.getHeight() - bolti.getRadius();

    //  public void erBoltiABotni() {
    //    if (bolti.getLayoutY() >= bottomBound) {
    //      leikur.leikurLokid();
    //}
    // if (bolti.getBoundsInParent().intersects()) {
    //  }
    //}
}
