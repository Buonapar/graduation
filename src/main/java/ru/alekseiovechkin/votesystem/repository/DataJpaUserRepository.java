package ru.alekseiovechkin.votesystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import ru.alekseiovechkin.votesystem.model.User;

import java.util.List;

public class DataJpaUserRepository {
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "registered");

    @Autowired
    private CrudUserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public User get(int id) {
        return repository.getById(id);
    }

    public boolean delete(int id) {
        return repository.deleteUserById(id) != 0;
    }

    public User getByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    public List<User> getAll() {
        return repository.findAll(SORT_BY_DATE);
    }
}
