package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course extends AbsIntegerEntity {

    private String title;
    private String description;
    private String category;
    private String duration;
    private Integer studentCount;
    private Integer price;
    private String image;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User teacher;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

}
