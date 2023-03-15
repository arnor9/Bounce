package vidmot.bouncing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BouncingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(BouncingApplication.class.getResource("bouncing-view.fxml"));
        Parent root = fxmlloader.load();
        BouncingController sc = fxmlloader.getController();
        stage.setTitle("Bouncing ball");
        Scene s = new Scene(root, 600, 600);
        sc.orvatakkar();
        stage.setScene(s);
        stage.show();
        sc.stillaTimeline();
    }


    public static void main(String[] args) {
        launch();
    }
}

