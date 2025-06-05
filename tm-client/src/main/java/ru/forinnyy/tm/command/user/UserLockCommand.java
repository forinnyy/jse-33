package ru.forinnyy.tm.command.user;

import lombok.NonNull;
import ru.forinnyy.tm.enumerated.Role;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.util.TerminalUtil;

public final class UserLockCommand extends AbstractUserCommand {

    @NonNull
    private static final String NAME = "user-lock";

    @NonNull
    private static final String DESCRIPTION = "Lock user.";

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

    @NonNull
    @Override
    public Role[] getRoles() {
        return  new Role[] {
                Role.ADMIN
        };
    }

    @Override
    public void execute() throws AbstractFieldException, AbstractUserException, AbstractEntityException {
        System.out.println("[USER LOCK]");
        System.out.println("ENTER LOGIN");
        @NonNull final String login = TerminalUtil.nextLine();
        getUserService().lockUserByLogin(login);
    }

}
