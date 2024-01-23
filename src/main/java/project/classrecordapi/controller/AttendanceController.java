package project.classrecordapi.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.dto.AttendanceDto;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.service.AttendanceService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user/{userId}/subject/{subjectId}")
public class AttendanceController {
    
    @Autowired 
    AttendanceService attendanceService;

    @PostMapping("/{learnersId}/recordAbsent")
    public Attendance recordAbsent(@PathVariable Integer subjectId,@PathVariable Integer learnersId,@RequestBody Attendance attendance) {
        return attendanceService.setAttendanceRecord(subjectId,learnersId,attendance);
    }

    @DeleteMapping("/{learnersId}/delete/")
    public void deleteAbsent(@PathVariable Integer learnersId,@RequestParam Date date){
        attendanceService.deleteAttendanceRecord(learnersId, date);
    }

    @PatchMapping("/{learnersId}/update")
    public Attendance updateAttendance(@PathVariable Integer learnersId, @RequestBody AttendanceDto attendanceDto ,@RequestParam Date date){
        return attendanceService.updateAttendanceRecord(learnersId, attendanceDto,date);
    }
}
