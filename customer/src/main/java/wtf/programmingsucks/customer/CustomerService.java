package wtf.programmingsucks.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wtf.programmingsucks.amqp.RabbitMQMessageProducer;
import wtf.programmingsucks.clients.fraud.FraudCheckResponse;
import wtf.programmingsucks.clients.fraud.FraudClient;
import wtf.programmingsucks.clients.notification.NotificationClient;
import wtf.programmingsucks.clients.notification.NotificationRequest;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        // todo: check if email is valid
        // todo: check if email is not taken

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster!");
        }

        // todo: make async
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to programming sucks!", customer.getFirstName()));

        producer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
