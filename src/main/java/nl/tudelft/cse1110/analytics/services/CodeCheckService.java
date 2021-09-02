package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.CodeCheck;
import nl.tudelft.cse1110.analytics.entities.Exercise;

public interface CodeCheckService {
    CodeCheck getOrCreate(Exercise exercise, String name, int weight);
}
