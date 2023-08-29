package com.example.librarymanagementsystem.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FindAllAuthorsResponseDto {

    private int authorId;

    private String name;

    private int age;

    private String email;
}
