package nl.tudelft.cse1110.analytics.andy;

import java.util.List;

public record CoverageLineByLine(List<Integer> fullyCoveredLines, List<Integer> partiallyCoveredLines, List<Integer> notCoveredLines) {
}
