package pdp.uz.learningmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pdp.uz.learningmanagementsystem.dto.CommentDto;
import pdp.uz.learningmanagementsystem.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentDtoToComment(CommentDto commentDto);
    CommentDto commentToCommentDto(Comment comment);

    void uptadeFromDto(CommentDto commentDto,@MappingTarget Comment existing);
}
