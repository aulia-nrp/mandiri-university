package com.mandiri.repository;

import com.mandiri.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    public Optional<Student> findByEmail(String email);
}
