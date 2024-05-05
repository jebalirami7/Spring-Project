package project.server.Services.Implementations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import project.server.Entities.User;
import project.server.Repositories.UserRepo;
import project.server.Services.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        this.mailSender.send(simpleMailMessage);
    }

    public String resetPassword(String email) {
        User user = userRepo.findUserByEmail(email).orElse(null);
        if (user == null) {
            return "User not found";
        }
        SecureRandom random = new SecureRandom();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder newPassword = new StringBuilder();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            newPassword.append(characters.charAt(index));
        }

        String message = "Your new password is: " + newPassword.toString();
        sendEmail(email, "Reset Your Password", message);

        userRepo.updatePassword(email, encoder.encode(newPassword.toString()));
        return "Email sent successfully";
    }

}