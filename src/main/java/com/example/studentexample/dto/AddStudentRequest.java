package com.example.studentexample.dto;

import java.util.Objects;

public class AddStudentRequest {

    private String name;
    private String surname;
    private int courseId;

    public AddStudentRequest() {
    }

    public AddStudentRequest(String name, String surname, int courseId) {
        this.name = name;
        this.surname = surname;
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddStudentRequest that)) {
            return false;
        }
        return getCourseId() == that.getCourseId() && getName().equals(that.getName()) &&
                getSurname().equals(that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getCourseId());
    }
}
