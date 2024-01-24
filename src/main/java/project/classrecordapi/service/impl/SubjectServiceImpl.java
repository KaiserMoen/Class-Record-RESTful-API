package project.classrecordapi.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project.classrecordapi.dto.SubjectDto;
import project.classrecordapi.dto.mapper.SubjectMapper;
import project.classrecordapi.entities.Activity;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.entities.Grades;
import project.classrecordapi.entities.Scores;
import project.classrecordapi.entities.Student;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.entities.Teacher;
import project.classrecordapi.repository.AttendanceRepository;
import project.classrecordapi.repository.GradesRepository;
import project.classrecordapi.repository.ScoresRepository;
import project.classrecordapi.repository.StudentRepository;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.repository.TeacherRespository;
import project.classrecordapi.service.SubjectService;


@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    TeacherRespository teacherRespository;

    @Autowired
    ScoresRepository scoreRepository;

    @Autowired
    GradesRepository gradesRepository;
    
    @Override
    public Subject newSubject(Subject subject , Integer teacherId) {
        Teacher teacher;
        if(teacherId == null) throw new IllegalArgumentException("The teacher Id is null");
        else{
            
            Optional<Teacher> optionalTeacher  = teacherRespository.findById(teacherId);
            if(optionalTeacher.isPresent())  teacher = optionalTeacher.get();
            else throw new NoSuchElementException("Teacher with the ID " + teacherId + " is not Found.");
        }
        if(subject == null) throw new IllegalArgumentException("Subject is null");
        else{
            subject.setTeacher(teacher);
            subject = subjectRepository.save(subject);
        }
    
        return subject;
    }
    @Override
    public List<Subject> getAllSubject(Integer teacherId) {
        return subjectRepository.findByTeacherTeacherId(teacherId);
    }
    @Override
    public Subject updateSubject(Integer subjectId, SubjectDto subjectDto) {
        // Objects.requireNonNull(subjectId, "Subject Id is null");
        
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is null");
        Optional<Subject> oSubject = subjectRepository.findById(subjectId);
        if(!oSubject.isPresent()) throw new NoSuchElementException("Subject with the ID "+subjectId +" is not found");
        Subject subject = SubjectMapper.mapDtoToEntity(subjectDto, oSubject.get());
        if (subject == null) throw new NullPointerException("Mapping failed and returned Null value");
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is null");
        Optional<Subject> oSubject = subjectRepository.findById(subjectId);
        if(!oSubject.isPresent()) throw new NoSuchElementException("Subject with the ID "+subjectId +" is not found");
        Subject subject = oSubject.get();
        if (subject == null) throw new NullPointerException("Subject is null");
        subjectRepository.delete(subject);

    }
   

    @Override
    public Set<Student> getAllEnrolledStudent(Integer subjectId){
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is null");
        return studentRepository.findBySubjectSubjectId(subjectId);
    }
    @Override
    @Transactional
    public Subject addStudentToSubject(Integer subjectId, Integer studentId){
        Subject subject;
        Student student;
        if(subjectId == null) throw new IllegalArgumentException("The Subject Id is null");
        if(studentId == null) throw new IllegalArgumentException("The Student Id is null");

        Optional<Subject> subOptional =subjectRepository.findById(subjectId);
        if(subOptional.isPresent()) subject = subOptional.get();
        else throw new NoSuchElementException("Subject with the ID "  + subjectId+ " is not Found.");
       
        Optional<Student> studOptional = studentRepository.findById(studentId);
        if(studOptional.isPresent()) student =studOptional.get();
        else throw new NoSuchElementException("Student with the ID "  + studentId+ " is not Found.");
        
        
        Set<Activity> activities = subject.getActivities();
        for(Activity a : activities){
            Scores score = new Scores();
            score.setStudent(student);
            score.setActivity(a);
            score.setDateSubmitted(null);
            score.setScore(null);
            score.setStatus(score.getStatus());
            scoreRepository.save(score);
        }
        subject.getEnrolledStudents().add(student);
        Subject s =  subjectRepository.saveAndFlush(subject);
        return s;
    } 

    public void addSubjectToTeacher(Integer teacherId, Integer subjectId){
        Teacher t;
        Subject s;
        if(teacherId != null){
            Optional<Teacher> optionalTeacher  = teacherRespository.findById(teacherId);
            if(optionalTeacher.isPresent())  t = optionalTeacher.get();
            else throw new NoSuchElementException("Teacher with the ID " + teacherId + " is not Found.");
        }else throw new IllegalArgumentException("Teacher Id is null");
        
        if(subjectId == null) throw new IllegalArgumentException("subject Id is null");
        else{
            Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
            if(optionalSubject.isPresent())  s = optionalSubject.get();
            else throw new NoSuchElementException("Subject with the ID "  + subjectId+ " is not Found.");
        }
        
        s.setTeacher(t);
        subjectRepository.saveAndFlush(s);
    }
    @Override
    public List<Attendance> getAttendanceRecord(Integer subjectId) {
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is Null");
        return attendanceRepository.findBySubjectSubjectId(subjectId);
        
    }
    @Override
    public List<Attendance> getAttendanceRecord(Integer subjectId, Integer month) {
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is Null");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1); // Month is 0-based in Calendar

        // Set the start and end dates for the given month
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date endDate = calendar.getTime();
        
        return attendanceRepository.findBySubjectSubjectIdAndAbsentDateBetween(subjectId, startDate, endDate);
    }

    @Override
    public Set<Grades> calculateGrades(Integer subjectId, Integer[] gradeRatio, Date startDate, Date endDate, Integer semester, String gradeName){
        if(subjectId == null) throw new IllegalArgumentException("subject Id is null");
        Optional<Subject> oSubject = subjectRepository.findById(subjectId);
        if(!oSubject.isPresent()) throw new NoSuchElementException("Subject with the ID "+subjectId +" is not found");
        Subject subject = oSubject.get();

        for(Student student : subject.getEnrolledStudents()){
            Double grade = calculateStudentGrade(subject,student,gradeRatio,startDate,endDate);
            Grades grades = new Grades();
            grades.setGrade(grade);
            grades.setSemester(semester);                
            grades.setGradingName(gradeName);
            grades.setStudent(student);
            grades.setSubject(subject);
            gradesRepository.save(grades);
        }
        return null;
    }

    private Double calculateStudentGrade(Subject subject, Student student, Integer[] gradeRatio ,Date startDate, Date endDate){
        Double currGrade = 0.0;
        for(int i = 0 ; i < 3; i++){
            Set<Scores> scores = scoreRepository.findByActivitySubjectSubjectIdAndActivityActivityTypeAndStudentLearnersIdAndActivityActivityStartDateBetween(
                subject.getSubjectId(), i, student.getLearners_id(), startDate, endDate);
            Double currScore = 0.0;
            Double totalActivitiesScore = 0.0;
            for(Scores s : scores){
                currScore += s.getScore();
                totalActivitiesScore += s.getActivity().getFinalScore();
            }
            currGrade += (currScore/totalActivitiesScore) * gradeRatio[i];
           
        }
        System.out.println("currGrade: " +currGrade);
        return currGrade;
    }
   
}
