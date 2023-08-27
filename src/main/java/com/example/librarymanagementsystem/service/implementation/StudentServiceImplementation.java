package com.example.librarymanagementsystem.service.implementation;

import com.example.librarymanagementsystem.Dto.RequestDto.AddStudentDtoRequest;
import com.example.librarymanagementsystem.Dto.RequestDto.GetStudentByIdRequestDto;
import com.example.librarymanagementsystem.Dto.RequestDto.UpdateStudentMobileNumberRequestDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.GetStudentByIdResponseDto;
import com.example.librarymanagementsystem.Dto.ResponseDto.UpdateStudentMobResponseDto;
import com.example.librarymanagementsystem.entity.Card;
import com.example.librarymanagementsystem.entity.Student;
import com.example.librarymanagementsystem.enums.Status;
import com.example.librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(AddStudentDtoRequest addPersonDto) {

        Student student = new Student();
        student.setName(addPersonDto.getName());
        student.setAge(addPersonDto.getAge());
        student.setDepartment(addPersonDto.getDepartment());
        student.setMobileNo(addPersonDto.getMobileNo());

        Card card = new Card();
        card.setStatus(Status.ACTIVE);
        card.setValidDate("25-08-2030");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student Added Successfully";

    }

    @Override
    public UpdateStudentMobResponseDto updateStudentMobileNumber(UpdateStudentMobileNumberRequestDto
                                                                             updateStudentMobileNumberRequestDto) throws StudentNotFoundException {

        try{
            Student student=studentRepository.findById(updateStudentMobileNumberRequestDto.getStudentId()).get();
            student.setMobileNo(updateStudentMobileNumberRequestDto.getMobileNo());
            Student updatedStudent=studentRepository.save(student);

            UpdateStudentMobResponseDto updateStudentMobResponseDto=new UpdateStudentMobResponseDto();
            updateStudentMobResponseDto.setUpdatedStudentMobileNumber(updatedStudent.getMobileNo());
            updateStudentMobResponseDto.setName(updatedStudent.getName());
            return updateStudentMobResponseDto;
        }catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public GetStudentByIdResponseDto getStudentById(GetStudentByIdRequestDto getStudentByIdRequestDto) throws StudentNotFoundException {

        try{

            Student student =studentRepository.findById(getStudentByIdRequestDto.getStudentId()).get();
            GetStudentByIdResponseDto getStudentByIdResponseDto=new GetStudentByIdResponseDto();
            getStudentByIdResponseDto.setWelcomeMsg("Welcome "+student.getName()+" And your Id is"
                    +student.getStudentId());
            getStudentByIdResponseDto.setStudentDept(String.valueOf(student.getDepartment()));
            getStudentByIdResponseDto.setStudentId(student.getStudentId());
            getStudentByIdResponseDto.setMobileNumber(student.getMobileNo());
            return getStudentByIdResponseDto;

        }catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }

    }

}
