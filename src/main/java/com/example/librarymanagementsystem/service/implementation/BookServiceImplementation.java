package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.entity.Author;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    AuthorRepository repo;

    @Override
    public String addBook(Book book) throws Exception {

        Author author;

        try{
            author=repo.findById(book.getAuthor().getAuthorId()).get();
        }catch(Exception e) {

            throw new Exception("Author Not Found Exception");
        }

        author.getBookList().add(book);
        book.setAuthor(author);
        repo.save(author);

        return "Book Added Successfully";
    }
}
