package com.itshala.teamtaskmanager.controller;

import com.itshala.teamtaskmanager.entity.Project;
import com.itshala.teamtaskmanager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/add")
    public String addProjectPage(Project project) {
        return "add-project";
    }

    @PostMapping("/add")
    public String saveProject(@ModelAttribute Project project) {
        projectService.saveProject(project);
        return "redirect:/projects";
    }
}