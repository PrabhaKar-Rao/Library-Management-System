package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.Dto.RequestDto.AddStudentDtoRequest;
import com.example.librarymanagementsystem.Dto.RequestDto.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.Dto.RequestDto.UpdateStudentMobileNumberRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.GetStudentByIdResponseDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.UpdateStudentMobResponseDto;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;

public interface StudentService {

  public String addStudent(AddStudentDtoRequest addPersonDto);

  public UpdateStudentMobResponseDto updateStudentMobileNumber(UpdateStudentMobileNumberRequestDto
                                                                      updatedStudentMobileNumber) throws StudentNotFoundException;

  public GetStudentByIdResponseDto getStudentById(GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException;
}
