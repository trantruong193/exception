package com.example.lsd2.persistant.repository.service;

import com.example.lsd2.persistant.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    <S extends Student> S save(S entity);

    void deleteById(Long aLong);

    void checkStudent(Student student);

    Optional<Student> findById(Long aLong);
}
