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

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        //new code 2
        //title of the primary fxml
        stage.setTitle("Database Management App");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        return fxmlLoader.load();
    }







    public static void main(String[] args) {
        cdbop = new ConnDbOps();
        Scanner scan = new Scanner(System.in);

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
            System.out.println("| To edit a user,         press 'u' |");
            //to delete the user
            System.out.println("| To delete a user,       press 'd' |");
            System.out.println("| To exit,                press 'e' |");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");
            input = scan.next().charAt(0);

            switch (input) {
                case 'g':
                     launch(args); //GUI
                    break;

                case 'c':
                    cdbop.connectToDatabase(); //Your existing method
                    break;
                case 'a':
                    cdbop.listAllUsers(); //all users in DB
                    break;

                case 'i':
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
                    cdbop.insertUser(name, email, phone, address, password); //Your insertUser method
                    break;
                case 'q':
                    System.out.print("Enter the name to query: ");
                    String queryName = scan.next();
                    cdbop.queryUserByName(queryName); //Your queryUserByName method
                    break;

                //new code just wrote
                //method to edit the user
                case 'u':
                    System.out.print("Enter the ID of the user to edit: ");
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
                    cdbop.editUser(editId, newName, newEmail, newPhone, newAddress, newPassword); // Edit user details
                    break;

                    //method to delete the user
                case 'd':
                    System.out.print("Enter the ID of the user to delete: ");
                    int deleteId = scan.nextInt();
                    cdbop.deleteUser(deleteId); // Delete user from the ID
                    break;



                case 'e':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(" ");
        } while (input != 'e');

        scan.close();

       
    }




}
