package ru.alekseiovechkin.votesystem.to;

import ru.alekseiovechkin.votesystem.HasId;

public class AbstractBaseTo {
    protected Integer id;

    public AbstractBaseTo() {
    }

    public AbstractBaseTo(Integer id) {
        this.id = id;
    }

}
