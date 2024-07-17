package wtf.programmingsucks.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegitrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        repository.saveAndFlush(customer);

        // todo: check if email is valid
        // todo: check if email is not taken
        FraudCheckResponse response = restTemplate.getForObject("http://FRAUD:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster!");
        }

        // todo: send notification
    }
}
