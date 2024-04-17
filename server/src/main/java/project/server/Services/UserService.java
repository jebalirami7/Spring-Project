package project.server.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.server.Entities.User;
import project.server.Repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

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
