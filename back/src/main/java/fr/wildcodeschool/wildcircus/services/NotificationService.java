package fr.wildcodeschool.wildcircus.services;

import fr.wildcodeschool.wildcircus.entities.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class NotificationService {

    @Value("${mail.receiving.user}")
    private String receivingUser;

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(UserMessage user) throws MailException {

        // Send Email
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(receivingUser);
        mail.setSubject(user.getSubject());
        mail.setText("Nom : "+user.getLastname()+"\n"+"Prénom : "+user.getFirstname()+
                "\n"+"Téléphone : "+user.getPhone()+"\n"+
                "Email : "+user.getEmail()+"\n"+
                "\n"+user.getMessage()+"\n");
        javaMailSender.send(mail);


    }

}
