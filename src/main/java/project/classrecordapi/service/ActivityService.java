package project.classrecordapi.service;

import java.util.List;

import project.classrecordapi.dto.ActivityDto;
import project.classrecordapi.entities.Activity;

public interface ActivityService {

    public Activity newActivity(Integer subjectId, Activity activity);
    public List<Activity> getActivitiesBySubject(Integer subjectId);
    public List<Activity> getActivitiesByStudent(Integer learnersId);
    public List<Activity> getActivitiesByStudentAndSubject(Integer subjectId, Integer learnersId);
    public Activity getActivityById(Integer activityId);
    public Activity updateActivity(Integer activityId, ActivityDto activityDto);
    public void deleteActivity(Integer activityId);
}
