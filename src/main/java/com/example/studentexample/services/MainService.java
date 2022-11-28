package com.example.studentexample.services;

import com.example.studentexample.domain.Course;
import com.example.studentexample.domain.Student;
import com.example.studentexample.domain.Tutor;
import com.example.studentexample.dto.AddCourseRequest;
import com.example.studentexample.dto.AddStudentRequest;
import com.example.studentexample.repository.CourseRepository;
import com.example.studentexample.repository.StudentRepository;
import com.example.studentexample.repository.TutorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MainService {

    private final TutorRepository tutorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public MainService(TutorRepository tutorRepository, CourseRepository courseRepository,
                       StudentRepository studentRepository) {
        this.tutorRepository = tutorRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


    public void addTutor(Tutor tutor) {
        tutorRepository.save(tutor);
    }

    public Tutor getTutor(int id) {
        return tutorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor doesn't exist in DB"));
    }

    public Iterable<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }


    public void addCourse(AddCourseRequest addCourseRequest) {
        Tutor tutor = getTutor(addCourseRequest.getTutorId());

        Course course = new Course(addCourseRequest.getName(), tutor);
        courseRepository.save(course);
    }

    public Course getCourse(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course doesn't exist in DB"));
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }


    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student doesn't exist in DB"));
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createStudentFromRequest(AddStudentRequest request) {
        Course course = getCourse(request.getCourseId());
        Student student = new Student(request.getName(), request.getSurname());
        student.addCourse(course);
        studentRepository.save(student);
    }

    public void addCourseToStudent(int studentId, int courseId) {
        Course course = getCourse(courseId);
        Student student = getStudent(studentId);
        student.addCourse(course);
        studentRepository.save(student);
    }

    public List<String> getStudentsCourses(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student doesn't exist in DB"));
        return student.getCourses().stream().map(Course::toString).toList();
    }
}
