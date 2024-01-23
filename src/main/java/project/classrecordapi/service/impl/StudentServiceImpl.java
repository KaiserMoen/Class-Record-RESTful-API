package project.classrecordapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.entities.Student;
import project.classrecordapi.repository.StudentRepository;
import project.classrecordapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired 
    private StudentRepository studentRepository;

    @Override
    public Student newStudent(Student student) {
        return student !=null ? studentRepository.save(student):null;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
        if(studentId == null) throw new IllegalArgumentException("Student Id is null");
        Optional<Student> optinalStudent= studentRepository.findById(studentId);
        if(optinalStudent.isPresent()) return optinalStudent.get();
        else throw new NoSuchElementException("Student with the ID + " + studentId+" is not Found.");
    }

    // @Override
    // public void deleteStudentById(Integer studentId) {
    //     Optional<Student> optinalStudent= studentRepository.findById(studentId);
    //     if(optinalStudent.isPresent())  studentRepository.delete(optinalStudent.get());
    //     else throw new NoSuchElementException("Student with the ID + " + studentId+" is not Found.");
    // }

    // @Override
    // public void deleteAllStudent() {
    //    studentRepository.deleteAll();
    // }
    
}
