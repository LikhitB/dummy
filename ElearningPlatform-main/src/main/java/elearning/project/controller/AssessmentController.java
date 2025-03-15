package elearning.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import elearning.project.models.Assessment;
import elearning.project.serviceassessment.AssessmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<AssessmentDTO> createAssessment(@RequestBody AssessmentDTO assessmentDTO) {
        AssessmentDTO createdAssessment = assessmentService.saveAssessment(assessmentDTO);
        return new ResponseEntity<>(createdAssessment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssessmentDTO>> getAllAssessments() {
        return ResponseEntity.ok(assessmentService.getAllAssessments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentDTO> getAssessmentById(@PathVariable Long id) {
        return ResponseEntity.ok(assessmentService.getAssessmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssessmentDTO> updateAssessment(@PathVariable Long id, @RequestBody AssessmentDTO assessmentDTO) {
        AssessmentDTO updatedAssessment = assessmentService.updateAssessment(id, assessmentDTO);
        return ResponseEntity.ok(updatedAssessment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return ResponseEntity.noContent().build();
    }
}
