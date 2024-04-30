package project.server.Entities;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import project.server.Repositories.UserRepo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Period;

public class UserTest {

    private UserRepo userRepository = Mockito.mock(UserRepo.class);;

    @Test
    public void testGetAge() {
        User user = new User();
        user.setDob("2000-01-01");
        int expectedAge = Period.between(LocalDate.parse("2000-01-01"), LocalDate.now()).getYears();
        assertEquals(expectedAge, user.getAge());
    }

    @Test
    public void testEmailNotNull() {
        User user = new User();
        user.setEmail(null);
        when(userRepository.save(user)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> userRepository.save(user));
    }

    @Test
    public void testUsernameNotNull() {
        User user = new User();
        user.setUsername(null);
        when(userRepository.save(user)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> userRepository.save(user));
    }

    @Test
    public void testPasswordNotNull() {
        User user = new User();
        user.setPassword(null);
        when(userRepository.save(user)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> userRepository.save(user));
    }
    
}
