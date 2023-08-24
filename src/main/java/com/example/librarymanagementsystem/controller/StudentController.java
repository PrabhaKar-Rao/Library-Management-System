package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.service.StudentService;
import com.example.librarymanagementsystem.service.implementation.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }


}
