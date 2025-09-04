package com.rodrigo.ms.suspecious_activity_email.dto;

import java.time.Instant;
import java.util.UUID;

import com.rodrigo.ms.suspecious_activity_email.enums.EventType;

public record MessageEventDTO(UUID id, Instant timestamp, EventType eventType, ResponseSuspiciousActivityDTO payload) {
    
}
