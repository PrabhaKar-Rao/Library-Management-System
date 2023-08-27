package com.example.librarymanagementsystem.Dto.ResponseDto;

import com.example.librarymanagementsystem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetStudentByIdResponseDto {

    private String welcomeMsg;

    private int studentId;

    private String studentDept;

    private String MobileNumber;

}
