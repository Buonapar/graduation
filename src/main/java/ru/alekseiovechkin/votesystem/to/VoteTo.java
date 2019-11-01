package ru.alekseiovechkin.votesystem.to;

import java.time.LocalDateTime;
import java.util.Objects;

public class VoteTo extends AbstractBaseTo {

    private LocalDateTime dateTime;
    private int restaurantId;
    private int userId;

    public VoteTo() {
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteTo voteTo = (VoteTo) o;
        return restaurantId == voteTo.restaurantId &&
                userId == voteTo.userId &&
                dateTime.equals(voteTo.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, restaurantId, userId);
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "dateTime=" + dateTime +
                ", restaurantId=" + restaurantId +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
