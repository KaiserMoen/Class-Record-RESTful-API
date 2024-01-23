package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.ActivityDto;
import project.classrecordapi.entities.Activity;

public class ActivityMapper {
     public static Activity mapDtoToEntity(ActivityDto activityDto,Activity activity){
  
        if(activityDto.getActivityName() != null) activity.setActivityName(activityDto.getActivityName());
        if(activityDto.getActivityType() != null) activity.setActivityType(activityDto.getActivityType());
        if(activityDto.getFinalScore() != null)activity.setFinalScore(activityDto.getFinalScore());
        if(activityDto.getActivityStartDate()!=null) activity.setActivityStartDate(activityDto.getActivityStartDate());
        if(activityDto.getActivityDeadline()!=null) activity.setActivityDeadline(activityDto.getActivityDeadline());


        return activity;
     }
}
