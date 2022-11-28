package com.example.studentexample.dto;

public class CourseRequest {
    private String name;
    private int tutor_id;

    public CourseRequest() {
    }

    public CourseRequest(String name, int tutor_id) {
        this.name = name;
        this.tutor_id = tutor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }
}
