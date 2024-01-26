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
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    void addCourseMaterial(){
        Teacher teacher = Teacher.builder()
                .firstName("Ahmad")
                .lastName("Na")
                .build();

        Course course = Course.builder()
                .credit(1)
                .title("Math")
                .teacher(teacher)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("WWW.test2.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    void getAllCoursesMaterial(){

        List<CourseMaterial> listOfCourseMaterial = courseMaterialRepository.findAll();

        System.out.println("CourseMaterials : " + listOfCourseMaterial);
    }

}