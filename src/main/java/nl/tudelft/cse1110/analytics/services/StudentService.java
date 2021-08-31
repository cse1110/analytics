package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Student;

public interface StudentService {
    Student getOrCreate(String studentId, String name);
}
