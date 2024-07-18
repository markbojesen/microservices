package wtf.programmingsucks.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wtf.programmingsucks.clients.fraud.FraudCheckResponse;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService service;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = service.isFraudulentCustomer(customerId);
        log.info("Fraud check request for customer {}", customerId);

        return ResponseEntity.status(HttpStatus.OK).body(new FraudCheckResponse(isFraudulentCustomer)) ;
    }
}
