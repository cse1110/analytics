package nl.tudelft.cse1110.analytics.andy;

import java.util.List;

public record MetaTestsResult(boolean wasExecuted, int score, int totalTests, List<MetaTestResult> metaTestResults) {
}
