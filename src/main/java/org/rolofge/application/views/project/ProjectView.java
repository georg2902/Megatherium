package org.rolofge.application.views.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.service.ProjectService;
import org.rolofge.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Projekte")
@CssImport("./styles/views/project/project-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class ProjectView extends HorizontalLayout {

    private ProjectPresenter projectPresenter;
    @Autowired
    private final ProjectService projectService;
    private Button createProjectBtn = new Button();
    private CreateProjectDialog createProjectDialog;
    private Registration createProjectRegistration;

    public ProjectView(ProjectService projectService) {
        this.projectService = projectService;
        addClassName("project-view");

        this.createProjectDialog = new CreateProjectDialog();

        this.projectPresenter = new ProjectPresenter(this.projectService);
        this.projectPresenter.init(this);

        this.add(createProjectDialog);

        VerticalLayout wrapperLayout = new VerticalLayout();

        this.createProjectBtn = new Button("create-Project");

        if (this.createProjectRegistration != null){
            this.createProjectRegistration.remove();
        }
        this.createProjectBtn.addClickListener(event -> {
            this.createProjectDialog.init(projectService, projectPresenter);
            this.createProjectDialog.open();
        });

        Grid<ProjectDto> projectGrid = new Grid<>();
        projectGrid.setDataProvider(projectPresenter.getDataprovider());
        projectGrid.addColumn(ProjectDto::getName).setHeader("name");

        wrapperLayout.add(createProjectBtn);
        wrapperLayout.add(projectGrid);

        add(wrapperLayout);
    }

    public Button getCreateProjectBtn() {
        return this.createProjectBtn;
    }


    public CreateProjectDialog getCreateProjectDialog() {
        return this.createProjectDialog;
    }
}
