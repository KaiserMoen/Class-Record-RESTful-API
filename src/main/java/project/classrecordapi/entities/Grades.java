package project.classrecordapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Grades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradeId;

   
    @ManyToOne
    @JoinColumn(name = "learnersId" , referencedColumnName="learnersId")
    private Student student;

    
    @ManyToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private Subject subject;

    private String gradingName;
    
    private Integer semester;
    
    private Integer grade;



    public Integer getGradeId() {
        return gradeId;
    }
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGradingName() {
        return gradingName;
    }
    public void setGradingName(String gradingName) {
        this.gradingName = gradingName;
    }
    public Integer getSemester() {
        return semester;
    }
    public void setSemester(Integer semester) {
        this.semester = semester;
    }
    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

}
