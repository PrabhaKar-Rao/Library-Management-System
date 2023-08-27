package com.example.librarymanagementsystem.Dto.RequestDto;

import com.example.librarymanagementsystem.enums.Department;
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
public class AddStudentDtoRequest {

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String mobileNo;
}
