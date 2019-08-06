package com.example.dddddddemo.controller;

import com.example.dddddddemo.entity.Student;
import com.example.dddddddemo.repository.StudentRepository;
import com.example.dddddddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentResourceController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentService.retrieveAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        Optional<Student> student = studentService.retrieveStudent(id);

        return student.get();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("successmessage!!",HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.noContent().build();
    }
}
