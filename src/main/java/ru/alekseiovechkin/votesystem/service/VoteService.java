package ru.alekseiovechkin.votesystem.service;

import org.springframework.stereotype.Service;
import ru.alekseiovechkin.votesystem.model.Vote;
import ru.alekseiovechkin.votesystem.repository.DataJpaRestaurantRepository;
import ru.alekseiovechkin.votesystem.repository.DataJpaUserRepository;
import ru.alekseiovechkin.votesystem.repository.DataJpaVoteRepository;

@Service
public class VoteService {
    private DataJpaVoteRepository repository;
    private DataJpaUserRepository userRepository;
    private DataJpaRestaurantRepository restaurantRepository;

    public VoteService(DataJpaVoteRepository repository, DataJpaUserRepository userRepository, DataJpaRestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote create(int restarauntId, int userId) {
        Vote vote = new Vote(null,
                userRepository.get(userId),
                restaurantRepository.get(restarauntId));
        repository.create(vote);
        return vote;
    }
}
