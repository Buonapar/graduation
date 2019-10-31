package ru.alekseiovechkin.votesystem.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vote")
public class Vote extends AbstractBaseEntity {

    @JoinColumn(name = "restaurant_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDateTime date;

    public Vote() {
    }

    public Vote(Vote v) {
        this(v.getId(), v.getUser(), v.getRestaurant());
    }

    public Vote(Integer id, User user, Restaurant restaurant) {
        this(id, user, restaurant, LocalDateTime.now());
    }

    public Vote(Integer id, User user, Restaurant restaurant, @NotNull LocalDateTime date) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vote vote = (Vote) o;
        return restaurant.equals(vote.restaurant) &&
                user.equals(vote.user) &&
                date.equals(vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), restaurant, user, date);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "user=" + user +
                ", restaurant=" + restaurant +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}