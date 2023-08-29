package com.example.librarymanagementsystem.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookRequestDto {

    private int bookId;

    private int cardId;
}
