package project.classrecordapi.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import project.classrecordapi.entities.Teacher;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.repository.TeacherRespository;
import project.classrecordapi.service.TeacherService;
import project.classrecordapi.service.impl.TeacherServiceImpl;

@SpringBootTest
public class TeacherServiceImplTest {

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Mock
    private TeacherRespository teacherRespository;

    @Mock
    private SubjectRepository subjectRepository;

    @Test
    public void testNewTeacher(){
        Teacher teacher = new Teacher();
        teacher.setEmail("nnhelg@gmail.com");
        teacher.setPassword("napeekkaiser12");
        teacher.setTeacherBirthDate(new Date(1999-8-02));
        teacher.setTeacherName("Kaiser");
        teacher.setTeacherMiddleName("Sab-it");
        teacher.setTeacherSurName("Napeek");

        Mockito.when(teacherRespository.save(any(Teacher.class))).thenReturn(teacher);
        Teacher savedTeacher = teacherService.newTeacher(teacher);

        assertNotNull(savedTeacher);
        assertEquals("nnhelg@gmail.com", savedTeacher.getEmail());
        assertEquals("napeekkaiser12", savedTeacher.getPassword());
        assertEquals(new Date(1999-8-02), savedTeacher.getTeacherBirthDate());
        assertEquals("Kaiser", savedTeacher.getTeacherName());
        assertEquals("Sab-it", savedTeacher.getTeacherMiddleName());
        assertEquals("Napeek", savedTeacher.getTeacherSurName());
    }

    
}
