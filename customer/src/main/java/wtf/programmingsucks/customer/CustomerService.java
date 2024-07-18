package wtf.programmingsucks.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wtf.programmingsucks.clients.fraud.FraudCheckResponse;
import wtf.programmingsucks.clients.fraud.FraudClient;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    
    public void registerCustomer(CustomerRegitrationRequest request) {
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

        // todo: send notification
    }
}
