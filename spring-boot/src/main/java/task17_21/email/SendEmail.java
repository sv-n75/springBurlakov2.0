package task17_21.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendEmail {


    private final JavaMailSender javaMailSender;

    public void sendEmail(String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("19svn75@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText(message);
        javaMailSender.send(msg);

    }
}
