package ru.alekseiovechkin.votesystem.to;

import java.time.LocalDate;

public class DishTo extends AbstractBaseTo {
    private String name;
    private  int price;
    private int restaurantId;
    private LocalDate date;

    public DishTo() {
    }

    public DishTo(Integer id, String name, int price, int restaurantId, LocalDate date) {
        super(id);
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DishTo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
