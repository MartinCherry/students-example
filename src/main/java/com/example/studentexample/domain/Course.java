package com.example.studentexample.domain;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Tutor tutor;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course(String name, Tutor tutor) {
        this.name = name;
        this.tutor = tutor;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Course course)) {
            return false;
        }
        return getId() == course.getId() && getName().equals(course.getName()) && getTutor().equals(course.getTutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getTutor());
    }
}
