package com.example.studentexample;

import com.example.studentexample.domain.Course;
import com.example.studentexample.domain.Student;
import com.example.studentexample.domain.Tutor;
import com.example.studentexample.repository.CourseRepository;
import com.example.studentexample.repository.StudentRepository;
import com.example.studentexample.repository.TutorRepository;
import com.example.studentexample.services.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MainServiceTest {

    @Mock
    StudentRepository studentRepository;
    
    @Mock
    TutorRepository tutorRepository;
    
    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    MainService service;

    @Test
    public void shouldThrowErrorWhenTutorNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> service.getTutor(1));
        Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
    }
    @Test
    public void shouldThrowErrorWhenCourseNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> service.getCourse(1));
        Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void shouldThrowErrorWhenStudentNotFound() {
        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> service.getStudent(1));
        Assertions.assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void shouldReturnCourses(){
        Student testStudent = createStudent();

        Mockito.doAnswer(invocation -> Optional.of(testStudent)).when(studentRepository).findById(1);
        Student returnStudent = service.getStudent(1);
        List<String> expectedResult = testStudent.getCoursesToStringList();

        Assertions.assertEquals(expectedResult, returnStudent.getCoursesToStringList());
    }

    public Tutor createTutor(){
        Tutor tutor = new Tutor();
        tutor.setName("John");
        tutor.setSurname("Smith");
        return tutor;
    }

    public Course createCourse(){
        Course course = new Course();
        course.setName("IT");
        course.setTutor(createTutor());
        return course;
    }

    public Student createStudent(){
        Student student = new Student();
        student.setName("Martins");
        student.setSurname("Kirsis");
        for (int i = 0; i < 5; i ++) {
            student.addCourse(createCourse());
        }
        return student;
    }

}
