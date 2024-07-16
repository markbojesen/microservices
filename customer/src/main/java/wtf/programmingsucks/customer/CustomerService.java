package wtf.programmingsucks.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repository) {

    public void registerCustomer(CustomerRegitrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email is not taken
        repository.save(customer);
    }
}
