package project.classrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.classrecordapi.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
    
}
