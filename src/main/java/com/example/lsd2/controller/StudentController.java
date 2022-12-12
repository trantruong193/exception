package com.example.lsd2.controller;

import com.example.lsd2.exception.ErrorCode;
import com.example.lsd2.exception.MyException;
import com.example.lsd2.persistant.entity.Student;
import com.example.lsd2.persistant.repository.service.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lsd2/students")
public class StudentController {
    public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentServiceImpl studentService;
    @GetMapping("")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @PostMapping("add")
    public List<Student> addStudent(@RequestBody Student student){
        studentService.checkStudent(student);
        studentService.save(student);
        LOGGER.info("StudentController save {}",student);
        return studentService.findAll();
    }
    @PostMapping("add/{id}")
    public List<Student> updateStudent(@RequestBody Student student,@PathVariable("id") Long id){
        studentService.findById(id).map(student1 -> {
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setPhone(student.getPhone());
            student1.setStatus(student.isStatus());
            return studentService.save(student1);
        }).orElseGet(()->{
            studentService.checkStudent(student);
            return studentService.save(student);
        });
        LOGGER.info("StudentController update Student with id: {} to {}",id,student);
        return studentService.findAll();
    }
    @GetMapping("delete/{id}")
    public List<Student> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
        LOGGER.info("StudentController delete Student with id: {}",id);
        return studentService.findAll();
    }
}
