package com.mandiri.service;

import com.mandiri.entity.Student;
import com.mandiri.repository.StudentRepository;
import com.mandiri.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PutStudentService {

    private StudentRepository studentRepository;

    public PutStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getById(String id) {
        if(!studentRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ResponseMessage.RESOURCE_NOT_FOUND, Student.class.getSimpleName(),id));
        }
        return studentRepository.findById(id).get();
    }

    public void update(Student student) {
        getById(student.getId());
        studentRepository.save(student);
    }
}
