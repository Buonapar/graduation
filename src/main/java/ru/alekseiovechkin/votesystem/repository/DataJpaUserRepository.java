package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.model.User;

import java.util.List;
@Repository
public class DataJpaUserRepository implements UserRepository{
    private static final Sort SORT_BY_DATE = new Sort(Sort.Direction.DESC, "registered");

    private CrudUserRepository repository;

    public DataJpaUserRepository(CrudUserRepository crudUserRepository) {
        this.repository = crudUserRepository;
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll(SORT_BY_DATE);
    }
}
