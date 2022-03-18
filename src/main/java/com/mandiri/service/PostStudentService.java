package com.mandiri.service;

import com.mandiri.entity.Student;
import com.mandiri.repository.StudentRepository;
import com.mandiri.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PostStudentService {
    private StudentRepository studentRepository;

    public PostStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createNew(Student student) {
        if(studentRepository.findByEmail(student.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format(ResponseMessage.USER_CONFLICT_BY_EMAIL));
        }
        studentRepository.save(student);
    }
}
