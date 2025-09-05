package com.rodrigo.ms.suspecious_activity_email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    

    @Autowired
    private JavaMailSender jMailSender;


    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("suport@suspicioustracker.com"); 
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        jMailSender.send(message);
    }
}
