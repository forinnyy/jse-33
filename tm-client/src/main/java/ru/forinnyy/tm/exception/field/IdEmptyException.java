package ru.forinnyy.tm.exception.field;

public final class IdEmptyException extends AbstractFieldException {

    public IdEmptyException() {
        super("Error! Id is empty...");
    }

}
