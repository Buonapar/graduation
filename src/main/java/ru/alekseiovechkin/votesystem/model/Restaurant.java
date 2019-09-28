package ru.alekseiovechkin.votesystem.model;

import java.util.List;

public class Restaurant  extends AbstractNamedEntity{
    private List<Meal> menu;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Meal> menu) {
        super(id, name);
        this.menu = menu;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
