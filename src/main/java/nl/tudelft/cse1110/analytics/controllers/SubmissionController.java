package nl.tudelft.cse1110.analytics.controllers;

import nl.tudelft.cse1110.analytics.andy.SubmissionDTO;
import nl.tudelft.cse1110.analytics.services.SubmissionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public void save(@RequestBody SubmissionDTO submission) {
        submissionService.save(submission);
    }
}
