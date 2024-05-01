package com.example.seatplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StudentsController {

    private ArrayList<Student> students;
    @FXML
    private TextField nameBox;


    @FXML
    private ListView<String> studentListView;

    @FXML
    private Label errorText;
    @FXML
    private Label exitText;

    @FXML
    void addName(ActionEvent event) {

        if (!nameBox.getText().isBlank()) {
            studentListView.getItems().add(nameBox.getText());
            nameBox.clear();
            errorText.setText("");
        } else {
            errorText.setText("Please enter a valid name!");
            nameBox.clear();

        }


    }

    @FXML
    void removeName(ActionEvent event) {
        int selectedId = studentListView.getSelectionModel().getSelectedIndex();
        studentListView.getItems().remove(selectedId);

    }

    public void switchToMenu(ActionEvent event) throws IOException {

        if (!studentListView.getItems().isEmpty()) {
            exitText.setText("");
            //ArrayList of the names
            ArrayList<String> nameList = new ArrayList<>(studentListView.getItems());
            //Making arraylist of students
            ArrayList<Student> students = new ArrayList<>();
            for (String s : nameList) {
                students.add(new Student(s));
            }

            //Load Scene

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();




            //Pass on list of students
            MenuController menuController = loader.getController();
            menuController.setStudents(students);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();



        } else {
            exitText.setText("Please enter at least 1 student!");
        }




    }

}


