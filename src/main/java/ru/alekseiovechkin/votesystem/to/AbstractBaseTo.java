package ru.alekseiovechkin.votesystem.to;

import ru.alekseiovechkin.votesystem.HasId;

public class AbstractBaseTo implements HasId {
    protected Integer id;

    public AbstractBaseTo() {
    }

    public AbstractBaseTo(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }
}
