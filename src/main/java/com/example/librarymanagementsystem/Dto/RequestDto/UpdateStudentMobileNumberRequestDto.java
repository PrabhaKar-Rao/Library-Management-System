package com.example.librarymanagementsystem.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateStudentMobileNumberRequestDto {

    private int studentId;

    private String mobileNo;


}