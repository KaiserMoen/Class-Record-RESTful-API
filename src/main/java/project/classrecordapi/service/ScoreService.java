package project.classrecordapi.service;

import java.util.Set;

import project.classrecordapi.dto.ScoresDto;
import project.classrecordapi.entities.Scores;

public interface ScoreService {

    Set<Scores> getScoresOfStudent(Integer learnersId); 
    Scores updateScore(Integer scoreId, ScoresDto scoresDto);
    
}
