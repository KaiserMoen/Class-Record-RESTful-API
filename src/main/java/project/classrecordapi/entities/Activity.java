package project.classrecordapi.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

    
    @ManyToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private Subject subject;
    
    private String activityName;
    
    //Written = 0 , Performance Task = 1, Exam = 2
    private Integer activityType;

    private String activityDescription;
   
    private Date activityStartDate;
    
    private Date activityDeadline;

    private Integer finalScore;
    
    @JsonIgnore
    @OneToMany(mappedBy = "activity" , cascade = CascadeType.ALL)
    private Set<Scores> scores = new HashSet<>();

    //Getters and Setters
    public Integer getActivityId() {
        return activityId;
    }
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
     
    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public Integer getActivityType() {
        return activityType;
    }
    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
    public Date getActivityStartDate() {
        return activityStartDate;
    }
    public void setActivityStartDate(Date activityStartDate) {
        this.activityStartDate = activityStartDate;
    }
    public Date getActivityDeadline() {
        return activityDeadline;
    }
    public void setActivityDeadline(Date activityDeadline) {
        this.activityDeadline = activityDeadline;
    }
    public Integer getFinalScore() {
        return finalScore;
    }
    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }
    public String getActivityDescription() {
        return activityDescription;
    }
    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }
}
