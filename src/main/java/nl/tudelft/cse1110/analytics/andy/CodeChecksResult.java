package nl.tudelft.cse1110.analytics.andy;

import java.util.List;

public record CodeChecksResult(boolean wasExecuted, List<CodeCheckResult> checkResults) {
}
