package com.itshala.teamtaskmanager.service;

import com.itshala.teamtaskmanager.entity.Project;
import com.itshala.teamtaskmanager.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }
}