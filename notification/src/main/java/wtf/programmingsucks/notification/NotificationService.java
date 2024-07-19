package wtf.programmingsucks.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wtf.programmingsucks.clients.notification.NotificationRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public void send(NotificationRequest notificationRequest) {
        repository.save(
                Notification.builder()
                        .toCustomer(notificationRequest.toCustomer())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .sender("programming sucks wtf")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        )
    }
}
