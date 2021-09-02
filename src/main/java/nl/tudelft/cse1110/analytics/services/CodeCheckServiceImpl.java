package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.CodeCheck;
import nl.tudelft.cse1110.analytics.entities.Exercise;
import nl.tudelft.cse1110.analytics.repositories.CodeCheckRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodeCheckServiceImpl implements CodeCheckService {
    private final CodeCheckRepository codeCheckRepository;

    public CodeCheckServiceImpl(CodeCheckRepository codeCheckRepository) {
        this.codeCheckRepository = codeCheckRepository;
    }

    @Override
    public CodeCheck getOrCreate(Exercise exercise, String name, int weight) {
        Optional<CodeCheck> optional = codeCheckRepository.findByExerciseAndName(exercise, name);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            CodeCheck codeCheck = new CodeCheck();
            codeCheck.setExercise(exercise);
            codeCheck.setName(name);
            codeCheck.setWeight(weight);
            return codeCheckRepository.save(codeCheck);
        }
    }
}
