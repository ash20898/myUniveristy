package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Guardian;
import com.ahmad.samir.univeristy.system.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Guardian guardian = Guardian.builder()
                .name("guardian")
                .mobile("010101020304")
                .build();

        Student student = Student.builder()
                .firstName("Ahmad")
                .lastName("Samir")
                .email("ahmad@assett.com")
                .guardian(guardian)
                .build();

        Student returnStudent = studentRepository.save(student);

        assertEquals(returnStudent.getFirstName(),"Ahmad");
    }

    @Test
    public void getAllStudents()
    {
        List<Student> listOfStudents = studentRepository.findAll();

        assertTrue(listOfStudents.size() >= 0);
    }

    @Test
    public void getAllStudentsByFirstName()
    {
        List<Student> listOfStudents = studentRepository.findByFirstName("Ahmad");

        assertTrue(listOfStudents.size() >= 0);
    }

    @Test
    public void getAllStudentsByGuardianName()
    {
        List<Student> listOfStudents = studentRepository.findByGuardianName("guardianName");

        assertTrue(listOfStudents.size() >= 0);
    }

    @Test
    public void findByGuardianNameContaining()
    {
        List<Student> listOfStudents = studentRepository.findByGuardianNameContaining("guar");

        assertTrue(listOfStudents.size() >= 0);
    }

    @Test
    public void findStudentFirstNameByEmail()
    {
        String studentEmail = "ahmad@asset.com";
        String studentFirstName = studentRepository.findStudentFirstNameByEmail(studentEmail);

        assertNotNull(studentFirstName);
    }

    @Test
    public void getStudentByEmail()
    {
        String studentEmail = "ahmad@asset.com";
        Student student = studentRepository.getStudentByEmail(studentEmail);

        assertNotNull(student);
    }

    @Test
    public void updateStudentFirstNameByEmail()
    {
        int id = studentRepository.updateStudentFirstNameByEmail("Ahmad Samir hh","ahmad@assett.com");

    }

    @Test
    public void deleteStudentByEmail()
    {
        int id = studentRepository.deleteStudentByEmail("ahmad@asset.com");
    }

}