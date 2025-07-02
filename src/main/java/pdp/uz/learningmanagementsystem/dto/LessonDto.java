package pdp.uz.learningmanagementsystem.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {
    private Long id;
    private String title;
    private String content;
    private Integer orderIndex;
    private Long courseId;
}

