package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Course;
import nl.tudelft.cse1110.analytics.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getOrCreate(String name) {
        Optional<Course> optional = courseRepository.findByName(name);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Course course = new Course();
            course.setName(name);
            return courseRepository.save(course);
        }
    }
}
