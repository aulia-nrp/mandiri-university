package com.mandiri.controller;

import com.mandiri.entity.Student;
import com.mandiri.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void registerStudent(@RequestBody Student student){
        studentService.createNew(student);
    }

    @DeleteMapping("/student/{id}")
    public void removeStudentById(@PathVariable String id){
        studentService.removeById(id);
    }

    @PutMapping("/student")
    public void updateStudentById(@RequestBody Student student){
        studentService.update(student);
    }

    @GetMapping("/students")
    public Page<Student> getAllStudents(@RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(defaultValue = "1") Integer page){
        Pageable pageable = PageRequest.of(page-1, size);
        return studentService.getAll(pageable);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getById(id);
    }
}
