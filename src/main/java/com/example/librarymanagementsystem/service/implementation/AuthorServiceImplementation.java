package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.Dto.RequestDto.AddAuthorRequestDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AddAuthorRequestDto addAuthorRequestDto) {

        Author author =new Author();
        author.setAge(addAuthorRequestDto.getAge());
        author.setEmail(addAuthorRequestDto.getEmail());
        author.setName(addAuthorRequestDto.getName());

        authorRepository.save(author);

        return "Author Added Successfully";
    }
}
