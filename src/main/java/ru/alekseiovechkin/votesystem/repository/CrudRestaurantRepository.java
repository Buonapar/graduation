package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alekseiovechkin.votesystem.model.Restaurant;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
