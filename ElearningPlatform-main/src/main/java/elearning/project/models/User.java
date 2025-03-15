package elearning.project.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;

	private String name;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	// One user (student) can have many enrollments
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Enrollment> enrollments;

	// One user (instructor) can have many courses
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Course> courses;

	// One user can have many submissions
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Submission> submissions;

	public enum Role {
		STUDENT, INSTRUCTOR
	}
}
