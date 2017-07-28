package me.amolgupta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * Created by amolg on 6/27/2017.
 * Email feature to send email in case of any
 * High alerts are encountered for any readings
 * received.
 */

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSenderImpl emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

}
