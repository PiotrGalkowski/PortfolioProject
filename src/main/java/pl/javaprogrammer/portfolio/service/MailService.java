package pl.javaprogrammer.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.javaprogrammer.portfolio.form.ContactForm;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(ContactForm contactForm){

        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("piotrgalkowski81@gmail.com");
            helper.setFrom(new InternetAddress(contactForm.getEmail()));
            helper.setSubject("Wiadomość od " + contactForm.getName() + ".");
            helper.setText(contactForm.getMessage() + "<br><br><br> Telefon: " + contactForm.getPhoneNumber() + "<br> E-mail: " + contactForm.getEmail(), true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}
