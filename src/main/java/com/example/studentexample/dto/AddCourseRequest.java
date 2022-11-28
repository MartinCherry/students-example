package com.example.studentexample.dto;

public class AddCourseRequest {
    private String name;
    private int tutorId;

    public AddCourseRequest() {
    }

    public AddCourseRequest(String name, int tutorId) {
        this.name = name;
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }
}
