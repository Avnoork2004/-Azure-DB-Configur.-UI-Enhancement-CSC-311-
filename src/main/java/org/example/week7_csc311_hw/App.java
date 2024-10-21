package org.example.week7_csc311_hw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.week7_csc311_hw.db.ConnDbOps;

import java.io.IOException;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ConnDbOps cdbop;

    /*
    //Tried the splashscreen implementation
    @Override
    public void start(Stage primaryStage) throws Exception {
        setRoot("splash_screen"); // initial scene to splash screen
        primaryStage.setTitle("MediaVault");
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(fxml + ".fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
    */

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480); // Load the primary FXML
        stage.setScene(scene);
        //new code 2
        //title of the primary fxml
        stage.setTitle("Database Management App"); // Set the title of the application window
        stage.show(); // Display the primary stage
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml)); // Change the scene to the specified FXML file
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")); // Load the FXML resource
        return fxmlLoader.load(); // Return the loaded FXML root node
    }

    public static void main(String[] args) {
        cdbop = new ConnDbOps(); // Initialize the database operations object
        Scanner scan = new Scanner(System.in); // Create a Scanner object for user input

        char input;
        do {
            System.out.println(" ");
            System.out.println("============== Menu ==============");
            System.out.println("| To start GUI,           press 'g' |");
            System.out.println("| To connect to DB,       press 'c' |");
            System.out.println("| To display all users,   press 'a' |");
            System.out.println("| To insert to the DB,    press 'i' |");
            System.out.println("| To query by name,       press 'q' |");

            //new code I wrote

            //to edit the user
            System.out.println("| To edit a user,         press 'u' |"); // Option to edit user details
            //to delete the user
            System.out.println("| To delete a user,       press 'd' |"); // Option to delete a user
            System.out.println("| To exit,                press 'e' |");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");
            input = scan.next().charAt(0); // Read user input for menu selection

            switch (input) {
                case 'g':
                    launch(args); // Launch the GUI
                    break;

                case 'c':
                    cdbop.connectToDatabase(); // Connect to the database using the existing method
                    break;
                case 'a':
                    cdbop.listAllUsers(); // Display all users in the database
                    break;

                case 'i':
                    // Gather user input for inserting a new user
                    System.out.print("Enter Name: ");
                    String name = scan.next();
                    System.out.print("Enter Email: ");
                    String email = scan.next();
                    System.out.print("Enter Phone: ");
                    String phone = scan.next();
                    System.out.print("Enter Address: ");
                    String address = scan.next();
                    System.out.print("Enter Password: ");
                    String password = scan.next();
                    cdbop.insertUser(name, email, phone, address, password); // Insert the new user into the database
                    break;
                case 'q':
                    System.out.print("Enter the name to query: ");
                    String queryName = scan.next();
                    cdbop.queryUserByName(queryName); // Query the database for a user by name
                    break;

                //new code just wrote
                //method to edit the user
                case 'u':
                    System.out.print("Enter the ID of the user to edit: "); // Prompt for user ID to edit
                    int editId = scan.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scan.next();
                    System.out.print("Enter New Email: ");
                    String newEmail = scan.next();
                    System.out.print("Enter New Phone: ");
                    String newPhone = scan.next();
                    System.out.print("Enter New Address: ");
                    String newAddress = scan.next();
                    System.out.print("Enter New Password: ");
                    String newPassword = scan.next();
                    cdbop.editUser(editId, newName, newEmail, newPhone, newAddress, newPassword); // Edit user details in the database
                    break;

                //method to delete the user
                case 'd':
                    System.out.print("Enter the ID of the user to delete: "); // Prompt for user ID to delete
                    int deleteId = scan.nextInt();
                    cdbop.deleteUser(deleteId); // Delete the user from the database using their ID
                    break;

                case 'e':
                    System.out.println("Exiting..."); // Inform the user that the application is exiting
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid menu selection
            }
            System.out.println(" "); // Print a blank line for better readability
        } while (input != 'e'); // Continue the loop until the user decides to exit

        scan.close(); // Close the Scanner to free up resources
    }
}
