package ru.forinnyy.tm.dto.response;

import ru.forinnyy.tm.model.Task;

public final class TaskCompleteByIdResponse extends AbstractTaskResponse {

    public TaskCompleteByIdResponse(Task task) {
        super(task);
    }

}
