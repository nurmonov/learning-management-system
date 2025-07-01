package pdp.uz.learningmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.learningmanagementsystem.entity.enums.Role;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends AbsIntegerEntity  {


    private String username;
    private String email;
    private String password;
    private String profileImage;

    private Role role;
}
