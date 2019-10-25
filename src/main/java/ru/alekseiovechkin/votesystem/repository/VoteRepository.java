package ru.alekseiovechkin.votesystem.repository;

import ru.alekseiovechkin.votesystem.model.Vote;

import java.util.List;

public interface VoteRepository {
    Vote get(int id);

    void create(Vote vote);

    void update(Vote vote);

    List<Vote> getAll();
}
