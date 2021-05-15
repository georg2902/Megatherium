package org.rolofge.application.views.project;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import org.rolofge.application.backend.data.ProjectDto;
import org.rolofge.application.backend.service.ProjectService;

public class CreateProjectDialog extends Dialog {
    private Binder<ProjectDto> binder = new Binder<>(ProjectDto.class);
    private Registration submitButtonRegistration;
    private CreateProjectDialogPresenter presenter;

    public CreateProjectDialog() {
        super();
    }

    public void init(ProjectService projectService, ProjectPresenter projectPresenter) {
        this.setCloseOnOutsideClick(true);
        this.setCloseOnEsc(true);
        this.presenter = new CreateProjectDialogPresenter(projectService);
        this.presenter.init(this);
        VerticalLayout wrapperLayout = new VerticalLayout();

        FormLayout formLayout = new FormLayout();
        TextField nameTextfield = new TextField("project name");
        Button submitButton = new Button("Create");



        formLayout.addFormItem(nameTextfield, "");
        formLayout.addFormItem(submitButton,"");
        binder.setBean(presenter.getProjectDto());
        binder.forField(nameTextfield)
        .bind(
                ProjectDto::getName,
                ProjectDto::setName
        );

        wrapperLayout.add(formLayout);
        add(wrapperLayout);

        if(submitButtonRegistration != null){
            submitButtonRegistration.remove();
        }
        submitButtonRegistration = submitButton.addClickListener(event -> {
            try {
                binder.writeBean(presenter.getProjectDto());
                presenter.createNewProject();
                projectPresenter.getDataprovider().refreshAll();
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        });
    }


}
