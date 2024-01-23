package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.SubjectDto;
import project.classrecordapi.entities.Subject;

public class SubjectMapper {
    public static Subject mapDtoToEntity(SubjectDto subjectDto, Subject subject) {
        if(subjectDto.getClass()!=null) subject.setSubjectCode(subjectDto.getSubjectCode());
        if(subjectDto.getSubjectStartDate()!=null) subject.setSubjectStartDate(subjectDto.getSubjectStartDate());
        if(subjectDto.getSubjectEndDate()!= null) subject.setSubjectEndDate(subjectDto.getSubjectEndDate());
        if(subjectDto.getSubjectName()!=null) subject.setSubjectName(subjectDto.getSubjectName());
        return subject;
    }
}   
