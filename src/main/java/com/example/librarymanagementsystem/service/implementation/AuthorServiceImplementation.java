package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository repo;
    @Override
    public String addAuthor(Author author) {

        repo.save(author);
        return "Author Added Successfully";
    }
}
