package wtf.programmingsucks.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient

@SpringBootApplication(
        scanBasePackages = {
                "wtf.programmingsucks.customer",
                "wtf.programmingsucks.amqp"

        }
)
@EnableFeignClients(
        basePackages = "wtf.programmingsucks.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
