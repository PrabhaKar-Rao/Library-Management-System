package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String mobileNo;

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    Card card;
}
