package com.mandiri.service;

import com.mandiri.entity.Student;
import com.mandiri.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetStudentService {

    private StudentRepository studentRepository;

    public GetStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

}
