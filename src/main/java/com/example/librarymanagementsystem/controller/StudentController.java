package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.service.StudentService;
import com.example.librarymanagementsystem.service.implementation.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }

    @PostMapping("/removeStudent")
    public String removeStudent(@RequestParam int studentId){

        return studentService.removeStudent(studentId);
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@RequestParam int studentId, @RequestParam String name){

        return studentService.updateStudent(studentId,name);
    }
}
