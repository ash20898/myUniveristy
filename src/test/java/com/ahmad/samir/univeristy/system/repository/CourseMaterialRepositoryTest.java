package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Course;
import com.ahmad.samir.univeristy.system.entity.CourseMaterial;
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

        Course course = Course.builder()
                .credit(7)
                .title("Ahmad Samir Hadhoud Course")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("WWW.ahmadSamir.com")
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