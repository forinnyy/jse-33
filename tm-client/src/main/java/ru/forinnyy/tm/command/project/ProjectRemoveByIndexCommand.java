package ru.forinnyy.tm.command.project;

import lombok.NonNull;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.entity.ProjectNotFoundException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.Project;
import ru.forinnyy.tm.util.TerminalUtil;

public final class ProjectRemoveByIndexCommand extends AbstractProjectCommand {

    @NonNull
    private static final String NAME = "project-remove-by-index";

    @NonNull
    private static final String DESCRIPTION = "Remove project by index.";

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
    public void execute() throws AbstractEntityException, AbstractFieldException, AbstractUserException {
        System.out.println("[REMOVE PROJECT BY INDEX]");
        System.out.println("ENTER INDEX:");
        @NonNull final String userId = getUserId();
        @NonNull final Integer index = TerminalUtil.nextNumber() -1;
        final Project project = getProjectService().findOneByIndex(userId, index);
        if (project == null) throw new ProjectNotFoundException();
        getProjectTaskService().removeProjectById(userId, project.getId());
    }

}
