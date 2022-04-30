package nl.tudelft.cse1110.analytics.andy;

public record GenericFailure (String genericFailureMessage, String stepName, String exceptionMessage, Integer externalProcessExitCode, String externalProcessErrorMessages){
}
