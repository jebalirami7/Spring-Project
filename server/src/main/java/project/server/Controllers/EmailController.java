package project.server.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.server.Entities.EmailMessage;
import project.server.Services.Implementations.EmailSenderServiceImpl;

@RestController
@RequestMapping("/email")
public class EmailController {
    
    @Autowired
    private EmailSenderServiceImpl emailSenderService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailMessage emailMessage) {
        System.out.println(emailMessage);
        emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return "Email sent successfully";
    }

    @PostMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email) {
        return emailSenderService.resetPassword(email);
    }

}
