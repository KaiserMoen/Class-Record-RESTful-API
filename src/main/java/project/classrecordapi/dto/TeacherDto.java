package project.classrecordapi.dto;


import java.sql.Date;

import lombok.Data;

@Data
public class TeacherDto {
    

    private String email;
    private String password;
    private String teacherName;
    private String teacherMiddleName;
    private String teacherSurName;
    private Date teacherBirthDate;
}
