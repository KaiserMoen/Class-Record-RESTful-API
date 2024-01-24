package project.classrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Grades;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
    
}
