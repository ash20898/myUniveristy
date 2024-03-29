package com.ahmad.samir.univeristy.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "Students",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique" ,
                columnNames = "Email"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(
            name = "Email",
            nullable = false
    )
    private String email;

    @Embedded
    private Guardian guardian;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public void addCourse(Course course){
        if(courses == null)
            courses = new ArrayList<>();
        courses.add(course);
    }

}
