package project.classrecordapi.dto.mapper;

import project.classrecordapi.dto.ScoresDto;
import project.classrecordapi.entities.Scores;

public class ScoresMapper {
    public static Scores mapDtoToEntity(Scores scores, ScoresDto scoresDto){
        if(scoresDto.getDateSubmitted()!= null) scores.setDateSubmitted(scoresDto.getDateSubmitted());
        if(scoresDto.getScore() != null) scores.setScore(scoresDto.getScore());
        if(scoresDto.getStatus() != null) scores.setStatus(scoresDto.getStatus());

        return scores;
    }
}
