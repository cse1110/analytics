package nl.tudelft.cse1110.analytics.andy;

public record MutationTestingResult(boolean wasExecuted, int killedMutants, int totalNumberOfMutants) {
}
