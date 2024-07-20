package wtf.programmingsucks.clients.notification;

import lombok.ToString;

import java.time.LocalDateTime;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerEmail,
        String message) {
}
