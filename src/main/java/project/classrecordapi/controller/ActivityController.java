package project.classrecordapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.entities.Activity;
import project.classrecordapi.entities.Scores;
import project.classrecordapi.service.ActivityService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user/{userId}/subject/{subjectId}/activities")
public class ActivityController {
    
    @Autowired
    ActivityService  activityService;

    @PostMapping("/new")
    public Activity newActivity(@PathVariable Integer subjectId, @RequestBody Activity activity){
        return activityService.newActivity(subjectId, activity);
    }
    
    @GetMapping
    public Set<Activity> getAcivities(@PathVariable Integer subjectId){
        return activityService.getActivitiesBySubject(subjectId);
    }

    @GetMapping("/{activityId}")
    public Activity getActivitiesById(@PathVariable Integer activityId){
        return activityService.getActivityById(activityId);
    }

    @GetMapping("/{activityId}/scores")
    public Set<Scores> getActivityScores(@PathVariable Integer activityId){
        return activityService.getScores(activityId);
    }

    @GetMapping("/{activityId}/score")
    public Set<Scores> getStudentActivityScores(@PathVariable Integer activityId,@RequestParam Integer learnersId){
        return activityService.getScores(activityId,learnersId);
    }
    
}
