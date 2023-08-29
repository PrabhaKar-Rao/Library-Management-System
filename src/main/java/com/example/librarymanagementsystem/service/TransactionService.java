package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Dto.RequestDto.IssueBookRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.IssueBookResponseDto;
import com.example.librarymanagementsystem.exceptions.BookNotFoundException;
import com.example.librarymanagementsystem.exceptions.CardNotFoundException;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
