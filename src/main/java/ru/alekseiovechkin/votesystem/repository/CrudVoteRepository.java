package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alekseiovechkin.votesystem.model.Vote;

public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {
}
