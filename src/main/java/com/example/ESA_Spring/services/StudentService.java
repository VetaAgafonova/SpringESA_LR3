package com.example.ESA_Spring.services;
import com.example.ESA_Spring.models.Student;
import com.example.ESA_Spring.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getAll() {
        return studentRepository.getAll();
    }
    @Transactional
    public Long create(Student student) {
        studentRepository.persist(student);
        return student.getId();
    }
    @Transactional
    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
