package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Course;
import com.ahmad.samir.univeristy.system.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
                //.courseMaterial(courseMaterial)
                .build();
        courseRepository.save(course);
    }

    @Test
    void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : " + courses);
    }

    @Test
    void getAllCoursesPagination(){

        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

        List<Course> courses = courseRepository.findByTitleContaining("S",firstPageWithTwoElements).getContent();
        System.out.println("Courses : " + courses);
    }

    @Test
    void getAllCoursesPaginationAndSorting(){

        Pageable firstPageWithTwoElements = PageRequest.of(
                0,
                7,
                Sort.by("credit")
                .ascending()
                .and(Sort.by("title").ascending()));

        List<Course> courses = courseRepository.findAll(firstPageWithTwoElements).getContent();
        System.out.println("Courses : " + courses);
    }
}