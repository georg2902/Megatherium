package org.rolofge.application.backend.service;

import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<ProjectDto> getProjectsById(String projectId) {
        return repository.findAllById(projectId).stream()
                .map(ProjectDto::of)
                .collect(Collectors.toList());
    }
}
