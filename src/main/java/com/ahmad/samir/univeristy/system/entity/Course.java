package com.ahmad.samir.univeristy.system.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "Courses"
)
@ToString(exclude = "teacher")
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
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "teacher_Id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "Course_Student",
            joinColumns = @JoinColumn(
                    name = "course_Id"
            ) ,
            inverseJoinColumns = @JoinColumn(
                    name = "student_Id"
            )
    )
    private List<Student> students;

    public void addStudent(Student student){
        if( students == null)
            students = new ArrayList<>();
        students.add(student);
    }

    @JsonManagedReference
    public CourseMaterial getCourseMaterial() {
        return courseMaterial;
    }

    @JsonBackReference
    public Teacher getTeacher() {
        return teacher;
    }
}
