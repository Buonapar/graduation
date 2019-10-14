package ru.alekseiovechkin.votesystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meals", uniqueConstraints = @UniqueConstraint(columnNames = {"restaurant_id", "name"}, name = "meal_unique_name_idx"))
@NamedEntityGraph(
        name = Meal.WITH_PARENTS,
        attributeNodes = @NamedAttributeNode(value = "restaurant", subgraph = "menu"),
        subgraphs = @NamedSubgraph(name = "menu", attributeNodes = @NamedAttributeNode("menu")))
public class Meal extends AbstractNamedEntity {
    public static final String WITH_PARENTS = "Meal.withParents";
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
