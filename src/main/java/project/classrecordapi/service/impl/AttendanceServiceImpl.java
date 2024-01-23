package project.classrecordapi.service.impl;

import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.dto.AttendanceDto;
import project.classrecordapi.dto.mapper.AttendanceMapper;
import project.classrecordapi.entities.Attendance;
import project.classrecordapi.entities.Student;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.repository.AttendanceRepository;
import project.classrecordapi.repository.StudentRepository;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired SubjectRepository subjectRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

   
    @Override
    public Attendance setAttendanceRecord(Integer subjectId, Integer learnersId, Attendance attendance) {
        Subject subject;
        Student student;
        if(learnersId == null) throw new IllegalArgumentException("The Learners Id is null");
        else{
            Optional<Student> studOptional = studentRepository.findById(learnersId);
            if(studOptional.isPresent()) student =studOptional.get();
            else throw new NoSuchElementException("Student with the ID "  + learnersId+ " is not Found.");
        }
        if(subjectId == null) throw new IllegalArgumentException("Subject Id is null");
        else{
            Optional<Subject> subOptional = subjectRepository.findById(subjectId);
            if(subOptional.isPresent()) subject = subOptional.get();
            else throw new NoSuchElementException("Subject with the ID " + subjectId + " is not Found.");
        }
        attendance.setStudent(student);
        attendance.setSubject(subject);

        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendanceRecord(Integer learnersId, Date date) {
        Attendance attendance;
        if(learnersId == null) throw new IllegalArgumentException("The Learners Id is null");
        else{
            Optional<Student> studOptional = studentRepository.findById(learnersId);
            if(studOptional.isPresent())attendance = attendanceRepository.findByStudent_LearnersIdAndAbsentDate(learnersId, date);
            else throw new NoSuchElementException("Student with the ID "  + learnersId+ " is not Found.");
            if (attendance != null) attendanceRepository.delete(attendance);
        }
        
        
    }

    @Override
    public Attendance updateAttendanceRecord(Integer learnersId, AttendanceDto attendanceDto, Date date) {
        Attendance attendance;
        if(learnersId == null) throw new IllegalArgumentException("The Learners Id is null");
        Optional<Student> studOptional = studentRepository.findById(learnersId);
        if(studOptional.isPresent()) attendance =  attendanceRepository.findByStudent_LearnersIdAndAbsentDate(learnersId, date);
        else throw new NoSuchElementException("Student with the ID "  + learnersId+ " is not Found.");

        attendance = AttendanceMapper.mapDtoToEntity(attendanceDto, attendance);

        return attendance != null ? attendanceRepository.save(attendance) : null ;
    }
    
}
