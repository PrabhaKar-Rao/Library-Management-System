package com.example.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name="author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    private String name;

    private int age;

    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> bookList=new ArrayList<>();

}
