package project.classrecordapi.service;

import java.util.Set;

import project.classrecordapi.dto.ActivityDto;
import project.classrecordapi.entities.Activity;
import project.classrecordapi.entities.Scores;

public interface ActivityService {

    public Activity newActivity(Integer subjectId, Activity activity);
    public Set<Activity> getActivitiesBySubject(Integer subjectId);
    public Activity getActivityById(Integer activityId);
    public Activity updateActivity(Integer activityId, ActivityDto activityDto);
    public void deleteActivity(Integer activityId);
    public Set<Scores> getScores(Integer activityId);
    public Set<Scores> getScores(Integer activityId, Integer learnersId);
}
