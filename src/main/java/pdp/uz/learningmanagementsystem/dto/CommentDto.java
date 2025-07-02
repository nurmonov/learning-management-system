package pdp.uz.learningmanagementsystem.dto;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String comment;
    private Integer rating;
    private LocalDateTime createdAt;
    private Long authorId;
    private Long courseId;
}

