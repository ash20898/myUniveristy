package com.ahmad.samir.univeristy.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Courses"
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "Course_Sequence",
            sequenceName = "Course_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Course_Sequence"
    )
    private Long courseId;
    private int credit;
    private String title;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "teacher_Id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @JsonManagedReference
    public CourseMaterial getCourseMaterial() {
        return courseMaterial;
    }

    @JsonBackReference
    public Teacher getTeacher() {
        return teacher;
    }
}
