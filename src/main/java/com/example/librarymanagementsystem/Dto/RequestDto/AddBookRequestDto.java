package com.example.librarymanagementsystem.Dto.RequestDto;

import com.example.librarymanagementsystem.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookRequestDto {

    private int authorId;

    private String bookTitle;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int noOfPages;

    private double price;
}
