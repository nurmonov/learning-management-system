package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import pdp.uz.learningmanagementsystem.entity.enums.Role;

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
}
