package project.classrecordapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.entities.Activity;
import project.classrecordapi.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    
}
