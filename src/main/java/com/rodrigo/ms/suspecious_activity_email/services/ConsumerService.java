package com.rodrigo.ms.suspecious_activity_email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rodrigo.ms.suspecious_activity_email.dto.MessageEventDTO;

@Service
public class ConsumerService {
    
    @Autowired
    private EmailService emailService;  
    

    @KafkaListener(topics = "suspicious_activity_email_event", groupId = "suspicious_activity_group", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consumerMessage(MessageEventDTO message) throws Exception{
        
        emailService.sendSuspiciousActivityAlert("rodrigo.plopesti@gmail.com", message.payload());
    }
}
