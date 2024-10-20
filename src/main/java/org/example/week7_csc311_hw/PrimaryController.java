package org.example.week7_csc311_hw;

import javafx.fxml.FXML;

import java.io.IOException;

//new imports 2
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCombination;
import org.example.week7_csc311_hw.db.ConnDbOps;
import java.util.Optional;

//new imports 3
import javafx.scene.control.MenuItem;




public class PrimaryController {

    private ConnDbOps cdbop;

    //new code 3
    // GUI menu items

    @FXML
    private MenuItem addUserMenuItem;
    @FXML
    private MenuItem editUserMenuItem;
    @FXML
    private MenuItem deleteUserMenuItem;
    @FXML
    private MenuItem listAllUsersMenuItem;





    public PrimaryController() {
        cdbop = new ConnDbOps(); // Initialize DB operations class
    }


    //new code 3
    @FXML
    private void initialize() {
        // action handlers for menu items
        addUserMenuItem.setOnAction(event -> handleAddUser());
        editUserMenuItem.setOnAction(event -> handleEditUser());
        deleteUserMenuItem.setOnAction(event -> handleDeleteUser());
        listAllUsersMenuItem.setOnAction(event -> handleListAllUsers());

        // keyboard shortcuts for menu actions
        addUserMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        editUserMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        deleteUserMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
        listAllUsersMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
    }



    //new code 2
    //gui for the menubar and menuitems
    @FXML
    private void handleAddUser() {
        // dialog to get input from user
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add User");
        dialog.setHeaderText("Add a new user to the database");

        dialog.setContentText("Enter Name: ");
        Optional<String> name = dialog.showAndWait();

        dialog.setContentText("Enter Email: ");
        Optional<String> email = dialog.showAndWait();

        dialog.setContentText("Enter Phone: ");
        Optional<String> phone = dialog.showAndWait();

        dialog.setContentText("Enter Address: ");
        Optional<String> address = dialog.showAndWait();

        dialog.setContentText("Enter Password: ");
        Optional<String> password = dialog.showAndWait();

        // inputs to insert user into database
        name.ifPresent(n -> cdbop.insertUser(n, email.orElse(""), phone.orElse(""), address.orElse(""), password.orElse("")));
    }

    @FXML
    private void handleEditUser() {
        // dialog to get User ID
        TextInputDialog idDialog = new TextInputDialog();
        idDialog.setTitle("Edit User");
        idDialog.setHeaderText("Edit an existing user");
        idDialog.setContentText("Enter User ID to edit: ");

        // Waits for user input - ID
        Optional<String> userIdInput = idDialog.showAndWait();

        if (userIdInput.isPresent()) {
            try {
                int userId = Integer.parseInt(userIdInput.get()); // Convert input to integer

                // editing Name
                TextInputDialog nameDialog = new TextInputDialog();
                nameDialog.setTitle("Edit User");
                nameDialog.setHeaderText("Edit User Name");
                nameDialog.setContentText("Enter new Name: ");
                Optional<String> newName = nameDialog.showAndWait();

                // editing Email
                TextInputDialog emailDialog = new TextInputDialog();
                emailDialog.setTitle("Edit User");
                emailDialog.setHeaderText("Edit User Email");
                emailDialog.setContentText("Enter new Email: ");
                Optional<String> newEmail = emailDialog.showAndWait();

                // editing Phone
                TextInputDialog phoneDialog = new TextInputDialog();
                phoneDialog.setTitle("Edit User");
                phoneDialog.setHeaderText("Edit User Phone");
                phoneDialog.setContentText("Enter new Phone: ");
                Optional<String> newPhone = phoneDialog.showAndWait();

                // editing Address
                TextInputDialog addressDialog = new TextInputDialog();
                addressDialog.setTitle("Edit User");
                addressDialog.setHeaderText("Edit User Address");
                addressDialog.setContentText("Enter new Address: ");
                Optional<String> newAddress = addressDialog.showAndWait();

                // editing Password
                TextInputDialog passwordDialog = new TextInputDialog();
                passwordDialog.setTitle("Edit User");
                passwordDialog.setHeaderText("Edit User Password");
                passwordDialog.setContentText("Enter new Password: ");
                Optional<String> newPassword = passwordDialog.showAndWait();

                // editUser method
                if (newName.isPresent() && newEmail.isPresent() && newPhone.isPresent()
                        && newAddress.isPresent() && newPassword.isPresent()) {

                    //  cdbop database
                    cdbop.editUser(userId, newName.get(), newEmail.get(), newPhone.get(),
                            newAddress.get(), newPassword.get());

                    // confirmation dialog
                    Alert confirmationAlert = new Alert(Alert.AlertType.INFORMATION);
                    confirmationAlert.setTitle("User Updated");
                    confirmationAlert.setHeaderText(null);
                    confirmationAlert.setContentText("User with ID " + userId + " has been updated successfully!");
                    confirmationAlert.showAndWait();
                }
            } catch (NumberFormatException e) {
                // invalid User ID
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Invalid Input");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("User ID must be a valid number!");
                errorAlert.showAndWait();
            }
        }
    }

    @FXML
    private void handleDeleteUser() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Delete User");
        dialog.setHeaderText("Delete a user from the database");

        dialog.setContentText("Enter User ID to delete: ");
        Optional<String> userId = dialog.showAndWait();

        // User ID to integer, delete user from database
        userId.ifPresent(id -> cdbop.deleteUser(Integer.parseInt(id)));
    }

    @FXML
    private void handleListAllUsers() {
        // list all users from database
        cdbop.listAllUsers();
    }




//old code
//to go to the second stage


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
