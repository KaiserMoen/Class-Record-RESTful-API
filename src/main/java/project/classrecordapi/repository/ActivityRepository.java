package project.classrecordapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    public Set<Activity>  findBySubjectSubjectId(Integer subjectId);
}
