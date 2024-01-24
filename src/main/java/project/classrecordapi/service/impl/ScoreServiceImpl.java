package project.classrecordapi.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.dto.ScoresDto;
import project.classrecordapi.dto.mapper.ScoresMapper;
import project.classrecordapi.entities.Scores;
import project.classrecordapi.repository.ScoresRepository;
import project.classrecordapi.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoresRepository scoresRepository;

    @Override
    public Set<Scores> getScoresOfStudent(Integer learnersId) {
        return scoresRepository.findByStudentLearnersId(learnersId);
    }

    @Override
    public Scores updateScore(Integer scoreId,ScoresDto scoresDto) {
        Scores scores = scoresRepository.findById(scoreId).get();
        scores = ScoresMapper.mapDtoToEntity(scores, scoresDto);
        return scoresRepository.save(scores);
    }


}
