package wtf.programmingsucks.notification;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    private Integer notificationId;
    private Integer toCustomerId;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
