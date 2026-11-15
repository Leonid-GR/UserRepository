import org.example.User;
import org.example.UserRepository;
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
    @Test
    public void testFindUserByIdNotFound() {
        UserRepository repository = new UserRepository();

        Optional<User> result = repository.findUserById(10);

        assertFalse(result.isPresent());
    }
    @Test
    public void testFindUserByEmail() {
        UserRepository repository = new UserRepository();

        User user = new User(1, "Ivan", "ivan@gmail.com");
        repository.addUser(user);

        Optional<User> result =
                repository.findUserByEmail("ivan@gmail.com");

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
    }
    @Test
    public void testFindUserByEmailNotFound() {
        UserRepository repository = new UserRepository();

        Optional<User> result =
                repository.findUserByEmail("unknown@gmail.com");

        assertFalse(result.isPresent());
    }
    @Test
    public void testFindAllUsers() {
        UserRepository repository = new UserRepository();

        repository.addUser(new User(1, "Leonid", "leonid@gmail.com"));
        repository.addUser(new User(2, "Ivan", "ivan@gmail.com"));

        Optional<List<User>> result = repository.findAllUsers();

        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
    }
    @Test
    public void testFindAllUsersEmpty() {
        UserRepository repository = new UserRepository();

        Optional<List<User>> result = repository.findAllUsers();

        assertFalse(result.isPresent());
    }
}
