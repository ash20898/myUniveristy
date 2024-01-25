package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
