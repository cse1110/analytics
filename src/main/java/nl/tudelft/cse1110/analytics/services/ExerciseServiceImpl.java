package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Course;
import nl.tudelft.cse1110.analytics.entities.Exercise;
import nl.tudelft.cse1110.analytics.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final CourseService courseService;
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(CourseService courseService, ExerciseRepository exerciseRepository) {
        this.courseService = courseService;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise getOrCreate(String name, String courseName) {
        Course course = courseService.getOrCreate(courseName);
        Optional<Exercise> optional = exerciseRepository.findByNameAndCourse(name, course);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Exercise exercise = new Exercise();
            exercise.setName(name);
            exercise.setCourse(course);
            return exerciseRepository.save(exercise);
        }
    }
}
