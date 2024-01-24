package project.classrecordapi.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.classrecordapi.dto.ScoresDto;
import project.classrecordapi.entities.Scores;
import project.classrecordapi.service.ScoreService;

@RestController
@RequestMapping("/user/student/{learnersId}")
public class ScoresController {
    
    @Autowired
    ScoreService scoreService;
    
    @GetMapping
    public Set<Scores> getStudentScores(@PathVariable Integer learnersId){
        return scoreService.getScoresOfStudent(learnersId);
    }

    @PatchMapping("/{scoreId}")
    public Scores updateStudentScore(@PathVariable Integer scoreId, @RequestBody ScoresDto scoresDto){
        return scoreService.updateScore(scoreId, scoresDto);
    }
}
