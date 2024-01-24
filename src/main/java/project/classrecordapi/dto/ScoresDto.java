package project.classrecordapi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ScoresDto {
    
    private Date dateSubmitted;
    private Integer score;
    private String status;
}
