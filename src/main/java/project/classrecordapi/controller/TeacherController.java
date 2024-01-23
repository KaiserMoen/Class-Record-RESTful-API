package project.classrecordapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.dto.TeacherDto;
import project.classrecordapi.entities.Teacher;
import project.classrecordapi.service.TeacherService;

@RestController
@RequestMapping("/user")
public class TeacherController {
    @Autowired 
    private TeacherService teacherService;
    @PostMapping("/new")
    public Teacher newTeacher(@RequestBody Teacher teacher){
        return teacherService.newTeacher(teacher);
    }
    @GetMapping
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }
    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Integer teacherId){
        return teacherService.getTeacherById(teacherId);
    }
    @PatchMapping("/{teacherId}/update")
    public Teacher updateTeacher(@PathVariable Integer teacherId, @RequestBody TeacherDto teacherDto){
        return teacherService.updateTeacher(teacherId, teacherDto);
    }
    @DeleteMapping("/{teacherId}/delete")
    public void deleteTeacher(@PathVariable Integer teacherId){
        teacherService.deleteTeacher(teacherId);
    }

    @PutMapping("/{teacherId}/addSubject/{subjectId}")
    public void addSubjectToTeacher(@PathVariable Integer teacherId, @PathVariable Integer subjectId){
        teacherService.addSubjectToTeacher(teacherId,subjectId);
    }
}
