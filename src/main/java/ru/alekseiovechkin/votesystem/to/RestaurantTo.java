package ru.alekseiovechkin.votesystem.to;

import java.util.List;

public class RestaurantTo extends AbstractBaseTo{
    private String name;
    private List<MealTo> menu;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", id=" + id +
                '}';
    }
}
