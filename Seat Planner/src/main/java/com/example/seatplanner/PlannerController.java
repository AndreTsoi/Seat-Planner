package com.example.seatplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlannerController implements Initializable {
    private Teacher teacher = new Teacher();

    private ArrayList<Student> students;
    private int numberOfStudents;
    @FXML
    private Circle teacherIcon;

    DraggableMaker teacherDragger = new DraggableMaker(teacher);


    public void setStudents(ArrayList<Student> students) {
        this.students = students;
        numberOfStudents = students.size();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teacherDragger.makeDraggable(teacherIcon);
        System.out.println(numberOfStudents);

        //make student objects


    }

    public void createSingle(ActionEvent event) {

    }
}
