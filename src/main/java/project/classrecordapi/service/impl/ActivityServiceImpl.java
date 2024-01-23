package project.classrecordapi.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.dto.ActivityDto;
import project.classrecordapi.dto.mapper.ActivityMapper;
import project.classrecordapi.entities.Activity;
import project.classrecordapi.entities.Scores;
import project.classrecordapi.entities.Student;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.repository.ActivityRepository;
import project.classrecordapi.repository.ScoresRepository;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ScoresRepository scoreRepository;

    @Override
    public Activity newActivity(Integer subjectId,  Activity activity) {
        if (subjectId == null || activity == null) throw new IllegalArgumentException("A parameter passed is null");
        Optional<Subject> oSubject = subjectRepository.findById(subjectId);
        if(!oSubject.isPresent()) throw new NullPointerException("Subject with the ID " + subjectId + " is not Found");
        Subject subject = oSubject.get();
        activity.setSubject(subject);
        activityRepository.save(activity);

        Set<Student> subjectStudents = subject.getEnrolledStudents();
        for(Student s : subjectStudents){
            Scores score = new Scores();
            score.setStudent(s);
            score.setActivity(activity);
            score.setDateSubmitted(null);
            score.setScore(null);
            score.setStatus(score.getStatus());
            scoreRepository.save(score);
        }
        return activityRepository.save(activity);
    }

    @Override
    public Set<Activity> getActivitiesBySubject(Integer subjectId) {
        if(subjectId == null) throw new IllegalArgumentException("A parameter passed is null");
        return activityRepository.findBySubjectSubjectId(subjectId);
    }
    @Override
    public Activity getActivityById(Integer activityId) {
        if(activityId == null ) throw new IllegalArgumentException("A parameter passed is null");
        Activity activity = activityRepository.findById(activityId).get();
        return activity;
    }

    @Override
    public Activity updateActivity(Integer activityId, ActivityDto activityDto) {
        if(activityId == null || activityDto == null ) throw new IllegalArgumentException("A parameter passed is null");
        Activity activity = activityRepository.findById(activityId).get();
        activity = ActivityMapper.mapDtoToEntity(activityDto, activity);
        return activity;

    }

    @Override
    public void deleteActivity(Integer activityId) {
        if(activityId == null ) throw new IllegalArgumentException("A parameter passed is null");
        Activity activity = activityRepository.findById(activityId).get();
        if(activity != null) activityRepository.delete(activity);
    }

    @Override
    public Set<Scores> getScores(Integer activityId) {
        if(activityId == null ) throw new IllegalArgumentException("A parameter passed is null");
        return scoreRepository.findByActivityActivityId(activityId);
        }

    @Override
    public Set<Scores> getScores(Integer activityId, Integer learnersId) {
        if(activityId == null || learnersId == null ) throw new IllegalArgumentException("A parameter passed is null");
        return scoreRepository.findByActivityActivityIdAndStudentLearnersId(activityId,learnersId);
    }
    
}
