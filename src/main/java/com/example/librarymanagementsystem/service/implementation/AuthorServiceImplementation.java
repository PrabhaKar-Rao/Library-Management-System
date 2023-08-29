package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.Dto.RequestDto.AddAuthorRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.FindAllAuthorsResponseDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<FindAllAuthorsResponseDto> findAllAuthors() {

        List<Author> author=authorRepository.findAll();


        List<FindAllAuthorsResponseDto> findAllAuthorsResponseDtoList=new ArrayList<FindAllAuthorsResponseDto>();

        for(Author authors:author){

            FindAllAuthorsResponseDto findAllAuthorsResponseDto=new FindAllAuthorsResponseDto();

            findAllAuthorsResponseDto.setAuthorId(authors.getAuthorId());
            findAllAuthorsResponseDto.setAge(authors.getAge());
            findAllAuthorsResponseDto.setEmail(authors.getEmail());

            findAllAuthorsResponseDtoList.add(findAllAuthorsResponseDto);
        }

        return findAllAuthorsResponseDtoList;
    }
}
