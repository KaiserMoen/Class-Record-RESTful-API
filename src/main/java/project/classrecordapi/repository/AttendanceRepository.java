package project.classrecordapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {

    
    Attendance findByStudent_LearnersIdAndAbsentDate(Integer learnersId, Date absentDate);

    Attendance findByStudentLearnersIdAndSubjectSubjectId(Integer learnersId, Integer subjectId);

    List<Attendance> findBySubjectSubjectId(Integer subjectId);

    List<Attendance> findBySubjectSubjectIdAndAbsentDateBetween(Integer subjectId, Date startDate,Date endDate);


    
}
