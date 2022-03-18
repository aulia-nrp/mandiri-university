package com.mandiri.controller;

import com.mandiri.entity.Student;
import com.mandiri.service.DeleteStudentService;
import com.mandiri.service.GetStudentService;
import com.mandiri.service.PostStudentService;
import com.mandiri.service.PutStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private PostStudentService postStudentService;
    private GetStudentService getStudentService;
    private PutStudentService putStudentService;
    private DeleteStudentService deleteStudentService;

    public StudentController(PostStudentService postStudentService, GetStudentService getStudentService, PutStudentService putStudentService, DeleteStudentService deleteStudentService) {
        this.postStudentService = postStudentService;
        this.getStudentService = getStudentService;
        this.putStudentService = putStudentService;
        this.deleteStudentService = deleteStudentService;
    }

    @PostMapping("/student")
    public void registerStudent(@RequestBody Student student){
        postStudentService.createNew(student);
    }

    @DeleteMapping("/student/{id}")
    public void removeStudentById(@PathVariable String id){
        deleteStudentService.removeById(id);
    }

    @PutMapping("/student")
    public void updateStudentById(@RequestBody Student student){
        putStudentService.update(student);
    }

    @GetMapping("/students")
    public Page<Student> getAllStudents(@RequestParam(defaultValue = "10") Integer size,
                                        @RequestParam(defaultValue = "1") Integer page){
        Pageable pageable = PageRequest.of(page-1, size);
        return getStudentService.getAll(pageable);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id){
        return putStudentService.getById(id);
    }
}
