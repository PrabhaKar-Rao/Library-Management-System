package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.Dto.RequestDto.AddStudentDtoRequest;
import com.example.librarymanagementsystem.Dto.RequestDto.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.Dto.RequestDto.UpdateStudentMobileNumberRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.GetStudentByIdResponseDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.UpdateStudentMobResponseDto;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody AddStudentDtoRequest addStudentDtoRequest){

       return  studentService.addStudent(addStudentDtoRequest);

    }

    @PutMapping("/update_student_mob")
    public UpdateStudentMobResponseDto updateStudentMobileNumber(@RequestBody UpdateStudentMobileNumberRequestDto
                                                                        updateStudentMobileNumberRequestDto) throws StudentNotFoundException {
      return studentService.updateStudentMobileNumber(updateStudentMobileNumberRequestDto);
    }

    @GetMapping("/get")
   public GetStudentByIdResponseDto getStudentById(@RequestBody GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException {

        return studentService.getStudentById(getStudentByIdRequestDto);
   }
}
