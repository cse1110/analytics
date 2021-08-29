package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "exercises", indexes = {
        @Index(columnList = "name,course_id", unique = true)
})
public class Exercise {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "exercise")
    private Set<CodeCheck> codeChecks;

    @OneToMany(mappedBy = "exercise")
    private Set<MetaTest> metaTests;

    @OneToMany(mappedBy = "exercise")
    private Set<Submission> submissions;

    public Exercise(UUID id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Exercise() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<CodeCheck> getCodeChecks() {
        return codeChecks;
    }

    public void setCodeChecks(Set<CodeCheck> codeChecks) {
        this.codeChecks = codeChecks;
    }

    public Set<MetaTest> getMetaTests() {
        return metaTests;
    }

    public void setMetaTests(Set<MetaTest> metaTests) {
        this.metaTests = metaTests;
    }

    public Set<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }
}
