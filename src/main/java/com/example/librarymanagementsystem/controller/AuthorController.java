package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Dto.RequestDto.AddAuthorRequestDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

  @Autowired
  AuthorService authorService;
  @PostMapping("/add")
  public String addAuthor(@RequestBody AddAuthorRequestDto addAuthorRequestDto){

      return authorService.addAuthor(addAuthorRequestDto);
  }
}
