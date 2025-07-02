package pdp.uz.learningmanagementsystem.dto;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String category;
    private LocalDateTime createdAt;
    private Long teacherId; // user id (teacher)
}

