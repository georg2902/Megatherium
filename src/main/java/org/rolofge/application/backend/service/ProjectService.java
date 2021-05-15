package org.rolofge.application.backend.service;

import org.hibernate.boot.model.source.spi.Sortable;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.entity.Project;
import org.rolofge.application.backend.repository.ProjectRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public List<ProjectDto> getProjects(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset / limit, limit)).stream()
                .map(ProjectDto::of)
                .collect(Collectors.toList());
    }

    public long getProjectsCount(int offset, int limit) {
        return repository.findAll(PageRequest.of(offset / limit, limit)).stream()
                .count();
    }

    public ProjectDto createProject(ProjectDto projectDto) {
//        Project newProject = new Project();
//        newProject.setUserId(projectDto.getUserId());
//        newProject.setName(projectDto.getName());
//        newProject.setId(projectDto.getUserId());
        return ProjectDto.of(repository.save(ProjectDto.toEntity(projectDto)));
    }
}
