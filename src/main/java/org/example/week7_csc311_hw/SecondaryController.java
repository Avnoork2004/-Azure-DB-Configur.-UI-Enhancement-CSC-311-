package org.example.week7_csc311_hw;

import javafx.fxml.FXML;
import java.io.IOException;

public class SecondaryController {

    // This method switches the view to the primary scene
    @FXML
    private void switchToPrimary() throws IOException {
        // Set the root of the application to the "primary" layout
        App.setRoot("primary");
    }
}
