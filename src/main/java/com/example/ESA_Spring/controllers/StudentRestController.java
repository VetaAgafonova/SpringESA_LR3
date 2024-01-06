package com.example.ESA_Spring.controllers;
import com.example.ESA_Spring.models.Student;
import com.example.ESA_Spring.services.StudentService;
import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentRestController {
    private final StudentService studentService;

    @GetMapping(path = "/all",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
