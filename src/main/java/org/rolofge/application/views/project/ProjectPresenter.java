package org.rolofge.application.views.project;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.shared.Registration;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectPresenter {
    private final Logger LOGGER = LoggerFactory.getLogger(ProjectPresenter.class);
    private ProjectView view;
    private final ProjectService projectService;
    private DataProvider<ProjectDto, Void> dataProvider;



    public ProjectPresenter(ProjectService projectService) {
        this.projectService = projectService;
    }

    public void init(ProjectView view) {
        this.view = view;
        this.dataProvider = initDataprovider();
    }



    private DataProvider<ProjectDto, Void> initDataprovider() {
        return DataProvider.fromCallbacks(
                query -> projectService.getProjects(query.getOffset(), query.getLimit()).stream(),
                query -> (int) projectService.getProjectsCount(query.getOffset(), query.getLimit()));
    }

    public DataProvider<ProjectDto, Void> getDataprovider() {
        return this.dataProvider;
    }
}
