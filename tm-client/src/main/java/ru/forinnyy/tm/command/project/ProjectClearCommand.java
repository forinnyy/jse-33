package ru.forinnyy.tm.command.project;

import lombok.NonNull;
import ru.forinnyy.tm.dto.request.ProjectClearRequest;
import ru.forinnyy.tm.dto.request.ProjectListRequest;
import ru.forinnyy.tm.dto.request.TaskListByProjectIdRequest;
import ru.forinnyy.tm.dto.request.TaskRemoveByIdRequest;
import ru.forinnyy.tm.dto.response.ProjectListResponse;
import ru.forinnyy.tm.dto.response.TaskListByProjectIdResponse;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.Project;
import ru.forinnyy.tm.model.Task;

import java.util.List;

public final class ProjectClearCommand extends AbstractProjectCommand {

    @NonNull
    private static final String NAME = "project-clear";

    @NonNull
    private static final String DESCRIPTION = "Delete all projects.";

    @NonNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() throws AbstractUserException, AbstractFieldException {
        System.out.println("[CLEAR PROJECTS]");

        @NonNull final ProjectClearRequest request = new ProjectClearRequest();
        getProjectEndpointClient().clearProject(request);
    }

}
