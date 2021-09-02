package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.andy.SubmissionDTO;
import nl.tudelft.cse1110.analytics.entities.*;
import nl.tudelft.cse1110.analytics.repositories.SubmissionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    private final ExerciseService exerciseService;
    private final StudentService studentService;
    private final CodeCheckService codeCheckService;
    private final MetaTestService metaTestService;
    private final SubmissionRepository submissionRepository;

    public SubmissionServiceImpl(ExerciseService exerciseService, StudentService studentService, CodeCheckService codeCheckService, MetaTestService metaTestService, SubmissionRepository submissionRepository) {
        this.exerciseService = exerciseService;
        this.studentService = studentService;
        this.codeCheckService = codeCheckService;
        this.metaTestService = metaTestService;
        this.submissionRepository = submissionRepository;
    }

    @Override
    public void save(SubmissionDTO submissionDTO) {
        Exercise exercise = exerciseService.getOrCreate(submissionDTO.metaData().exercise(), submissionDTO.metaData().course());
        Student student = studentService.getOrCreate(submissionDTO.metaData().studentId(), submissionDTO.metaData().studentName());
        Submission submission = new Submission();
        submission.setExercise(exercise);
        submission.setStudent(student);
        submission.setTimestamp(Timestamp.from(Instant.now()));
        if (submissionDTO.result().compilation().wasExecuted()) {
            submission.setCompiled(true);
            submission.setGrade(submissionDTO.result().finalGrade());
            if (submissionDTO.result().tests().wasExecuted()) {
                submission.setjUnitPassed(submissionDTO.result().tests().testsSucceeded());
                submission.setjUnitTotal(submissionDTO.result().tests().testsRan());
            }
            if (submissionDTO.result().coverage().wasExecuted()) {
                submission.setLineCoverageCovered(submissionDTO.result().coverage().totalCoveredLines());
                submission.setLineCoverageTotal(submissionDTO.result().coverage().totalLines());
                submission.setInstructionCoverageCovered(submissionDTO.result().coverage().totalCoveredInstructions());
                submission.setInstructionCoverageTotal(submissionDTO.result().coverage().totalInstructions());
                submission.setBranchCoverageCovered(submissionDTO.result().coverage().totalCoveredBranches());
                submission.setBranchCoverageTotal(submissionDTO.result().coverage().totalBranches());
            }
            if (submissionDTO.result().mutationTesting().wasExecuted()) {
                submission.setMutantsKilled(submissionDTO.result().mutationTesting().killedMutants());
                submission.setMutantsTotal(submissionDTO.result().mutationTesting().totalNumberOfMutants());
            }
            if (submissionDTO.result().codeChecks().wasExecuted()) {
                submission.setCodeCheckSubmissions(submissionDTO.result().codeChecks().checkResults().stream().map(codeCheckResult -> new CodeCheckSubmission(null, codeCheckService.getOrCreate(exercise, codeCheckResult.description(), codeCheckResult.weight()), submission, codeCheckResult.passed())).collect(Collectors.toSet()));
            }
            if (submissionDTO.result().metaTests().wasExecuted()) {
                submission.setMetaTestSubmissions(submissionDTO.result().metaTests().metaTestResults().stream().map(metaTestResult -> new MetaTestSubmission(null, metaTestService.getOrCreate(exercise, metaTestResult.name()), submission, metaTestResult.succeeded())).collect(Collectors.toSet()));
            }
        }
        submissionRepository.save(submission);
    }
}
