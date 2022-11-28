package com.example.studentexample;

import com.example.studentexample.controllers.MainController;
import com.example.studentexample.domain.Course;
import com.example.studentexample.domain.Student;
import com.example.studentexample.domain.Tutor;
import com.example.studentexample.dto.AddCourseRequest;
import com.example.studentexample.dto.AddStudentRequest;
import com.example.studentexample.services.MainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    Tutor testTutor = new Tutor();
    Course testCourse = new Course();
    AddCourseRequest testAddCourseRequest = new AddCourseRequest();
    Student testStudent = new Student();
    AddStudentRequest testAddStudentRequest = new AddStudentRequest();


    @Mock
    MainService service;

    @InjectMocks
    MainController controller;

    @Test
    public void shouldVerifyAddTutor() {
        controller.addTutor(testTutor);
        verify(service).addTutor(testTutor);
    }

    @Test
    public void shoulVerifydAddCourse() {
        controller.addCourse(testAddCourseRequest);
        verify(service).addCourse(testAddCourseRequest);
    }

    @Test
    public void shouldVerifyAddStudent() {
        controller.addStudent(testStudent);
        verify(service).addStudent(testStudent);
    }

    @Test
    public void shouldVerifyAddStudentRequest() {
        controller.createFromRequest(testAddStudentRequest);
        verify(service).createStudentFromRequest(testAddStudentRequest);
    }

    @Test
    public void shouldVerifyAddCourseToStudent() {
        controller.addCourseToStudent(1, 1);
        verify(service).addCourseToStudent(1, 1);
    }

    @Test
    public void shouldVerifyReturnCourseList() {
        controller.getStudentsCourses(1);
        verify(service).getStudentsCourses(1);
    }
}
