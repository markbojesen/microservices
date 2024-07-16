package wtf.programmingsucks.customer;

public record CustomerRegitrationRequest(
        String firstName,
        String lastName,
        String email
) {}
