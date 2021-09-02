package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Exercise;

public interface ExerciseService {
    Exercise getOrCreate(String name, String courseName);
}
