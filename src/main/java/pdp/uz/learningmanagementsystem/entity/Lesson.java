package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Lesson extends AbsIntegerEntity {

    private String lessonName;
    private String lessonContext;
    private Integer index;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Course course;

}
