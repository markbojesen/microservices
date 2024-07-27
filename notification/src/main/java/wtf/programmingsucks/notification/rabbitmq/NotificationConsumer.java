package wtf.programmingsucks.notification.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import wtf.programmingsucks.clients.notification.NotificationRequest;
import wtf.programmingsucks.notification.NotificationService;

@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from qeuue", notificationRequest.toString());

        notificationService.send(notificationRequest);
    }
}