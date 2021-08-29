package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("SubmissionRepository")
public interface SubmissionRepository extends JpaRepository<Submission, UUID> {

}
