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

import project.classrecordapi.dto.SubjectDto;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.service.SubjectService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/{userId}/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;


    @PostMapping("/new")
    public Subject newSubject(@RequestBody Subject subject,@PathVariable Integer userId){
        if(subject != null) return subjectService.newSubject(subject,userId);
        throw new NullPointerException("Subject is null");
    }
    @GetMapping
    public List<Subject> getAllSubject(@PathVariable Integer userId){
        return subjectService.getAllSubject(userId);
    }
    @PatchMapping("{subjectId}/update")
    public Subject updateSubject(@PathVariable Integer subjectId,@RequestBody SubjectDto subjectDto){
        return subjectService.updateSubject(subjectId,subjectDto);
    }

    @DeleteMapping("{subjectId}/delete")
    public String deleteSubject(@PathVariable Integer subjectId){
        subjectService.deleteSubject(subjectId);
        return "Subject Successfully deleted";
    }

     @PutMapping("{subjectId}/add/{studentId}")
    public Subject addStudentToSubject(@PathVariable Integer subjectId, @PathVariable Integer studentId){
        return subjectService.addStudentToSubject(subjectId, studentId);
    }

    @GetMapping("/{subjectId}/attendances")
    public List<Attendance> getAttendanceOfSubject(@PathVariable Integer subjectId){
        return subjectService.getAttendanceRecord(subjectId);
    }
    @GetMapping("/{subjectId}/attendances/month")
    public List<Attendance> getMethodName(@RequestParam Integer month, @PathVariable Integer subjectId) {
        return subjectService.getAttendanceRecord(subjectId, month);
    }
    
}
