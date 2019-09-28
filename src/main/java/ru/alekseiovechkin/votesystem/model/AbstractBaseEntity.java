package ru.alekseiovechkin.votesystem.model;

public class AbstractBaseEntity {
    protected Integer id;

    protected AbstractBaseEntity(){}

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
