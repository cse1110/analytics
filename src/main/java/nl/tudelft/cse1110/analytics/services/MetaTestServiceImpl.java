package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Exercise;
import nl.tudelft.cse1110.analytics.entities.MetaTest;
import nl.tudelft.cse1110.analytics.repositories.MetaTestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetaTestServiceImpl implements MetaTestService {
    private final MetaTestRepository metaTestRepository;

    public MetaTestServiceImpl(MetaTestRepository metaTestRepository) {
        this.metaTestRepository = metaTestRepository;
    }

    @Override
    public MetaTest getOrCreate(Exercise exercise, String name) {
        Optional<MetaTest> optional = metaTestRepository.findByExerciseAndName(exercise, name);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            MetaTest metaTest = new MetaTest();
            metaTest.setExercise(exercise);
            metaTest.setName(name);
            metaTest.setWeight(1);
            return metaTestRepository.save(metaTest);
        }
    }
}
