package com.example.lsd2.persistant.repository.service;

import com.example.lsd2.exception.ErrorCode;
import com.example.lsd2.exception.MyException;
import com.example.lsd2.persistant.entity.Student;
import com.example.lsd2.persistant.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public <S extends Student> S save(S entity) {
        return studentRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public void checkStudent(Student student){
        studentRepository.findAll().forEach(student1 -> {
            if (student1.getEmail().equals(student.getEmail()))
                throw new MyException(ErrorCode.DUPLICATE_EMAIL);
            if (student1.getPhone().equals(student.getPhone()))
                throw new MyException(ErrorCode.DUPLICATE_PHONE);
        });
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }
}
