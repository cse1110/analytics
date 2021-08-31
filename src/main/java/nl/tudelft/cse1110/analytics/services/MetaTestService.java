package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Exercise;
import nl.tudelft.cse1110.analytics.entities.MetaTest;

public interface MetaTestService {
    MetaTest getOrCreate(Exercise exercise, String name);
}
