package com.itshala.teamtaskmanager.repository;

import com.itshala.teamtaskmanager.entity.Task;
import com.itshala.teamtaskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    long countByStatus(String status);

    List<Task> findByDueDateBeforeAndStatusNot(LocalDate date, String status);

    List<Task> findByAssignedUser(User user);
}