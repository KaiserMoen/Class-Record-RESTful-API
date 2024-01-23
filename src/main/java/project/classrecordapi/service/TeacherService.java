package project.classrecordapi.service;

import java.util.List;

import project.classrecordapi.dto.TeacherDto;
import project.classrecordapi.entities.Teacher;

public interface TeacherService {

    Teacher newTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(int teacherId);
    Teacher updateTeacher(Integer teacherId, TeacherDto teacherDto);
    void deleteTeacher(Integer teacherId);
    void addSubjectToTeacher(Integer teacherId, Integer subjectId);
}
