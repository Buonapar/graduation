package ru.alekseiovechkin.votesystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.alekseiovechkin.votesystem.repository.DataJpaRestaurantRepositoryTest;
import ru.alekseiovechkin.votesystem.repository.DataJpaUserRepositoryTest;
import ru.alekseiovechkin.votesystem.repository.DataJpaVoteRepositoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        DataJpaRestaurantRepositoryTest.class,
        DataJpaUserRepositoryTest.class,
        DataJpaVoteRepositoryTest.class
})
public class AllTest {
}
