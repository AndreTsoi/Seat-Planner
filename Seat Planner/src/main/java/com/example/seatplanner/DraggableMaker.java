package com.example.seatplanner;

import javafx.scene.Node;


public class DraggableMaker {

    private double mouseAnchorX;
    private double mouseAnchorY;
    private Teacher teacher;
    private Student student;

    public DraggableMaker(Teacher teacher) {
        this.teacher = teacher;
    }

    public DraggableMaker (Student student) {
        this.student = student;
    }



    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();
        });


        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY);

            double newX = mouseEvent.getSceneX() - mouseAnchorX;
            double newY = mouseEvent.getSceneY() - mouseAnchorY;

            if (teacher != null) {
                // Update Teacher's position
                teacher.setPosition(newX, newY);
            } else if (student != null) {
                // Update Student's position
                student.setPosition(newX, newY);
            }

            System.out.println(this.teacher.getX());





        });


    }



}
