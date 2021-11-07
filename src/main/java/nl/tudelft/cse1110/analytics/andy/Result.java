package nl.tudelft.cse1110.analytics.andy;

public record Result(CompilationResult compilation, UnitTestsResult tests, MutationTestingResult mutationTesting, CodeChecksResult codeChecks, CoverageResult coverage, MetaTestsResult metaTests, int finalGrade, GenericFailure genericFailure, double timeInSeconds, GradeWeight weights) {
}
