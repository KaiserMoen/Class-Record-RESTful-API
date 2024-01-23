package project.classrecordapi.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import project.classrecordapi.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

    Set<Student> findBySubjectSubjectId(Integer subjectId);
    
}
