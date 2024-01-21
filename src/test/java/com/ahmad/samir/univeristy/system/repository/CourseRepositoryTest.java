package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Course;
import com.ahmad.samir.univeristy.system.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void addCourse(){
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("WWW.test.com")
                .build();
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .courseMaterial(courseMaterial)
                .build();
        courseRepository.save(course);
    }

    @Test
    void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : " + courses);
    }
}