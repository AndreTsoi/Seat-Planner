package com.example.seatplanner;

public class Student {
    private String name;
    private double x;
    private double y;

    public Student(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return this.name;
    }

    public void setPosition(double x, double y ) {
        this.x = x;
        this.y = y;

    }

}
