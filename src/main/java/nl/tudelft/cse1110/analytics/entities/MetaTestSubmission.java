package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "meta_test_submissions", indexes = {
        @Index(columnList = "meta_test_id,submission_id", unique = true)
})
public class MetaTestSubmission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "meta_test_id", nullable = false)
    private MetaTest metaTest;

    @ManyToOne
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @Column(name = "passed", nullable = false)
    private boolean passed;

    public MetaTestSubmission(UUID id, MetaTest metaTest, Submission submission, boolean passed) {
        this.id = id;
        this.metaTest = metaTest;
        this.submission = submission;
        this.passed = passed;
    }

    public MetaTestSubmission() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MetaTest getMetaTest() {
        return metaTest;
    }

    public void setMetaTest(MetaTest metaTest) {
        this.metaTest = metaTest;
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
