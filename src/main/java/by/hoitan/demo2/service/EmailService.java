package by.hoitan.demo2.service;

import ch.qos.logback.core.net.LoginAuthenticator;
import com.sun.mail.util.logging.MailHandler;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private final JavaMailSender mailSender;

    @Value(value = "${spring.mail.username}")
    private  String from;
    @Value(value = "${spring.mail.host}")
    private  String host;
    @Value(value = "${spring.mail.port}")
    private  String port;


    public void sendEmail(String email) {
        var simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setText("Hello");
        simpleMailMessage.setSubject("Tema");

//        mailSender.send(simpleMailMessage);





        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        StringBuilder stringBuilder = new StringBuilder();

        Session session = getSession("pavel.hoitan@mail.ru", "474WxhNSebnDWC1rm46g");

        MimeMessage mimeMessage = new MimeMessage(session);


        String n = """
                3456678
                """;

        try {

                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            stringBuilder.append("<pre>");
            stringBuilder.append("message");
            stringBuilder.append(n);
            stringBuilder.append("<pre>");
            mimeMessage.setContent(stringBuilder.toString(), "text/html; charset=utf-8");
            mimeMessage.setFrom(from);
            mimeMessage.setSubject("refuseSubject");
            Transport.send(mimeMessage);
//            Transport.send(mimeMessage, "pavel.goitan@gmail.com", "qtiabvuxiywzuzyw");
            Transport.send(mimeMessage, "3160398@gmail.com", "txtbvmibfvsjziqd");
            mailSender.send(mimeMessage);



        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    private Session getSession(String username, String password) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");


//        Authenticator authenticator = new Authenticator(){
//            private PasswordAuthentication authentication;
//            {
//                authentication = new PasswordAuthentication(username, password);
//            }
//
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return authentication;
//            }
//        };

        return Session.getInstance(properties, new Auth(username, password));
    }
}
