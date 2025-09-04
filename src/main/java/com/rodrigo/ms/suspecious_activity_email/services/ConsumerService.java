package com.rodrigo.ms.suspecious_activity_email.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    


    @KafkaListener(topics = "event_tickets", groupId = "suspicious_activity_group")
    public void consumerMessage(MessageEventDTO message){
        System.out.println("consuming message!");
        System.out.println(message);
    }
}
