package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.model.Vote;

import java.util.List;

@Repository
public class DataJpaVoteRepository implements VoteRepository{
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "date", "id");

    private CrudVoteRepository repository;

    public DataJpaVoteRepository(CrudVoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Vote create(Vote vote) {
        return repository.save(vote);
    }

    @Override
    public void update(Vote vote) {
        repository.save(vote);
    }

    @Override
    public List<Vote> getAll() {
        return repository.findAll(SORT_BY_DATE);
    }
}
