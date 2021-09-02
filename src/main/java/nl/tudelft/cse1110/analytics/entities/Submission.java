package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "submissions")
public class Submission {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    @Column(name = "compiled", nullable = false)
    private boolean compiled;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "junit_passed", nullable = false)
    private int jUnitPassed;

    @Column(name = "junit_total", nullable = false)
    private int jUnitTotal;

    @Column(name = "line_coverage_covered", nullable = false)
    private int lineCoverageCovered;

    @Column(name = "line_coverage_total", nullable = false)
    private int lineCoverageTotal;

    @Column(name = "instruction_coverage_covered", nullable = false)
    private int instructionCoverageCovered;

    @Column(name = "instruction_coverage_total", nullable = false)
    private int instructionCoverageTotal;

    @Column(name = "branch_coverage_covered", nullable = false)
    private int branchCoverageCovered;

    @Column(name = "branch_coverage_total", nullable = false)
    private int branchCoverageTotal;

    @Column(name = "mutants_killed", nullable = false)
    private int mutantsKilled;

    @Column(name = "mutants_total", nullable = false)
    private int mutantsTotal;

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    private Set<CodeCheckSubmission> codeCheckSubmissions;

    @OneToMany(mappedBy = "submission", cascade = CascadeType.ALL)
    private Set<MetaTestSubmission> metaTestSubmissions;

    public Submission(UUID id, Exercise exercise, Student student, Timestamp timestamp, boolean compiled, int grade,
                      int jUnitPassed, int jUnitTotal, int lineCoverageCovered, int lineCoverageTotal,
                      int instructionCoverageCovered, int instructionCoverageTotal, int branchCoverageCovered,
                      int branchCoverageTotal, int mutantsKilled, int mutantsTotal) {
        this.id = id;
        this.exercise = exercise;
        this.student = student;
        this.timestamp = timestamp;
        this.compiled = compiled;
        this.grade = grade;
        this.jUnitPassed = jUnitPassed;
        this.jUnitTotal = jUnitTotal;
        this.lineCoverageCovered = lineCoverageCovered;
        this.lineCoverageTotal = lineCoverageTotal;
        this.instructionCoverageCovered = instructionCoverageCovered;
        this.instructionCoverageTotal = instructionCoverageTotal;
        this.branchCoverageCovered = branchCoverageCovered;
        this.branchCoverageTotal = branchCoverageTotal;
        this.mutantsKilled = mutantsKilled;
        this.mutantsTotal = mutantsTotal;
    }

    public Submission() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isCompiled() {
        return compiled;
    }

    public void setCompiled(boolean compiled) {
        this.compiled = compiled;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getjUnitPassed() {
        return jUnitPassed;
    }

    public void setjUnitPassed(int jUnitPassed) {
        this.jUnitPassed = jUnitPassed;
    }

    public int getjUnitTotal() {
        return jUnitTotal;
    }

    public void setjUnitTotal(int jUnitTotal) {
        this.jUnitTotal = jUnitTotal;
    }

    public int getLineCoverageCovered() {
        return lineCoverageCovered;
    }

    public void setLineCoverageCovered(int lineCoverageCovered) {
        this.lineCoverageCovered = lineCoverageCovered;
    }

    public int getLineCoverageTotal() {
        return lineCoverageTotal;
    }

    public void setLineCoverageTotal(int lineCoverageTotal) {
        this.lineCoverageTotal = lineCoverageTotal;
    }

    public int getInstructionCoverageCovered() {
        return instructionCoverageCovered;
    }

    public void setInstructionCoverageCovered(int instructionCoverageCovered) {
        this.instructionCoverageCovered = instructionCoverageCovered;
    }

    public int getInstructionCoverageTotal() {
        return instructionCoverageTotal;
    }

    public void setInstructionCoverageTotal(int instructionCoverageTotal) {
        this.instructionCoverageTotal = instructionCoverageTotal;
    }

    public int getBranchCoverageCovered() {
        return branchCoverageCovered;
    }

    public void setBranchCoverageCovered(int branchCoverageCovered) {
        this.branchCoverageCovered = branchCoverageCovered;
    }

    public int getBranchCoverageTotal() {
        return branchCoverageTotal;
    }

    public void setBranchCoverageTotal(int branchCoverageTotal) {
        this.branchCoverageTotal = branchCoverageTotal;
    }

    public int getMutantsKilled() {
        return mutantsKilled;
    }

    public void setMutantsKilled(int mutantsKilled) {
        this.mutantsKilled = mutantsKilled;
    }

    public int getMutantsTotal() {
        return mutantsTotal;
    }

    public void setMutantsTotal(int mutantsTotal) {
        this.mutantsTotal = mutantsTotal;
    }

    public Set<CodeCheckSubmission> getCodeCheckSubmissions() {
        return codeCheckSubmissions;
    }

    public void setCodeCheckSubmissions(Set<CodeCheckSubmission> codeCheckSubmissions) {
        this.codeCheckSubmissions = codeCheckSubmissions;
    }

    public Set<MetaTestSubmission> getMetaTestSubmissions() {
        return metaTestSubmissions;
    }

    public void setMetaTestSubmissions(Set<MetaTestSubmission> metaTestSubmissions) {
        this.metaTestSubmissions = metaTestSubmissions;
    }
}
