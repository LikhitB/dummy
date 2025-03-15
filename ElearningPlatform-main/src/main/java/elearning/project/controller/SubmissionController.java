package elearning.project.controller;

import elearning.project.models.Submission;
import elearning.project.servicesubmission.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<SubmissionDTO> createSubmission(@RequestBody SubmissionDTO submissionDTO) {
        SubmissionDTO createdSubmission = submissionService.createSubmission(submissionDTO);
        return new ResponseEntity<>(createdSubmission, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmissionDTO> getSubmissionById(@PathVariable Long id) {
        return ResponseEntity.ok(submissionService.getSubmissionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmissionDTO> updateSubmission(@PathVariable Long id, @RequestBody SubmissionDTO submissionDTO) {
        SubmissionDTO updatedSubmission = submissionService.updateSubmission(id, submissionDTO);
        return ResponseEntity.ok(updatedSubmission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmission(id);
        return ResponseEntity.noContent().build();
    }
}
