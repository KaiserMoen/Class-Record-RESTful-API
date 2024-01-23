package project.classrecordapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Teacher;

public interface TeacherRespository extends JpaRepository<Teacher,Integer> {

    
    
}
