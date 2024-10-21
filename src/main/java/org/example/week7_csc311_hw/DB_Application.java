package org.example.week7_csc311_hw;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.week7_csc311_hw.db.ConnDbOps;

public class DB_Application extends Application {

    // Database operations object
    private static ConnDbOps cdbop;

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }

    private Stage primaryStage; // Primary stage for the application

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false); // Prevent resizing of the primary stage
        showScene1(); // Show the initial splash screen
    }

    private void showScene1() {
        try {
            // Load the splash screen layout
            Parent root = FXMLLoader.load(getClass().getResource("splash_screen.fxml"));
            Scene scene = new Scene(root, 850, 560); // Create a scene with specified dimensions
            scene.getStylesheets().add("style.css"); // Apply CSS styles
            primaryStage.setScene(scene); // Set the splash screen scene to the primary stage
            primaryStage.show(); // Display the primary stage
            changeScene(); // Initiate scene transition after splash screen
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an error occurs during loading
        }
    }

    public void changeScene() {
        try {
            // Load the main database interface layout
            Parent newRoot = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));

            Scene currentScene = primaryStage.getScene(); // Get the current scene
            Parent currentRoot = currentScene.getRoot(); // Get the current root node
            currentScene.getStylesheets().add("style.css"); // Apply CSS styles to the current scene
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), currentRoot); // Create a fade-out transition
            fadeOut.setFromValue(1); // Start fully visible
            fadeOut.setToValue(0); // End fully transparent
            fadeOut.setOnFinished(e -> {
                // Action to perform after fade-out completes
                Scene newScene = new Scene(newRoot, 850, 560); // Create a new scene for the database interface
                primaryStage.setScene(newScene); // Set the new scene to the primary stage
            });

            fadeOut.play(); // Start the fade-out transition
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an error occurs during loading
        }
    }
}
