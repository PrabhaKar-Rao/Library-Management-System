package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.Status;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository repo;
    @Override
    public String addStudent(Student student) {

        //Generate Card for Student
        Card card=new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidDate("2023-08-01");
        card.setStudent(student);

        //Set Card for Student
        student.setCard(card);
        repo.save(student);

        return "Student Card created";

    }

    @Override
    public String removeStudent(int studentId) {

        if(repo.existsById(studentId)){

            repo.deleteById(studentId);
            return "Student Removed Successfully";
        }
        else{
            return "No Student Available for the Given Id";
        }
    }

    @Override
    public String updateStudent(int studentId,String name) {

        if(repo.existsById(studentId)){

            Student student=repo.getReferenceById(studentId);
            student.setName(name);
            repo.save(student);
            return "Student Data Updated Successfully";
        }
        else{
            return "No Student is Available for Given Id ";
        }
    }

}
