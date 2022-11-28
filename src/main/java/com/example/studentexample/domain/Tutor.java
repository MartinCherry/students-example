package com.example.studentexample.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;

    public Tutor() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tutor tutor)) {
            return false;
        }
        return getId() == tutor.getId() && getName().equals(tutor.getName()) && getSurname().equals(tutor.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname());
    }
}
