package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Guardian;
import com.ahmad.samir.univeristy.system.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
                .guardianName("guardianName")
                .guardianMobile("010101020304")
                .build();

        Student student = Student.builder()
                .firstName("Ahmad")
                .lastName("Samir")
                .email("ahmad@asset.com")
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

}