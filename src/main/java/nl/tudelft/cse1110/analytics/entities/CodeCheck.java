package nl.tudelft.cse1110.analytics.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "code_checks")
public class CodeCheck {
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private int weight;

    @OneToMany(mappedBy = "codeCheck")
    private Set<CodeCheckSubmission> codeCheckSubmissions;

    public CodeCheck(UUID id, Exercise exercise, String name, int weight) {
        this.id = id;
        this.exercise = exercise;
        this.name = name;
        this.weight = weight;
    }

    public CodeCheck() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<CodeCheckSubmission> getCodeCheckSubmissions() {
        return codeCheckSubmissions;
    }

    public void setCodeCheckSubmissions(Set<CodeCheckSubmission> codeCheckSubmissions) {
        this.codeCheckSubmissions = codeCheckSubmissions;
    }
}
