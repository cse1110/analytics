package nl.tudelft.cse1110.analytics.repositories;

import nl.tudelft.cse1110.analytics.entities.Course;
import nl.tudelft.cse1110.analytics.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("ExerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
    Optional<Exercise> findByNameAndCourse(String name, Course course);
}
