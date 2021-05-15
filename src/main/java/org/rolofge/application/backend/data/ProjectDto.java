package org.rolofge.application.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rolofge.application.backend.entity.Project;

@Data
@AllArgsConstructor
public class ProjectDto {
    private String id;
    private String name;
    private String userId;

    public ProjectDto(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public static ProjectDto of(Project entity) {
        return new ProjectDto(entity.getId(), entity.getName(), entity.getUserId());
    }

    public static Project toEntity(ProjectDto projectDto) {
        return Project.builder()
                .name(projectDto.getName())
                .userId(projectDto.getUserId())
                .build();
    }
}
