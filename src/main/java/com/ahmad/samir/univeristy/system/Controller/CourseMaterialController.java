package com.ahmad.samir.univeristy.system.Controller;

import com.ahmad.samir.univeristy.system.entity.CourseMaterial;
import com.ahmad.samir.univeristy.system.repository.CourseMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseMaterialController {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @GetMapping("/coursesMaterial")
    public ResponseEntity<List<CourseMaterial>> getAllCoursesMaterial(){
        List<CourseMaterial> listOfCourses = courseMaterialRepository.findAll();
        return ResponseEntity.ok(listOfCourses);
    }
}
