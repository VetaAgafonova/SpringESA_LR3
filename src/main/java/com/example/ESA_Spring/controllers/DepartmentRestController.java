package com.example.ESA_Spring.controllers;
import com.example.ESA_Spring.models.Department;
import com.example.ESA_Spring.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentService departmentService;

    @GetMapping(path = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void create(@RequestBody Department department) {
        departmentService.create(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
