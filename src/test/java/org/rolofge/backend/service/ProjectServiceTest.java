package org.rolofge.backend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.repository.ProjectRepository;
import org.rolofge.application.backend.service.ProjectService;
import org.rolofge.application.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {JpaConfig.class})
public class ProjectServiceTest {
    @Autowired
    private ProjectRepository repository;

    @Test
    public void testById() {
        ProjectService service = new ProjectService(repository);
        List<ProjectDto> projectsById = service.getProjectsById("1");
        System.out.println(projectsById);
    }

    @Test
    public void testAll() {
        ProjectService service = new ProjectService(repository);
        List<ProjectDto> projectsById = service.getProjects(0,10);
        System.out.println(projectsById);
    }
}