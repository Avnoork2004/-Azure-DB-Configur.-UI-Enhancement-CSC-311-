package org.example.week7_csc311_hw;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void switchToRegistration() throws IOException {
        App.setRoot("registration"); // Switch to registration page
    }
}
