package com.example.seatplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MenuController {
    private ArrayList<Student> students;

    @FXML
    Label welcomeLabel;


    public void displayName(String name) {
        welcomeLabel.setText("Welcome " + name + "!");
    }

    public void switchToStudents(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Students.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();


    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;

    }

    public void switchToPlanner(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("Planner.fxml"));
        Parent root = loader.load();




        //Pass on list of students
        PlannerController plannerController= loader.getController();
        plannerController.setStudents(students);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
