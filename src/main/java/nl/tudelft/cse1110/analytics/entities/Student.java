package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "students", indexes = {
        @Index(columnList = "student_id", unique = true)
})
public class Student {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @OneToMany(mappedBy = "student")
    private Set<Submission> submissions;

    public Student(UUID id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }

    public Student() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Set<Submission> submissions) {
        this.submissions = submissions;
    }
}
