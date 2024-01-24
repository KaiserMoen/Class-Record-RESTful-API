package project.classrecordapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Scores;

public interface ScoresRepository extends JpaRepository<Scores,Integer> {

    Set<Scores> findByActivityActivityId(Integer activityId);
    Set<Scores> findByActivityActivityIdAndStudentLearnersId(Integer activityId,Integer learnersId);
    Set<Scores> findByActivitySubjectSubjectIdAndActivityActivityTypeAndStudentLearnersId(Integer subjectId, Integer activityType, Integer learnersId);
    
}
