package project.classrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Scores;

public interface ScoresRepository extends JpaRepository<Scores,Integer> {
    
}
