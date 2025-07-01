package pdp.uz.learningmanagementsystem.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Category extends AbsIntegerEntity {

    @Column(nullable = false, unique = true)
    private String category;
}
