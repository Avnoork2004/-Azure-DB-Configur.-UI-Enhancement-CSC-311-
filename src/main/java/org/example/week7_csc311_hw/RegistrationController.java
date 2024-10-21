package org.example.week7_csc311_hw;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField usernameField; // Field for user to input their username
    @FXML
    private PasswordField passwordField; // Field for user to input their password securely

    /**
     * Switches the view to the login page.
     *
     * @throws IOException if there is an issue loading the login page.
     */
    @FXML
    protected void switchToLogin() throws IOException {
        App.setRoot("login"); // Switch back to login page
    }
}
