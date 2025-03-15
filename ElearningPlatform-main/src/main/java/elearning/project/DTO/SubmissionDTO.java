@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDTO {
    private Long submissionId;
    private Double score;
    private String studentName;
    private String assessmentType;
    private int maxScore;

    public SubmissionDTO(Submission submission) {
        this.submissionId = submission.getSubmissionId();
        this.score = submission.getScore();
        this.studentName = submission.getStudent().getName();
        this.assessmentType = submission.getAssessment().getType().name();
        this.maxScore = submission.getAssessment().getMaxScore();
    }
}
