package project.classrecordapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.classrecordapi.dto.TeacherDto;
import project.classrecordapi.dto.mapper.TeacherMapper;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.entities.Teacher;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.repository.TeacherRespository;
import project.classrecordapi.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRespository teacherRespository;
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public Teacher newTeacher(Teacher teacher) {   
        if (teacher != null) return teacherRespository.save(teacher);
        else throw new NullPointerException("Teacher is null");
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRespository.findAll();
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        Optional<Teacher> optionalTeacher  = teacherRespository.findById(teacherId);
        if(optionalTeacher.isPresent()) return optionalTeacher.get();
        else throw new NoSuchElementException("Teacher with the ID " + teacherId + " is not Found.");
    }
    @Override
    public Teacher updateTeacher(Integer teacherId, TeacherDto teacherDto){
        Teacher teacher;
        if(teacherId == null) throw new IllegalArgumentException("Teacher Id is null");
        Optional<Teacher> oTeacher = teacherRespository.findById(teacherId);
        if(!oTeacher.isPresent()) throw new NoSuchElementException ("Teacher with the ID: "+ teacherId+" is Not Found");
        teacher = TeacherMapper.mapDtoToEntity(teacherDto, oTeacher.get());
        
        if(teacher == null) throw new NullPointerException("Teacher Mapped is Null");
        teacherRespository.save(teacher);
        return teacher;
    }
    @Override
    public void deleteTeacher(Integer teacherId) {
        if(teacherId != null){
            Teacher teacher;
            Optional<Teacher> optionalTeacher  = teacherRespository.findById(teacherId);
            if(optionalTeacher.isPresent()) {
                teacher = optionalTeacher.get();
                if(teacher != null) teacherRespository.delete(teacher);
             }
            else throw new NoSuchElementException("Teacher with the ID " + teacherId + " is not Found.");

            
        }else{
            throw new IllegalArgumentException("Teacher Id is null");
        } 
    }

    @Override
    public void addSubjectToTeacher(Integer teacherId, Integer subjectId){
        Teacher t;
        Subject s;
        if(teacherId != null){
            Optional<Teacher> optionalTeacher  = teacherRespository.findById(teacherId);
            if(optionalTeacher.isPresent())  t = optionalTeacher.get();
            else throw new NoSuchElementException("Teacher with the ID " + teacherId + " is not Found.");
        }else throw new IllegalArgumentException("Teacher Id is null");
        
        if(subjectId == null) throw new IllegalArgumentException("subject Id is null");
        else{
            Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
            if(optionalSubject.isPresent())  s = optionalSubject.get();
            else throw new NoSuchElementException("Subject with the ID "  + subjectId+ " is not Found.");
        }
        
        s.setTeacher(t);
        subjectRepository.saveAndFlush(s);
    }
}
