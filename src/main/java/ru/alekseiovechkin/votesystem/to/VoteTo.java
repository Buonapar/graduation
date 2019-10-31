package ru.alekseiovechkin.votesystem.to;

import java.time.LocalDateTime;
import java.util.Objects;

public class VoteTo extends AbstractBaseTo {

    private LocalDateTime dateTime;
    private int restarauntId;
    private int userId;

    public VoteTo() {
    }

    public VoteTo(Integer id, int restarauntId) {
        super(id);
        this.restarauntId = restarauntId;
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getRestarauntId() {
        return restarauntId;
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
        return restarauntId == voteTo.restarauntId &&
                userId == voteTo.userId &&
                dateTime.equals(voteTo.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, restarauntId, userId);
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "dateTime=" + dateTime +
                ", restarauntId=" + restarauntId +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
