package com.itshala.teamtaskmanager.controller;

import com.itshala.teamtaskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final TaskService taskService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pendingCount", taskService.getPendingCount());
        model.addAttribute("completedCount", taskService.getCompletedCount());
        model.addAttribute("overdueTasks", taskService.getOverdueTasks());
        return "dashboard";
    }
}