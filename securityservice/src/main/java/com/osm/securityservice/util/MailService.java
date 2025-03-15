package com.osm.securityservice.util;


import com.osm.securityservice.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Sends an email with the password setup link.
     * @param user the user to whom the email will be sent.
     * @param token the generated password reset token.
     */
    public void sendPasswordSetupEmail(User user, String token) {
        String subject = "Set Your Password";
        String content = "Click the link below to set your password:\n"
                + "https://localhost:4200/api/security/set-password?token=" + token;

        try {
            MimeMessageHelper message = new MimeMessageHelper(javaMailSender.createMimeMessage());
            message.setFrom(from);
            message.setTo(user.getEmail());
            message.setSubject(subject);
            message.setText(content);
            javaMailSender.send(message.getMimeMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error sending password setup email", e);
        }
    }
}