package project.classrecordapi.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import project.classrecordapi.dto.SubjectDto;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.entities.Grades;
import project.classrecordapi.entities.Student;
import project.classrecordapi.entities.Subject;


public interface SubjectService {

    Subject newSubject(Subject subject,Integer teacherId);

    List<Subject> getAllSubject(Integer teacherId);

    Subject updateSubject(Integer subjectId, SubjectDto subjectDto);

    void deleteSubject(Integer subjectId);

    Set<Student> getAllEnrolledStudent(Integer subjectId);

    Subject addStudentToSubject(Integer subjectId, Integer studentId);

    List<Attendance> getAttendanceRecord(Integer subjectId);

    List<Attendance> getAttendanceRecord(Integer subjectId, Integer month);

    Set<Grades> calculateGrades(Integer subjectId, Integer[] gradeRatio, Date starDate, Date endDate,Integer semester, String gradeName);

}
