package project.classrecordapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.entities.Student;
import project.classrecordapi.service.StudentService;

@RestController
@RequestMapping("/user/student")
public class StudentController {
    
    @Autowired StudentService studentService;

    @PostMapping("new")
    public Student newStudent(@RequestBody Student student){
        return studentService.newStudent(student);
    }

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

   
}
