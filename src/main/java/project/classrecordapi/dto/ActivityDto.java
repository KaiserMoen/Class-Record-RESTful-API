package project.classrecordapi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ActivityDto {

    private String activityName;
    
    private Integer activityType;
   
    private Date activityStartDate;
    
    private String activityDescription;
    
    private Date activityDeadline;

    private Integer finalScore;
}
