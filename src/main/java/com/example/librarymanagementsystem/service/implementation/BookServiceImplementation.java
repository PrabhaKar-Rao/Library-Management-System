package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.Dto.RequestDto.AddBookRequestDto;
import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.exceptions.AuthorNotFoundException;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {


    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public String addBook(AddBookRequestDto addBookRequestDto) throws AuthorNotFoundException {

        try{
            Author author=authorRepository.findById(addBookRequestDto.getAuthorId()).get();

            Book book=new Book();
            book.setBookTitle(addBookRequestDto.getBookTitle());
            book.setPrice(addBookRequestDto.getPrice());
            book.setGenre(addBookRequestDto.getGenre());
            book.setAuthor(author);

            bookRepository.save(book);

            return "Book Added Successfully";

        }catch(Exception e){

            throw new AuthorNotFoundException("Invalid Author Id");
        }
    }
}
