package com.ahmad.samir.univeristy.system.Controller;

import com.ahmad.samir.univeristy.system.entity.Course;
import com.ahmad.samir.univeristy.system.entity.Teacher;
import com.ahmad.samir.univeristy.system.repository.CourseRepository;
import com.ahmad.samir.univeristy.system.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/Teachers")
    public ResponseEntity<List<Teacher>> getAllCourses(){
        List<Teacher> listOfCourses = teacherRepository.findAll();
        return ResponseEntity.ok(listOfCourses);
    }
}
