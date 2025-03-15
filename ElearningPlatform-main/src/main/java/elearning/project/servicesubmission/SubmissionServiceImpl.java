package elearning.project.servicesubmission;

import elearning.project.models.Submission;
import elearning.project.repositories.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    private final SubmissionRepository submissionRepository;

    public SubmissionDTO createSubmission(SubmissionDTO submissionDTO) {
        Submission submission = new Submission(submissionDTO);
        submission = submissionRepository.save(submission);
        return new SubmissionDTO(submission);
    }

    public List<SubmissionDTO> getAllSubmissions() {
        return submissionRepository.findAll().stream()
                .map(SubmissionDTO::new)
                .collect(Collectors.toList());
    }

    public SubmissionDTO getSubmissionById(Long id) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        return new SubmissionDTO(submission);
    }

    public SubmissionDTO updateSubmission(Long id, SubmissionDTO submissionDTO) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        submission.setScore(submissionDTO.getScore());
        submission.setAssessment(submissionDTO.getAssessment());
        submission.setUser(submissionDTO.getUser());
        submission = submissionRepository.save(submission);
        return new SubmissionDTO(submission);
    }

    public void deleteSubmission(Long id) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        submissionRepository.delete(submission);
    }
}
