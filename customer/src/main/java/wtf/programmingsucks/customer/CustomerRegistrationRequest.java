package wtf.programmingsucks.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
    @Override
    public String toString() {
        return String.format("CustomerRegistrationRequest { firstName = '%s', lastName = '%s', email = '%s' }",
                firstName, lastName, email);
    }
}
