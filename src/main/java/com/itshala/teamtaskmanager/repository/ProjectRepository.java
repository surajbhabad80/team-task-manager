package com.itshala.teamtaskmanager.repository;

import com.itshala.teamtaskmanager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}