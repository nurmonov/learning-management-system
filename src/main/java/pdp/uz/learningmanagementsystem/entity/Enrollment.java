package pdp.uz.learningmanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pdp.uz.learningmanagementsystem.entity.enums.EnrollmentStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment extends AbsIntegerEntity {

    @ManyToOne
    private Course course;

    @ManyToOne
    private User user;

    private Double progress;

    @CreationTimestamp
    private LocalDateTime enrolledAt;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status = EnrollmentStatus.ACTIVE;


}
