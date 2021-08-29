package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "code_check_submissions", indexes = {
        @Index(columnList = "code_check_id,submission_id", unique = true)
})
public class CodeCheckSubmission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "code_check_id", nullable = false)
    private CodeCheck codeCheck;

    @ManyToOne
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @Column(name = "passed", nullable = false)
    private boolean passed;

    public CodeCheckSubmission(UUID id, CodeCheck codeCheck, Submission submission, boolean passed) {
        this.id = id;
        this.codeCheck = codeCheck;
        this.submission = submission;
        this.passed = passed;
    }

    public CodeCheckSubmission() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CodeCheck getCodeCheck() {
        return codeCheck;
    }

    public void setCodeCheck(CodeCheck codeCheck) {
        this.codeCheck = codeCheck;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
