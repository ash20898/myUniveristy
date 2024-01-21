package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
