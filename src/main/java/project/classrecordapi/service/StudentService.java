package project.classrecordapi.service;

import java.util.List;

import project.classrecordapi.dto.StudentDto;
import project.classrecordapi.entities.Student;

public interface StudentService {

    Student newStudent(Student student);

    List<Student> getAllStudent();
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    Student updateStudent(Integer studentId, StudentDto studentDto);
    
}
