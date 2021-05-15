package org.rolofge.application.views.project;

import lombok.Getter;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class CreateProjectDialogPresenter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProjectDialogPresenter.class);

    private CreateProjectDialog dialog;
    private final ProjectService service;
    private ProjectDto projectDto;

    CreateProjectDialogPresenter(ProjectService service) {
        this.service = service;
    }

    public void init(CreateProjectDialog dialog) {
        this.dialog = dialog;
        this.projectDto = new ProjectDto("", "1");
    }

    public void createNewProject() {
        LOGGER.debug("Create Project {}", this.projectDto);
        ProjectDto createdProject = this.service.createProject(this.projectDto);
        LOGGER.info("Created Project {}", createdProject);
        this.dialog.close();
    }


}
