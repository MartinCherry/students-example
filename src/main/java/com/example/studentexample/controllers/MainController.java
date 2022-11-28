package com.example.studentexample.controllers;

import com.example.studentexample.domain.Course;
import com.example.studentexample.domain.Student;
import com.example.studentexample.domain.Tutor;
import com.example.studentexample.dto.CourseRequest;
import com.example.studentexample.dto.StudentRequest;
import com.example.studentexample.services.MainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    @PostMapping("/addTutor")
    public void addTutor(@RequestBody Tutor tutor) {
        service.addTutor(tutor);
    }

    @GetMapping("getTutors/{id}")
    public Tutor getTutor(@PathVariable int id) {
        return service.getTutor(id);
    }

    @GetMapping("/getTutors")
    public Iterable<Tutor> getAllTutors() {
        return service.getAllTutors();
    }


    @PostMapping("/addCourse")
    public void addCourse(@RequestBody CourseRequest courseRequest) {
        service.addCourse(courseRequest);
    }

    @GetMapping("/getCourses/{id}")
    public Course getCourse(@PathVariable int id) {
        return service.getCourse(id);
    }


    @GetMapping("/getCourses")
    public Iterable<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @PostMapping("/addStudent/")
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }


    @GetMapping("/getStudents/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudent(id);
    }

    @GetMapping("/getStudents")
    public Iterable<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping("/addStudentRequest")
    public void createFromRequest(@RequestBody StudentRequest request) {
        service.createStudentFromRequest(request);
    }

    @PostMapping("/{studentId}/{courseId}")
    public void addCourseToStudent(@PathVariable int studentId, @PathVariable int courseId) {
        service.addCourseToStudent(studentId, courseId);
    }

    @GetMapping("getStudentCourses/{id}")
    public List<String> getStudentsCourses(@PathVariable int id) {
        return service.getStudentsCourses(id);
    }
}
