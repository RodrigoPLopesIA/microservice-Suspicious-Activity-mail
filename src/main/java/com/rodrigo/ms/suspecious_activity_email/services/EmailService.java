package com.rodrigo.ms.suspecious_activity_email.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rodrigo.ms.suspecious_activity_email.dto.ResponseSuspiciousActivityDTO;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender jMailSender;

   

    public void sendSuspiciousActivityAlert(String to, ResponseSuspiciousActivityDTO payload) throws MessagingException {
        MimeMessage message = jMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("suport@suspicioustracker.com");
        helper.setTo(to);
        helper.setSubject("⚠️ Alerta de Atividade Suspeita Detectada!");

        String htmlContent = """
            <html>
            <body style="font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;">
                <div style="max-width: 600px; margin: auto; background-color: #fff; border-radius: 8px; padding: 20px; border: 1px solid #ddd;">
                    <h2 style="color: #d9534f;">⚠️ Suspicious Activity Alert</h2>
                    <p>We have detected suspicious activity associated with your account:</p>
                    <ul>
                        <li><b>Activity ID:</b> %s</li>
                        <li><b>User ID:</b> %s</li>
                        <li><b>Endpoint:</b> %s</li>
                        <li><b>IP:</b> %s</li>
                        <li><b>Description:</b> %s</li>
                        <li><b>Created at:</b> %s</li>
                        <li><b>Updated at:</b> %s</li>
                    </ul>
                    <p style="color: #d9534f; font-weight: bold;">If you do not recognize this activity, please contact support immediately.</p>
                </div>
            </body>
            </html>
        """.formatted(
            payload.id(),
            payload.userId(),
            payload.endpoint(),
            payload.ipAddress(),
            payload.description(),
            payload.createdAt(),
            payload.updatedAt()
        );

        helper.setText(htmlContent, true); 

        jMailSender.send(message);
    }
}
