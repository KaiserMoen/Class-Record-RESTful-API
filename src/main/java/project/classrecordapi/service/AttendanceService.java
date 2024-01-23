package project.classrecordapi.service;

import java.sql.Date;

import project.classrecordapi.dto.AttendanceDto;
import project.classrecordapi.entities.Attendance;

public interface AttendanceService {

    
    Attendance setAttendanceRecord(Integer subjectId, Integer learnersId,Attendance attendance);
    void deleteAttendanceRecord(Integer learnersId, Date date);
    Attendance updateAttendanceRecord(Integer learnersId,AttendanceDto attendanceDto,Date date);
}
