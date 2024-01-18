package com.ahmad.samir.univeristy.system.repository;

import com.ahmad.samir.univeristy.system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByGuardianNameContaining(String guardianName);

    @Query(value = " Select s.firstName from Student s  where s.email = ?1")
    String findStudentFirstNameByEmail(String email);

    @Query(
            value =" SELECT  * FROM Students s WHERE s.Email = :email ",
            nativeQuery = true
    )
    Student getStudentByEmail(@Param(value = "email") String email);

    @Modifying
    @Transactional
    @Query(
            value = " UPDATE Students  SET First_Name = ?1 WHERE Email = ?2  ",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmail(String firstName, String email);

    @Modifying
    @Transactional
    @Query(
            value = " DELETE FROM Students WHERE Email = :email  ",
            nativeQuery = true
    )
    int deleteStudentByEmail(@Param(value = "email") String email);

}
