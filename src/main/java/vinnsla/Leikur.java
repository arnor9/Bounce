package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Leikur {
    private final ObservableList<Integer> stigatafla = FXCollections.observableArrayList();
    private int stigin = 0;

    public int stiginProperty() {
        return stigin;
    }

    public void leikurLokid() {
        System.out.print("GameOver");
        stigatafla.add(stigin);
        stigin = 0;

    }

    public void haekkaStigin() {
        stigin += 1;
    }

}
