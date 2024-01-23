package project.classrecordapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.dto.ActivityDto;
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
    public List<Activity> getActivitiesBySubject(Integer subjectId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getActivitiesBySubject'");
    }

    @Override
    public List<Activity> getActivitiesByStudent(Integer learnersId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivitiesByStudent'");
    }

    @Override
    public List<Activity> getActivitiesByStudentAndSubject(Integer subjectId, Integer learnersId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivitiesByStudentAndSubject'");
    }

    @Override
    public Activity getActivityById(Integer activityId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivityById'");
    }

    @Override
    public Activity updateActivity(Integer activityId, ActivityDto activityDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateActivity'");
    }

    @Override
    public void deleteActivity(Integer activityId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteActivity'");
    }
    
}
