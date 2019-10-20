package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Transactional
    @Modifying
    @EntityGraph(Restaurant.WITH_MENU)
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int deleteDishById(@Param("id") int id);

    @EntityGraph(Restaurant.WITH_MENU)
    Restaurant getById(@Param("id") int id);

    @EntityGraph(Restaurant.WITH_MENU)
    List<Restaurant> getAllByMenuDate(@Param("date") LocalDate date, Sort sort);

    @Override
    @EntityGraph(Restaurant.WITH_MENU)
    List<Restaurant> findAll(Sort sort);
}
