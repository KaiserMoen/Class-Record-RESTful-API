package project.classrecordapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.classrecordapi.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    public List<Subject> findByTeacherTeacherId(Integer teacherId);
}
