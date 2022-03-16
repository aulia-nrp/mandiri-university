package com.mandiri.service;

import com.mandiri.response.ResponseMessage;
import com.mandiri.entity.Student;
import com.mandiri.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void createNew(Student student) {
        if(studentRepository.findByEmail(student.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format(ResponseMessage.USER_CONFLICT_BY_EMAIL));
        }
        studentRepository.save(student);
    }

    @Override
    public Student getById(String id) {
        if(!studentRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(ResponseMessage.RESOURCE_NOT_FOUND, Student.class.getSimpleName(),id));
        }
        return studentRepository.findById(id).get();
    }

    @Override
    public void removeById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(Student student) {
        getById(student.getId());
        studentRepository.save(student);
    }
}
