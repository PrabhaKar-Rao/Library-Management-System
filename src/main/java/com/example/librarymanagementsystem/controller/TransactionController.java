package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Dto.RequestDto.IssueBookRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.IssueBookResponseDto;
import com.example.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/issueBook")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        return transactionService.issueBook(issueBookRequestDto);
    }
}
