package com.example.studentexample;

import com.example.studentexample.controllers.MainController;
import com.example.studentexample.domain.Course;
import com.example.studentexample.domain.Student;
import com.example.studentexample.domain.Tutor;
import com.example.studentexample.dto.CourseRequest;
import com.example.studentexample.dto.StudentRequest;
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
    CourseRequest testCourseRequest = new CourseRequest();
    Student testStudent = new Student();
    StudentRequest testStudentRequest = new StudentRequest();


    @Mock
    MainService service;

    @InjectMocks
    MainController controller;

    @Test
    public void shouldVerifyAddTutor(){
        controller.addTutor(testTutor);
        verify(service).addTutor(testTutor);
    }
    @Test
    public void shoulVerifydAddCourse(){
        controller.addCourse(testCourseRequest);
        verify(service).addCourse(testCourseRequest);
    }
    @Test
    public void shouldVerifyAddStudent(){
        controller.addStudent(testStudent);
        verify(service).addStudent(testStudent);
    }
    @Test
    public void shouldVerifyAddStudentRequest(){
        controller.createFromRequest(testStudentRequest);
        verify(service).createStudentFromRequest(testStudentRequest);
    }
    @Test
    public void shouldVerifyAddCourseToStudent(){
        controller.addCourseToStudent(1, 1);
        verify(service).addCourseToStudent(1, 1);
    }
    @Test
    public void shouldVerifyReturnCourseList(){
        controller.getStudentsCourses(1);
        verify(service).getStudentsCourses(1);
    }
}
