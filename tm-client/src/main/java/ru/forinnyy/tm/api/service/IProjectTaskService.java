package ru.forinnyy.tm.api.service;

import lombok.NonNull;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.Task;

public interface IProjectTaskService {

    @NonNull
    Task bindTaskToProject(String userId, String projectId, String taskId) throws AbstractFieldException, AbstractEntityException, AbstractUserException;

    void removeProjectById(String userId, String projectId) throws AbstractFieldException, AbstractEntityException, AbstractUserException;

    @NonNull
    Task unbindTaskFromProject(String userId, String projectId, String taskId) throws AbstractFieldException, AbstractEntityException, AbstractUserException;

}
