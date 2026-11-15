package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {


    @Test
    public void testFindUserById() {
        UserRepository repository = new UserRepository();

        User user = new User(1, "Leonid", "leonid@gmail.com");
        repository.addUser(user);

        Optional<User> result = repository.findUserById(1);

        assertTrue(result.isPresent());
        assertEquals("Leonid", result.get().getName());
    }
}
