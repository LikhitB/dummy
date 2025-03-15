@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentDTO {
    private Long assessmentId;
    private String type;
    private int maxScore;
    private String courseTitle;
    private List<SubmissionDTO> submissions;

    public AssessmentDTO(Assessment assessment) {
        this.assessmentId = assessment.getAssessmentId();
        this.type = assessment.getType().name();
        this.maxScore = assessment.getMaxScore();
        this.courseTitle = assessment.getCourse().getTitle();
        this.submissions = assessment.getSubmissions().stream()
                .map(SubmissionDTO::new)
                .collect(Collectors.toList());
    }
}