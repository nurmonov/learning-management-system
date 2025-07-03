package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.CommentDto;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

public interface CommentService {

    ApiResult<CommentDto> createComment(CommentDto commentDto);

    ApiResult<Object> deleteComment(Integer id);

    ApiResult<CommentDto> updateComment(Integer id,CommentDto commentDto);

    ApiResult<List<CommentDto>> getAllComments();

    ApiResult<CommentDto> getCommentById(Integer id);

}
