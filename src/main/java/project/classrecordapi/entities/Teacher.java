package project.classrecordapi.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer teacherId;
    
    @NonNull
    private String email;
    @NonNull
    private String password;
    private String teacherName;
    private String teacherMiddleName;
    private String teacherSurName;
    private Date teacherBirthDate;



    @JsonIgnore
    @OneToMany(mappedBy = "teacher" , cascade = CascadeType.ALL)
    private Set<Subject> subjects = new HashSet<Subject>();
    
    //Getters and Setters
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

        if (email != null)this.email = email;
        else throw new IllegalArgumentException("Email Should Not be Null");
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(password != null) this.password = password;
        else throw new IllegalArgumentException("Password Should Not be Null");
    }
    public Date getTeacherBirthDate() {
        return teacherBirthDate;
    }
    public void setTeacherBirthDate(Date teacherBirthDate) {
        this.teacherBirthDate = teacherBirthDate;
    }
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public String getTeacherSurName() {
        return teacherSurName;
    }
    public void setTeacherSurName(String teacherSurName) {
        this.teacherSurName = teacherSurName;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherMiddleName() {
        return teacherMiddleName;
    }
    public void setTeacherMiddleName(String teacherMiddleName) {
        this.teacherMiddleName = teacherMiddleName;
    }
    


}
