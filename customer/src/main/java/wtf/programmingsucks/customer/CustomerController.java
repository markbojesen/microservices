package wtf.programmingsucks.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("New customer registration: {}", customerRegistrationRequest.toString());
        customerService.registerCustomer(customerRegistrationRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
