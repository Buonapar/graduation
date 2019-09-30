package ru.alekseiovechkin.votesystem.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Meal extends AbstractNamedEntity {
    private Restaurant restaurant;
    private int price;
    private LocalDateTime dateTime;

    public Meal() {
    }

    public Meal(Integer id, String name, Restaurant restaurant, int price, LocalDateTime dateTime) {
        super(id, name);
        this.restaurant = restaurant;
        this.price = price;
        this.dateTime = dateTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
