package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.CodeCheckSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("CodeCheckSubmissionRepository")
public interface CodeCheckSubmissionRepository extends JpaRepository<CodeCheckSubmission, UUID> {

}
