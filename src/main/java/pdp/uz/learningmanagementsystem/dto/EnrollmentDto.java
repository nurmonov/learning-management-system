package pdp.uz.learningmanagementsystem.dto;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDto {
    private Long id;
    private LocalDateTime enrolledAt;
    private Long userId;
    private Long courseId;
}

