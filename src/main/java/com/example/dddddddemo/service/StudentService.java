package com.example.dddddddemo.service;

import com.example.dddddddemo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> retrieveAllStudents();

    public Optional<Student> retrieveStudent(long id);

    public void deleteStudent(long id);

    public Student createStudent(Student student);
}
