package project.classrecordapi.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class SubjectDto {
    private String subjectCode;
    private String subjectName;
    private Date subjectStartDate;
    private Date subjectEndDate;
}
