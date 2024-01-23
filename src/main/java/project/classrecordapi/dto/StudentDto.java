package project.classrecordapi.dto;

import java.sql.Date;


import lombok.Data;

@Data
public class StudentDto {

    private String studentName;
    private String studentMiddleName;
    private String studentLastName;
    private Date studentBirthDate;
    private String fatherName;
    private String motherName;
    private Integer gradeLevel;
}
