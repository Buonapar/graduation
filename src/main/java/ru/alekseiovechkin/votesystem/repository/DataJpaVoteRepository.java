package ru.alekseiovechkin.votesystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alekseiovechkin.votesystem.model.User;
import ru.alekseiovechkin.votesystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DataJpaVoteRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "date", "id");

    @Autowired
    private CrudVoteRepository repository;

    @Autowired
    private CrudUserRepository userRepository;

    @Transactional
    public Vote save(Vote vote, int userId) {
        User user = userRepository.findById(userId).orElse(null);
        vote.setUser(user);

        if (vote.isNew()) {
            return repository.save(vote);
        } else {
            return get(vote.getId(), userId) == null ? null : repository.save(vote);
        }
    }

    public Vote get(int id, int userId) {
        return repository.getByIdAndUser_Id(id, userId);
    }

    @Transactional
    public boolean delete(int id, int userId) {
        return repository.delete(id, userId) != 0;
    }

    public List<Vote> getAll(int userId) {
        return repository.getAllByUser_Id(userId, SORT_BY_DATE);
    }

    public List<Vote> getAll() {
        return repository.findAll(SORT_BY_DATE);
    }

    public List<Vote> getAllByDate(int userId, LocalDate date) {
        return repository.getAllByUser_IdAndDate(userId, date, SORT_BY_DATE);
    }
}
