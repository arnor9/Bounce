module vidmot.bouncing {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens vidmot.bouncing to javafx.fxml;
    exports vidmot.bouncing;
}