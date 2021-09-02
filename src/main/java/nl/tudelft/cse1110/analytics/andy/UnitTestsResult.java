package nl.tudelft.cse1110.analytics.andy;

import java.util.List;

public record UnitTestsResult(int testsFound, int testsRan, int testsSucceeded, List<TestFailureInfo> failures, String console, boolean wasExecuted) {
}
