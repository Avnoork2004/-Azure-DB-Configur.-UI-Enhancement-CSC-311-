module org.example.week7_csc311_hw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.week7_csc311_hw to javafx.fxml;
    exports org.example.week7_csc311_hw;
}