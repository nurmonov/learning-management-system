package pdp.uz.learningmanagementsystem.dto;


import lombok.*;
import pdp.uz.learningmanagementsystem.entity.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String profileImage;
    private Role role;
}

