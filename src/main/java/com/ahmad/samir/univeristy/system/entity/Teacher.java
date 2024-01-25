package com.ahmad.samir.univeristy.system.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "Teacher_Sequence",
            sequenceName = "Teacher_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Teacher_Sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany(
            mappedBy = "teacher"
    )
    private List<Course> listOfCourses;

    @JsonManagedReference
    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
}
