package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.AuthorizedUser;
import ru.alekseiovechkin.votesystem.model.User;

import java.util.List;
@Repository("userRepository")
public class DataJpaUserRepository implements UserRepository, UserDetailsService {
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
    public User create(User user) {
        return repository.save(user);
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

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
