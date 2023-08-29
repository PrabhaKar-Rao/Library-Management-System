package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Dto.RequestDto.AddAuthorRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.FindAllAuthorsResponseDto;

import java.util.List;

public interface AuthorService {

    public String addAuthor(AddAuthorRequestDto addAuthorRequestDto);


    public List<FindAllAuthorsResponseDto> findAllAuthors();



}
