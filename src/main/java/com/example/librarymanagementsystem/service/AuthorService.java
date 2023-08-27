package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Dto.RequestDto.AddAuthorRequestDto;
import com.example.librarymanagementsystem.entity.Author;

public interface AuthorService {

    public String addAuthor(AddAuthorRequestDto addAuthorRequestDto);

}
