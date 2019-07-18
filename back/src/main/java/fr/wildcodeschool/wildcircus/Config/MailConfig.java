package fr.wildcodeschool.wildcircus.Config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private int mailPort;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Value("${spring.mail.password}")
    private String senderEmailPassword;

    @Value("${mail.transport.protocol}")
    private String protocolTransport;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean smtpAuthentication;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean smtpStartTls;

    @Value("${mail.debug}")
    private boolean debug;

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);

        mailSender.setUsername(senderEmail);
        mailSender.setPassword(senderEmailPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", protocolTransport);
        props.put("mail.smtp.auth", smtpAuthentication);
        props.put("mail.smtp.starttls.enable", smtpStartTls);
        props.put("mail.debug", debug);

        return mailSender;
    }

}