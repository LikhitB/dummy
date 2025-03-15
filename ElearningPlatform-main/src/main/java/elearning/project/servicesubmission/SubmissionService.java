import java.util.List;
import java.util.Optional;

public interface SubmissionService {
    SubmissionDTO createSubmission(SubmissionDTO submissionDTO);
    List<SubmissionDTO> getAllSubmissions();
    Optional<SubmissionDTO> getSubmissionById(Long id);
    SubmissionDTO updateSubmission(Long id, SubmissionDTO submissionDetails);
    void deleteSubmission(Long id);
}
