package project.classrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    
}
