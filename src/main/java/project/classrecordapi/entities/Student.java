package project.classrecordapi.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    

    @Id
    @NonNull private Integer learnersId;

    @NonNull
    private String studentName;
    private String studentMiddleName;
    @NonNull
    private String studentLastName;
    private Date studentBirthDate;
    private String fatherName;
    private String motherName;
    private Integer gradeLevel;


    //Relationship with the Attendance Entity(Will have the attendance of the Students on all their Subject)
    @JsonIgnore
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private Set<Attendance> attendances = new HashSet<>();
    
    //Relationship with Subject(A Student can have multiple Subject and vice versa)
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents",fetch = FetchType.EAGER)
    private Set<Subject> subject = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private Set<Scores> scores = new HashSet<>();
    //Getters and Setters

    public Set<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }
    public Integer getLearners_id() {
        return learnersId;
    }

    public void setLearners_id(Integer learners_id) {
        if(learners_id != null) this.learnersId = learners_id;
        else throw new IllegalArgumentException("Learners Id should not be null");
    }
    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public Date getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(Date studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }
    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        if(studentLastName != null) this.studentLastName = studentLastName;
        else throw new IllegalArgumentException("Last Name should not be null");
    }
    public String getStudentMiddleName() {
        return studentMiddleName;
    }

    public void setStudentMiddleName(String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
    }
    public Set<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Set<Subject> subject) {
        this.subject = subject;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName != null) this.studentName = studentName;
        else throw new IllegalArgumentException("FIrst Name should not be null");
    }

    

    
}
