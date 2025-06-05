package ru.forinnyy.tm.comparator;

import ru.forinnyy.tm.api.model.IHasStatus;

import java.util.Comparator;

public enum StatusComparator implements Comparator<IHasStatus> {

    INSTANCE;

    @Override
    public int compare(final IHasStatus o1, final IHasStatus o2) {
        if (o1 == null || o2 == null) return 0;
        if (o1.getStatus() == null || o2.getStatus() == null) return 0;
        return o1.getStatus().compareTo(o2.getStatus());
    }

}