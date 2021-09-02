package nl.tudelft.cse1110.analytics.andy;

public record CoverageResult(boolean wasExecuted, int totalCoveredLines, int totalLines, int totalCoveredInstructions, int totalInstructions, int totalCoveredBranches, int totalBranches, CoverageLineByLine coverageLineByLine) {
}
