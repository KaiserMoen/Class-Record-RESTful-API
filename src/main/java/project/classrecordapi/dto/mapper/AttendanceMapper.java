package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.AttendanceDto;
import project.classrecordapi.entities.Attendance;

public class AttendanceMapper {
    
    public static Attendance mapDtoToEntity(AttendanceDto attendanceDto,Attendance attendance){
        
        
        if(attendanceDto.getAbsentDate() != null) attendance.setAbsentDate(attendanceDto.getAbsentDate());
        if(attendanceDto.getIsExcused() != null) attendance.setIsExcused(attendanceDto.getIsExcused());
        if(attendanceDto.getReasonOfAbsence() != null)attendance.setReasonOfAbsence(attendanceDto.getReasonOfAbsence());

        return attendance;
    }
}
