package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Dto.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;

import java.util.List;

public interface BookService {

   public String addBook(AddBookRequestDto addBookRequestDto) throws AuthorNotFoundException;
}
