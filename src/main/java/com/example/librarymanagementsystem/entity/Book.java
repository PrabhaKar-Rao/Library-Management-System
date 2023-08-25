package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookTitle;

    private Genre genre;

    private int noOfPages;

    private double price;

    @ManyToOne
    @JoinColumn
    Author author;


}
