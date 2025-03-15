package elearning.project.serviceenrollment;

public interface EnrollmentService {
    EnrollmentDTO saveEnrollment(EnrollmentDTO enrollmentDTO);
    List<EnrollmentDTO> getAllEnrollments();
    EnrollmentDTO getEnrollmentById(Long id);
    EnrollmentDTO updateEnrollment(Long id, EnrollmentDTO enrollmentDTO);
    void deleteEnrollment(Long id);
}
