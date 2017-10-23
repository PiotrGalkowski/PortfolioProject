package pl.javaprogrammer.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String name, String phoneNumber, String mailFrom, String message){

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("piotrgalkowski81@gmail.com");
            helper.setFrom(new InternetAddress(mailFrom));
            helper.setSubject("Wiadomość od " + name + ".");
            helper.setText(message + "<br><br><br> Telefon: " + phoneNumber + "<br> E-mail: " + mailFrom, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}
