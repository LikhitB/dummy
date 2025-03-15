package elearning.project.serviceenrollment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elearning.project.models.Enrollment;
import elearning.project.repositories.EnrollmentRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment(enrollmentDTO);
        enrollment = enrollmentRepository.save(enrollment);
        return new EnrollmentDTO(enrollment);
    }

    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(EnrollmentDTO::new)
                .collect(Collectors.toList());
    }

    public EnrollmentDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        return new EnrollmentDTO(enrollment);
    }

    public EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollment.setProgress(enrollmentDTO.getProgress());
        enrollment.setStudent(enrollmentDTO.getStudent());
        enrollment.setCourse(enrollmentDTO.getCourse());
        enrollment = enrollmentRepository.save(enrollment);
        return new EnrollmentDTO(enrollment);
    }

    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }
}
