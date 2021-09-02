package nl.tudelft.cse1110.analytics.services;

import nl.tudelft.cse1110.analytics.entities.Student;
import nl.tudelft.cse1110.analytics.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getOrCreate(String studentId, String name) {
        Optional<Student> optional = studentRepository.findByStudentId(studentId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            Student student = new Student();
            student.setStudentId(studentId);
            student.setName(name);
            return studentRepository.save(student);
        }
    }
}
