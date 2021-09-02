package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Course;

public interface CourseService {
    Course getOrCreate(String name);
}
