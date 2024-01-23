package project.classrecordapi.service;

import java.util.List;

import project.classrecordapi.dto.SubjectDto;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.entities.Subject;


public interface SubjectService {

    Subject newSubject(Subject subject,Integer teacherId);

    List<Subject> getAllSubject(Integer teacherId);

    Subject updateSubject(Integer subjectId, SubjectDto subjectDto);

    void deleteSubject(Integer subjectId);

    Subject addStudentToSubject(Integer subjectId, Integer studentId);

    List<Attendance> getAttendanceRecord(Integer subjectId);

    List<Attendance> getAttendanceRecord(Integer subjectId, Integer month);
    
}
