package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.Status;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository repo;
    @Override
    public String addStudent(Student student) {

        //Generate Card for Student
        Card card=new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidDate(new Date("2023-08-01"));
        card.setStudent(student);

        //Set Card for Student
        student.setCard(card);
        repo.save(student);

        return "Student Card created";

    }
}
