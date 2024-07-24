package wtf.programmingsucks.notification;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import wtf.programmingsucks.amqp.RabbitMQMessageProducer;

@EnableFeignClients(
        basePackages = "wtf.programmingsucks.clients"
)
@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "wtf.programmingsucks.notification",
                "wtf.programmingsucks.amqp"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig config) {
//        return args -> {
//            producer.publish("foo", config.getInternalExchange(), config.getInternalNotificationRoutingKey());
//        };
//    }
}
