package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayAllProjects(Model model){
        model.addAttribute("projects", proRepo.findAll());
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("allEmployees", empRepo.findAll());
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        // this should handle saving to the databse...
        proRepo.save(project);

        return "redirect:/projects";
    }
}
