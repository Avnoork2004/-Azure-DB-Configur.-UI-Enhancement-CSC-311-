package org.example.week7_csc311_hw;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField; // Text field for entering the username
    @FXML
    private PasswordField passwordField; // Password field for entering the password

    @FXML
    protected void switchToRegistration() throws IOException {
        // Switch to registration page when called
        App.setRoot("registration"); // Change the scene to the registration page
    }
}

