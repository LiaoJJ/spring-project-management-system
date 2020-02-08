package com.example.pma.controllers;

import com.example.pma.dao.EmployeeRepository;
import com.example.pma.dao.ProjectRepository;
import com.example.pma.dto.EmployeeProject;
import com.example.pma.dto.StageCount;
import com.example.pma.entities.Employee;
import com.example.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
            List<Project> projects =  proRepo.findAll();
            model.addAttribute("projects", projects);

            List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
            model.addAttribute("employeesProjectCnt", employeesProjectCnt);

            List<StageCount> projectData = proRepo.stageCount();
            // convert projectData into json for use in js
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(projectData);
            model.addAttribute("projectStatusCnt", jsonString);

            return "main/home";
    }
}
