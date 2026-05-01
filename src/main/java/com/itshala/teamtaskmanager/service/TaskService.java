package com.itshala.teamtaskmanager.service;

import com.itshala.teamtaskmanager.entity.Task;
import com.itshala.teamtaskmanager.entity.User;
import com.itshala.teamtaskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByAssignedUser(user);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public long getPendingCount() {
        return taskRepository.countByStatus("PENDING");
    }

    public long getCompletedCount() {
        return taskRepository.countByStatus("COMPLETED");
    }

    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBeforeAndStatusNot(LocalDate.now(), "COMPLETED");
    }

    public void updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(status);
        taskRepository.save(task);
    }
}