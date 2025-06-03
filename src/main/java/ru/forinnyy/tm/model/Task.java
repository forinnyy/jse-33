package ru.forinnyy.tm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.forinnyy.tm.api.model.IWBS;
import ru.forinnyy.tm.enumerated.Status;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public final class Task extends AbstractUserOwnedModel implements IWBS {

    private static final long serialVersionUID = 1;

    @NonNull
    private String name = "";

    @NonNull
    private String description = "";

    @NonNull
    private Status status = Status.NOT_STARTED;

    private String projectId;

    @NonNull
    private Date created = new Date();

    public Task(@NonNull final String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " : " + description;
    }

}
