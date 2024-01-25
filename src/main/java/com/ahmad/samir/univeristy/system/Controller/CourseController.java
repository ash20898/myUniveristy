package com.ahmad.samir.univeristy.system.Controller;

import com.ahmad.samir.univeristy.system.entity.Course;

import com.ahmad.samir.univeristy.system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> listOfCourses = courseRepository.findAll();
        return ResponseEntity.ok(listOfCourses);
    }

}
