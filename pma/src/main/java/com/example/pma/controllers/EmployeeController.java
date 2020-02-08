package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayAllEmployees(Model model){
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String createNewEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String saveToDatabase(Employee employee, Model model){

        empRepo.save(employee);
        return "redirect:/employee";
    }
}
