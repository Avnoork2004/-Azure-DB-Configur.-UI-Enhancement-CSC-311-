package org.example.week7_csc311_hw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.example.week7_csc311_hw.db.ConnDbOps;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class DB_GUI_Controller implements Initializable {

    private ConnDbOps cdbop; // Instance of database operations

    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(1, "Jacob", "Smith", "CPIS", "CS"),
                    new Person(2, "Jacob2", "Smith1", "CPIS1", "CS")

            );

    //new code
    @FXML
    private Button addBtn;

    @FXML
    private Button clearbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private Button editbtn;



    @FXML
    TextField first_name, last_name, department, major, course;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major, tv_course;

    @FXML
    ImageView img_view;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cdbop = new ConnDbOps(); // Initialize database operations
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));
        tv_course.setCellValueFactory(new PropertyValueFactory<>("course")); // Set cell value for course

        // keyboard shortcuts
        tv.setOnKeyPressed(this::handleKeyPress);

        tv.setItems(data);

        /*
        loadData(); // Load data from database
         */
    }

    //event handler for when keys are pressed
    private void handleKeyPress(KeyEvent event) {
        // key combinations
        if (event.isControlDown()) {
            if (event.getCode() == KeyCode.A) { // Ctrl + A for Add
                addNewRecord();
                event.consume(); // Prevent further handling
            } else if (event.getCode() == KeyCode.C) { // Ctrl + C for Clear
                clearForm();
                event.consume(); // Prevent further handling
            } else if (event.getCode() == KeyCode.E) { // Ctrl + E for Edit
                editRecord();
                event.consume(); // Prevent further handling
            } else if (event.getCode() == KeyCode.D) { // Ctrl + D for Delete
                deleteRecord();
                event.consume(); // Prevent further handling
            }
        } else if (event.getCode() == KeyCode.F) { // Ctrl + F for Open File
            showImage();
            event.consume(); // Prevent further handling
        }
    }

    /*
    private void loadData() {
        data.clear(); // Clear existing data
        data.addAll(cdbop.getAllUsers()); // Add all users from the database
        tv.setItems(data); // Update TableView
    }
*/
    @FXML
    protected void addNewRecord() {


        data.add(new Person(
                data.size()+1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText()
                /*course.getText() // Include course text*/
        ));
        /*
        //new
        cdbop.insertUser(newPerson); // Insert user into database
        loadData(); // Reload data from database
        clearForm(); // Optionally clear the form after adding
         */
    }

    @FXML
    protected void clearForm() {
        first_name.clear();
        last_name.setText("");
        department.setText("");
        major.setText("");
    }

    @FXML
    protected void closeApplication() {
        System.exit(0);
    }


    @FXML
    protected void editRecord() {
        Person p = tv.getSelectionModel().getSelectedItem();
        if (p != null) {
            int c = data.indexOf(p);
            Person p2 = new Person(c + 1, first_name.getText(), last_name.getText(), department.getText(), major.getText());
            data.set(c, p2); // Update the person in the list
            tv.refresh(); // Refresh the table view
            clearForm(); //  clear the form after editing
        }
    }

    @FXML
    protected void deleteRecord() {
        Person p = tv.getSelectionModel().getSelectedItem();
        if (p != null) {
            data.remove(p);
            clearForm(); // Clear the form after deleting
        }
    }



    @FXML
    protected void showImage() {
        File file= (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file!=null){
            img_view.setImage(new Image(file.toURI().toString()));

        }
    }





    @FXML
    protected void selectedItemTV(MouseEvent mouseEvent) {
        Person p= tv.getSelectionModel().getSelectedItem();
        first_name.setText(p.getFirstName());
        last_name.setText(p.getLastName());
        department.setText(p.getDept());
        major.setText(p.getMajor());


    }
}