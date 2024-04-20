package project.server.Services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.server.Entities.User;
import project.server.Repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	// private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getUsers() {
		return repo.findAll();
	}

	public User getUser(int userId) {
		return repo.findById(userId).orElse(null);
	}

    public User createUser(User user) {
		// System.out.println(user);
		Optional<User> userOptional = repo.findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}

		// String password = user.getPassword();

		// String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        // Pattern pattern = Pattern.compile(passwordRegex);
        // if (!pattern.matcher(password).matches()) {
        //     throw new IllegalArgumentException("Password must contain at least one digit, one lower case, one upper case, one special character, no whitespace, and be at least 8 characters long.");
        // }

		// String encryptedPassword = passwordEncoder.encode(password);
        // user.setPassword(encryptedPassword);

		return repo.save(user);
    }

    public String deleteUser(int userId) {
        boolean exists = repo.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("user with id " + userId + " does not exist");
		}
		repo.deleteById(userId);
		return "user with id " + userId + " was successfully deleted";
    }

}
