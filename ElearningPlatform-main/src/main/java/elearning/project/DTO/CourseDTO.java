package elearning.project.DTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long courseID;
    private String title;
    private String description;
    private String contentURL;
    private String instructorName;
    public CourseDTO(Course course) {
        this.courseID = course.getCourseID();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.contentURL = course.getContentURL();
        this.instructorName = course.getInstructor().getCourseID();
    }
}
