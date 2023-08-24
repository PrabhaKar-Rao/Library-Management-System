package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public String addStudent(Student student );

    public String removeStudent(int studentId);

    public String updateStudent(int studentId,String name);

}
