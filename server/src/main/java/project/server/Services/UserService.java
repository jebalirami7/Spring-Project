package project.server.Services;

import project.server.Entities.User;
import project.server.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo repository;

    public User addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }
    public User getUserById(int userId) {
        return repository.findById(userId).orElse(null);
    }

    public Optional<User> getUser(int id) {
        Optional<User> user = repository.findById(id);
        user.ifPresent(value -> value.setPassword(null));
        return user;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(int id, User user) {
        User userToUpdate = repository.findById(id).orElse(null);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userToUpdate != null) {
            if (user.getFirstName() != null)
                userToUpdate.setFirstName(user.getFirstName());
            if (user.getLastName() != null)
                userToUpdate.setLastName(user.getLastName());
            if (user.getImagePath() != null)
                userToUpdate.setImagePath(user.getImagePath());
            if (user.getPassword() != "")
                userToUpdate.setPassword(encoder.encode(user.getPassword()));
            repository.save(userToUpdate); 
            userToUpdate.setPassword(null);
            return userToUpdate;
        }
        return null;
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = repository.findByUsername(username);
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

}
