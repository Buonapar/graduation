package ru.alekseiovechkin.votesystem.util;

import ru.alekseiovechkin.votesystem.HasId;

public class ValidationUtil {

    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalArgumentException(bean + " must be new (id=null)");
        }
    }
}
