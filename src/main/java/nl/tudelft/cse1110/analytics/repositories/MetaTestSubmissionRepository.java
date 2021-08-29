package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.MetaTestSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("MetaTestSubmissionRepository")
public interface MetaTestSubmissionRepository extends JpaRepository<MetaTestSubmission, UUID> {

}
