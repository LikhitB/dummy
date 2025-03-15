package elearning.project.DTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    private Long enrollmentId;
    private Double progress;
    private String studentName;
    private String courseTitle;

    public EnrollmentDTO(Enrollment enrollment) {
        this.enrollmentId = enrollment.getEnrollmentId();
        this.progress = enrollment.getProgress();
        this.studentName = enrollment.getStudent().getName();
        this.courseTitle = enrollment.getCourse().getTitle();
    }
}
