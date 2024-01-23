package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.TeacherDto;
import project.classrecordapi.entities.Teacher;

public class TeacherMapper {

    public static Teacher mapDtoToEntity(TeacherDto teacherDto, Teacher teacher) {
        if(teacherDto.getEmail()!= null) teacher.setEmail(teacherDto.getEmail());
        if(teacherDto.getPassword()!=null) teacher.setPassword(teacherDto.getPassword());
        if(teacherDto.getTeacherBirthDate()!=null) teacher.setTeacherBirthDate(teacherDto.getTeacherBirthDate());
        if(teacherDto.getTeacherName()!=null) teacher.setTeacherName(teacherDto.getTeacherName());
        if(teacherDto.getTeacherSurName()!=null) teacher.setTeacherSurName(teacherDto.getTeacherSurName());
        if(teacherDto.getTeacherMiddleName()!=null) teacher.setTeacherMiddleName(teacherDto.getTeacherMiddleName());
        
        return teacher;
    }
}
