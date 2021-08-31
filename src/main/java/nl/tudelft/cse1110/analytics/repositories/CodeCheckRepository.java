package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.CodeCheck;
import nl.tudelft.cse1110.analytics.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("CodeCheckRepository")
public interface CodeCheckRepository extends JpaRepository<CodeCheck, UUID> {
    Optional<CodeCheck> findByExerciseAndName(Exercise exercise, String name);
}
