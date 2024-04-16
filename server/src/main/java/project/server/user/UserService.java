package project.server.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

    public List<User> getUsers() {
		return userRepository.findAll();
	}

    public void createUser(User user) {
		// System.out.println(user);
		Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
		if (userOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		userRepository.save(user);
    }

    public void deleteUser(int userId) {
        boolean exists = userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("user with id " + userId + " does not exist");
		}
		userRepository.deleteById(userId);
    }

}
