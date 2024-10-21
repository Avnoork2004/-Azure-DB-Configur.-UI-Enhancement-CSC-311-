package org.example.week7_csc311_hw;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void switchToLogin() throws IOException {
        App.setRoot("login"); // Switch back to login page
    }
}

