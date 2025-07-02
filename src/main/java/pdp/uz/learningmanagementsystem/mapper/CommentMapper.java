package pdp.uz.learningmanagementsystem.mapper;

import org.mapstruct.Mapper;
import pdp.uz.learningmanagementsystem.dto.CommentDto;
import pdp.uz.learningmanagementsystem.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentDtoToComment(CommentDto commentDto);
    CommentDto commentToCommentDto(Comment comment);
}
