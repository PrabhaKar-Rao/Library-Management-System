package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Dto.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody AddBookRequestDto addBookRequestDto) throws AuthorNotFoundException {

        return bookService.addBook(addBookRequestDto);
    }


}
