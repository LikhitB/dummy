package elearning.project.DTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {4
    private Long userID;
    private String name;
    private String email;
    private String role;
    private List<CourseDTO> enrolledCourses;

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole().name();
        this.enrolledCourses = user.getEnrollments().stream()
                .map(enrollment -> new CourseDTO(enrollment.getCourse()))
                .collect(Collectors.toList());
    }
}