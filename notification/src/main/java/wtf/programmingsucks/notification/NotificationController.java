package wtf.programmingsucks.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wtf.programmingsucks.clients.notification.NotificationRequest;

@Slf4j
@RestController
@AllArgsConstructor
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    public ResponseEntity<NotificationRequest> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification sent: {}", notificationRequest);
        service.send(notificationRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
