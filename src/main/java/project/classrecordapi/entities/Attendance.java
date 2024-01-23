package project.classrecordapi.entities;

import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;
    private Date absentDate;
    private String reasonOfAbsence;
    private Integer isExcused;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "learners_id", referencedColumnName = "learnersId")
    private Student student;

   
   
    //Getters and Setters
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Integer getIsExcused() {
        return isExcused;
    }
    public void setIsExcused(Integer isExcused) {
        this.isExcused = isExcused;
    }
    
    public String getReasonOfAbsence() {
        return reasonOfAbsence;
    }
    public void setReasonOfAbsence(String reasonOfAbsence) {
        this.reasonOfAbsence = reasonOfAbsence;
    }
    public Integer getAttendanceId() {
        return attendanceId;
    }
    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }
    public Date getAbsentDate() {
        return absentDate;
    }
    public void setAbsentDate(Date absentDate) {
        this.absentDate = absentDate;
    }
}
