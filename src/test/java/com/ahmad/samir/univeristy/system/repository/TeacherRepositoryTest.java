package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Course;
import com.ahmad.samir.univeristy.system.entity.CourseMaterial;
import com.ahmad.samir.univeristy.system.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void addTeacher(){

        /*CourseMaterial courseMaterial1 = CourseMaterial.builder()
                .url("WWW.shref_3raby_6.com")
                .build();
        CourseMaterial courseMaterial2 = CourseMaterial.builder()
                .url("WWW.shref_3raby_5.com")
                .build();
        Course course1 = Course.builder()
                .title("3raby 6 ")
                .credit(6)
                .courseMaterial(courseMaterial1)
                .build();
        Course course2 = Course.builder()
                .title("3raby 5")
                .credit(6)
                //.courseMaterial(courseMaterial2)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("sherif")
                .lastName("SHob")
                .listOfCourses(List.of(course2))
                .build();

        teacherRepository.save(teacher);*/

    }

}