package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.Exercise;
import nl.tudelft.cse1110.analytics.entities.MetaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("MetaTestRepository")
public interface MetaTestRepository extends JpaRepository<MetaTest, UUID> {
    Optional<MetaTest> findByExerciseAndName(Exercise exercise, String name);
}
