package pdp.uz.learningmanagementsystem.mapper;


import org.mapstruct.Mapper;
import pdp.uz.learningmanagementsystem.dto.UserDto;
import pdp.uz.learningmanagementsystem.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
