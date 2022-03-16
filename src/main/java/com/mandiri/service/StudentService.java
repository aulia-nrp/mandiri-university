package com.mandiri.service;

import com.mandiri.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface StudentService {
    public Page<Student> getAll(Pageable pageable);
    public void createNew(Student student);
    public Student getById(String id);
    public void removeById(String id);
    public void update(Student student);
}
