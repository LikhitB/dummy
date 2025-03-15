package elearning.project.models;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    private Double progress;

    // Many enrollments belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnore
    private User student;

    // Many enrollments belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
