package com.example.ESA_Spring.controllers;
import com.example.ESA_Spring.models.Department;
import com.example.ESA_Spring.models.Student;
import com.example.ESA_Spring.services.DepartmentService;
import com.example.ESA_Spring.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.example.ESA_Spring.ObjectToDomTransformer;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final DepartmentService departmentService;
    private final StudentService studentService;

    @GetMapping(value = "/departments_table")
    public String getDepartments(Model model) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("departments");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);
        List<Department> departments = departmentService.getAll();
        for (Department department : departments) {
            transformer.transform(element, department, "department");
        }
        model.addAttribute("departments", element);
        return "departments";
    }

    @GetMapping(value = "/students_table")
    public String getStudents(Model model) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("students");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);
        List<Student> students = studentService.getAll();
        for (Student student : students) {
            transformer.transform(element, student, "student");
        }
        model.addAttribute("students", element);
        return "students";
    }

}
