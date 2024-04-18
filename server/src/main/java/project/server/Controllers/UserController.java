package project.server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.server.Entities.User;
import project.server.Services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping    
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(path = "{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

}
