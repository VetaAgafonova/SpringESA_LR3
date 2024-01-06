package com.example.ESA_Spring.repositories;

import com.example.ESA_Spring.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Student> getAll() {
        return em.createQuery("select i from Student i", Student.class).getResultList();
    }

    public void persist(Student student) {
        em.persist(student);
    }

    public void delete(Long id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }
}
