package com.example.ESA_Spring.services;
import com.example.ESA_Spring.models.Department;
import com.example.ESA_Spring.repositories.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }
    @Transactional
    public Long create(Department department) {
        departmentRepository.persist(department);
        return department.getId();
    }
    @Transactional
    public void delete(Long id) {
        departmentRepository.delete(id);
    }
}
