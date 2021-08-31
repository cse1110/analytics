package nl.tudelft.cse1110.analytics.andy;

import java.util.List;

public record CompilationResult(List<CompilationErrorInfo> errors, boolean configurationError, boolean wasExecuted) {
}
