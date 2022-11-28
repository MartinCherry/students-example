package com.example.studentexample.repository;

import com.example.studentexample.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
