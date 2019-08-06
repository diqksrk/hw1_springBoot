package com.example.dddddddemo.service;

import com.example.dddddddemo.entity.Student;
import com.example.dddddddemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> retrieveStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
