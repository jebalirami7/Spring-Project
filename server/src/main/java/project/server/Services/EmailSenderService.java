package project.server.Services;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
