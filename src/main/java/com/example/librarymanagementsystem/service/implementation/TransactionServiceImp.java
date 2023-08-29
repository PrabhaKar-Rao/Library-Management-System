package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.Dto.RequestDto.IssueBookRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.IssueBookResponseDto;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Transaction;
import com.example.librarymanagementsystem.enums.Status;
import com.example.librarymanagementsystem.enums.TransactionStatus;
import com.example.librarymanagementsystem.exceptions.BookNotFoundException;
import com.example.librarymanagementsystem.exceptions.CardNotFoundException;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.CardRepository;
import com.example.librarymanagementsystem.repository.TransactionRepository;
import com.example.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction=new Transaction();
        transaction.setIssueOperation(true);
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));


        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new BookNotFoundException("Invalid Book Id for Issue Book");
        }

        transaction.setBook(book);

        Card card;

        try{

            card=cardRepository.findById(issueBookRequestDto.getCardId()).get();

        }catch(Exception e){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new CardNotFoundException("Card Not Found Issue a Book");
        }

        transaction.setCard(card);

        if(card.getStatus()!= Status.ACTIVE){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card Is Not Active");
        }

        if(book.isIssued()){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is Already Issued");

        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getListOfBooksIssued().add(book);
        card.getListOfTransactions().add(transaction);

        cardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getBookTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;
    }
}
