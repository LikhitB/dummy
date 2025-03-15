package elearning.project.serviceassessment;

import java.util.List;

public interface AssessmentService {
    AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO);
    List<AssessmentDTO> getAllAssessments();
    AssessmentDTO getAssessmentById(Long id);
    AssessmentDTO updateAssessment(Long id, AssessmentDTO assessmentDTO);
    void deleteAssessment(Long id);
}
