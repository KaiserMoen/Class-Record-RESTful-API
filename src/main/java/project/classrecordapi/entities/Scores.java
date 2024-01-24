package project.classrecordapi.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scoreId;

    
    @ManyToOne
    @JoinColumn(name = "activityId" , referencedColumnName = "activityId")
    private Activity activity;

   
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "learnersId", referencedColumnName = "learnersId")
    private Student student;

    private Date dateSubmitted;
    
    private Integer score;
    private String status = "Not yet Submitted";
   
    
    //Getters and Setters
    public Integer getScoreId() {
        return scoreId;
    }
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }
    public Activity getActivity() {
        return activity;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Date getDateSubmitted() {
        return dateSubmitted;
    }
    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
