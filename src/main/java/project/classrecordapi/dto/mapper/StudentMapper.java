package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.StudentDto;
import project.classrecordapi.entities.Student;

public class StudentMapper {
    public static Student mapDtoToEntity(StudentDto studentDto, Student student){
        if(studentDto.getFatherName()!= null) student.setFatherName(studentDto.getFatherName());
        if(studentDto.getGradeLevel()!= null) student.setGradeLevel(studentDto.getGradeLevel());
        if(studentDto.getMotherName()!=null) student.setMotherName(studentDto.getMotherName());
        if(studentDto.getStudentBirthDate()!=null) student.setStudentBirthDate(studentDto.getStudentBirthDate());
        if(studentDto.getStudentLastName()!=null) student.setStudentLastName(studentDto.getStudentLastName());
        if(studentDto.getStudentMiddleName()!=null) student.setStudentMiddleName(studentDto.getStudentMiddleName());
        if(studentDto.getStudentName()!=null) student.setStudentName(studentDto.getStudentName());
        return student;
    }
}
