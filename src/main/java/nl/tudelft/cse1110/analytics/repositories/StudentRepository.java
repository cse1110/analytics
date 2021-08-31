package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByStudentId(String studentId);
}
