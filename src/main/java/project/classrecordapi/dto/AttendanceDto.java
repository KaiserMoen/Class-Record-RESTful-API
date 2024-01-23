package project.classrecordapi.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AttendanceDto {
    private Date absentDate;
    private String reasonOfAbsence;
    private Integer isExcused;
}
