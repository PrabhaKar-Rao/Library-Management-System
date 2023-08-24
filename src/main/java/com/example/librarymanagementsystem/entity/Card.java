package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private Date issueDate;

    private Date validDate;

   // private Date validDate;

    @OneToOne
    @JoinColumn
    Student student;

}