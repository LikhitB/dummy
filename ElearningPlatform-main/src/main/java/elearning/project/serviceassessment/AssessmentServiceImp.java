package elearning.project.serviceassessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elearning.project.models.Assessment;
import elearning.project.repositories.AssessmentRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImp implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    public AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO) {
        Assessment assessment = new Assessment(assessmentDTO);
        assessment = assessmentRepository.save(assessment);
        return new AssessmentDTO(assessment);
    }

    public List<AssessmentDTO> getAllAssessments() {
        return assessmentRepository.findAll().stream()
                .map(AssessmentDTO::new)
                .collect(Collectors.toList());
    }

    public AssessmentDTO getAssessmentById(Long id) {
        Assessment assessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
        return new AssessmentDTO(assessment);
    }

    public AssessmentDTO updateAssessment(Long id, AssessmentDTO assessmentDTO) {
        Assessment assessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
        assessment.setCourse(assessmentDTO.getCourse());
        assessment.setType(assessmentDTO.getType());
        assessment.setMaxScore(assessmentDTO.getMaxScore());
        assessment = assessmentRepository.save(assessment);
        return new AssessmentDTO(assessment);
    }

    public void deleteAssessment(Long id) {
        Assessment assessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));
        assessmentRepository.delete(assessment);
    }
}
