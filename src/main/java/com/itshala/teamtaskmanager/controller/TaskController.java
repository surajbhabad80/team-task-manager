package com.itshala.teamtaskmanager.controller;

import com.itshala.teamtaskmanager.entity.Task;
import com.itshala.teamtaskmanager.entity.User;
import com.itshala.teamtaskmanager.repository.ProjectRepository;
import com.itshala.teamtaskmanager.repository.UserRepository;
import com.itshala.teamtaskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @GetMapping
    public String tasks(Model model, Authentication authentication) {

        User loggedUser = userRepository.findByEmail(authentication.getName()).orElseThrow();

        if ("ADMIN".equals(loggedUser.getRole())) {
            model.addAttribute("tasks", taskService.getAllTasks());
        } else {
            model.addAttribute("tasks", taskService.getTasksByUser(loggedUser));
        }

        model.addAttribute("role", loggedUser.getRole());
        return "tasks";
    }

    @GetMapping("/add")
    public String addTaskPage(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "add-task";
    }

    @PostMapping("/add")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/update-status/{id}")
    public String updateTaskStatus(@PathVariable Long id,
                                   @RequestParam String status) {
        taskService.updateTaskStatus(id, status);
        return "redirect:/tasks";
    }
}