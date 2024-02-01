package project.classrecordapi.unitTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.aspectj.apache.bcel.generic.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import project.classrecordapi.dto.TeacherDto;
import project.classrecordapi.entities.Subject;
import project.classrecordapi.entities.Teacher;
import project.classrecordapi.repository.SubjectRepository;
import project.classrecordapi.repository.TeacherRespository;
import project.classrecordapi.service.impl.TeacherServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceImplTest {

    @Mock
    private TeacherRespository teacherRespository;

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    private Teacher mockTeacher;
    private Subject mockSubject;
    private TeacherDto teacherDto;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects here
        mockTeacher = new Teacher();
        mockTeacher.setTeacherId(1);
        mockTeacher.setEmail("nnhelg@gmail.com");
        mockTeacher.setPassword("napeekkaiser12");
        mockTeacher.setTeacherBirthDate(new Date(2001-6-25));
        mockTeacher.setTeacherName("Nhelg Kaiser Moen");
        mockTeacher.setTeacherMiddleName("Sab-it");
        mockTeacher.setTeacherSurName("Napeek");
        mockSubject = new Subject();
        mockSubject.setSubjectId(1);
        mockSubject.setSubjectCode("CS 221");
        teacherDto = new TeacherDto();
    }

    @Test
    public void testNewTeacher() {
        when(teacherRespository.save(any(Teacher.class))).thenReturn(mockTeacher);

        Teacher result = teacherService.newTeacher(mockTeacher);

        assertNotNull(result);
        verify(teacherRespository, times(1)).save(any(Teacher.class));
    }

    @Test
    public void testGetAllTeachers() {
        when(teacherRespository.findAll()).thenReturn(Arrays.asList(mockTeacher));
        List<Teacher> result = teacherService.getAllTeacher();
        assertEquals(1, result.size());
        verify(teacherRespository, times(1)).findAll();
    }

    @Test
    public void testGetTeacherById() {
        when(teacherRespository.findById(anyInt())).thenReturn(Optional.of(mockTeacher));
        Teacher result = teacherService.getTeacherById(anyInt());
        assertNotNull(result);
        assertEquals("Nhelg Kaiser Moen", result.getTeacherName());
        verify(teacherRespository, times(1)).findById(anyInt());
    }

    @Test
    public void testUpdateTeacher() {
        when(teacherRespository.findById(anyInt())).thenReturn(Optional.of(mockTeacher));
        teacherDto.setPassword("Napeekkaiser12");
        Teacher result = teacherService.updateTeacher(1, teacherDto);
        assertNotNull(result);
        assertEquals(result.getPassword(), teacherDto.getPassword());
        
        
    }

    @Test
    public void testDeleteTeacher(){
        when(teacherRespository.findById(anyInt())).thenReturn(Optional.of(mockTeacher));
        teacherService.deleteTeacher(anyInt());
        verify(teacherRespository, times(1)).findById(anyInt());
        verify(teacherRespository, times(1)).delete(any(Teacher.class));
    }

    @Test
    public void testAddSUbjectToTeacher(){
        when(teacherRespository.findById(anyInt())).thenReturn(Optional.of(mockTeacher));
        when(subjectRepository.findById(anyInt())).thenReturn(Optional.of(mockSubject));

        ArgumentCaptor<Subject> subjectCaptor = ArgumentCaptor.forClass(Subject.class);
      
        teacherService.addSubjectToTeacher(1, 1);
        verify(teacherRespository,times(1)).findById(anyInt());
        verify(subjectRepository, times(1)).findById(anyInt());
        verify(subjectRepository,times(1)).saveAndFlush(subjectCaptor.capture());

        Subject capturedSubject = subjectCaptor.getValue();
        assertEquals(mockTeacher, capturedSubject.getTeacher());
    }

}
