package elearning.project.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    private String title;
    private String description;
    private String contentURL;

    // Many courses belong to one instructor
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    // One course can have many enrollments
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Enrollment> enrollments;

    // One course can have many assessments
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Assessment> assessments;
}
