package com.example.ESA_Spring.repositories;

import com.example.ESA_Spring.models.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Department> getAll() {
        return em.createQuery("select i from Department i", Department.class).getResultList();
    }

    public void persist(Department department) {
        em.persist(department);
    }

    public void delete(Long id) {
        Department department = em.find(Department.class, id);
        em.remove(department);
    }
}
