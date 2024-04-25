package project.server.Controllers;

import project.server.Entities.AuthRequest;
import project.server.Entities.User;
import project.server.Services.JwtService;
import project.server.Services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/")
    public User addNewUser(@RequestBody User userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/user/{id}/profile")
    public String userProfile(@PathVariable("id") int id){
        return "Welcome to User Profile" + id  ;
    }


    @PostMapping("/login")
    public Map<String, String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(authRequest.getUsername());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authorizationHeader) {
        String username = null;
        String refreshToken = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            refreshToken = authorizationHeader.substring(7);
            try {
                username = jwtService.extractUsername(refreshToken);
            } catch (ExpiredJwtException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Refresh token expired");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid refresh token");
            }
        }
        
        if (username != null && refreshToken != null ) {
            UserDetails userDetails = service.loadUserByUsername(username);
            
            if (jwtService.validateToken(refreshToken, userDetails)) {
                String newAccessToken = jwtService.generateToken(userDetails.getUsername());
                Map<String, String> response = new HashMap<>();
                response.put("token", newAccessToken);
                
                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

}
