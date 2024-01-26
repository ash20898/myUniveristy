package com.ahmad.samir.univeristy.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "CoursesMaterial"
)
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "CourseMaterial_Sequence",
            sequenceName = "CourseMaterial_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CourseMaterial_Sequence"
    )
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "Course_Id",
            referencedColumnName = "courseId"
    )
    private Course course;

    @JsonBackReference
    public Course getCourse() {
        return course;
    }
}
