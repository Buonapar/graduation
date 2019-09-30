package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alekseiovechkin.votesystem.model.Meal;

public class DataJpaMealRepository implements JpaRepository<Meal, Integer> {

}
