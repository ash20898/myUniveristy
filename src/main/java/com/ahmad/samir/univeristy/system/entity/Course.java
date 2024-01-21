package com.ahmad.samir.univeristy.system.entity;

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
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private CourseMaterial courseMaterial;

}
