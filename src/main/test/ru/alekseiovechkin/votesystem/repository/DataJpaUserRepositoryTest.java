package ru.alekseiovechkin.votesystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alekseiovechkin.votesystem.model.User;

import java.util.Arrays;
import java.util.List;

import static ru.alekseiovechkin.votesystem.TestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class DataJpaUserRepositoryTest {

    @Autowired
    DataJpaUserRepository repository;

    @Test
    public void get() {
        User user = repository.get(ADMIN_ID);
        Assert.assertEquals(user, user_admin);
    }

    @Test
    public void create() {
       repository.create(user_user2);
       Assert.assertEquals(user_user2, repository.get(USER_ID2));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void delete() {
        repository.delete(USER_ID1);
        Assert.assertEquals(List.of(user_admin), repository.getAll());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void getAll() {
        List<User> actual = repository.getAll();
        List<User> expected = Arrays.asList(user_user1, user_admin);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        User user = user_user1;
        user.setPassword("qwerty");
        repository.update(user);
        Assert.assertEquals(user, repository.get(USER_ID1));
    }
}
