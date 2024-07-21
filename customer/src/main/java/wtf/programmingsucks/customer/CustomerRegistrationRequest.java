package wtf.programmingsucks.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {}
