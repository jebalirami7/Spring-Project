package project.server.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

	@GetMapping
	public List<User> getTuteurs() {
		return userService.getUsers();
	}

    @PostMapping    
    public void createTuteur(@RequestBody User tuteur) {
        userService.createUser(tuteur);
    }

    @DeleteMapping(path = "{tuteurId}")
    public void deleteTuteur(@PathVariable("tuteurId") int tuteurId) {
        userService.deleteUser(tuteurId);
    }

}
