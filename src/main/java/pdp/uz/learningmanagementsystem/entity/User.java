package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import pdp.uz.learningmanagementsystem.entity.enums.Role;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends AbsIntegerEntity  {


    private String username;
    private String email;
    private String password;
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
