package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbsIntegerEntity{
    @Column(columnDefinition = "TEXT")
    private String comment;

    private Integer rating;

    @ManyToOne
    private User author;

    @ManyToOne
    private Course course;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
