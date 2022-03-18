package com.mandiri.service;

import com.mandiri.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentService {
    private StudentRepository studentRepository;

    public DeleteStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void removeById(String id) {
        studentRepository.deleteById(id);
    }

}
