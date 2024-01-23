package project.classrecordapi.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    //Relationship with the Teacher Entity
    @ManyToOne
    @JoinColumn(name = "teacher_id" , referencedColumnName = "teacherId")
    private Teacher teacher;

    //Relationship with the Student Entity (A Subject can Have multiple Student and vice versa)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_enrolled",
        joinColumns ={@JoinColumn(name = "subjectId",referencedColumnName = "subjectId")},
        inverseJoinColumns = {@JoinColumn(name = "learnersId",referencedColumnName = "learnersId")}
    )    
    private Set<Student> enrolledStudents = new HashSet<>();

    //Relationship with the Attentance Entity(A subject will have Multiple Attendances of the students)
    @OneToMany(mappedBy = "subject" , cascade = CascadeType.ALL)
    private Set<Attendance> attendances = new HashSet<>();

    //Relationsip with the Activity Entity(A subject will have multiple Activities)
    @OneToMany(mappedBy = "subject" , cascade = CascadeType.ALL)
    private Set<Activity> activities = new HashSet<>();

    

    @NonNull
    private String subjectCode;
    private String subjectName;
    @NonNull
    private Date subjectStartDate;
    @NonNull
    private Date subjectEndDate;

    //Setters and Getters
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
    public Date getSubjectEndDate() {
        return subjectEndDate;
    }

    public void setSubjectEndDate(Date subjectEndDate) {

        if(subjectEndDate != null ) this.subjectEndDate = subjectEndDate;
        else throw new IllegalArgumentException("End Date should not be null");
    }

    public Date getSubjectStartDate() {
        return subjectStartDate;
    }

    public void setSubjectStartDate(Date subjectStartDate) {
        if(subjectStartDate != null) this.subjectStartDate = subjectStartDate;
        else  throw new IllegalArgumentException("Start Date should not be null");
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        if (subjectCode != null) this.subjectCode = subjectCode;
        else throw new IllegalArgumentException("Subject Code Name should not be null");
    }
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}
