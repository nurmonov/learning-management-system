package pdp.uz.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.learningmanagementsystem.dto.CommentDto;
import pdp.uz.learningmanagementsystem.entity.Comment;
import pdp.uz.learningmanagementsystem.mapper.CommentMapper;
import pdp.uz.learningmanagementsystem.repository.CommentRepository;
import pdp.uz.learningmanagementsystem.service.CommentService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    @Override
    @Transactional
    public ApiResult<CommentDto> createComment(CommentDto commentDto) {
        Comment comment=commentMapper.commentDtoToComment(commentDto);
        commentRepository.save(comment);
        return ApiResult.success(commentMapper.commentToCommentDto(comment));

    }

    @Override
    public ApiResult<Object> deleteComment(Integer id) {
        Optional<Comment> comment=commentRepository.findById(id);
        if(comment.isPresent()){
            commentRepository.deleteById(id);
            return ApiResult.success(commentMapper.commentToCommentDto(comment.get()));
        }
        return ApiResult.error("Comment not found with id: " + id);
    }

    @Override
    @Transactional
    public ApiResult<CommentDto> updateComment(Integer id, CommentDto commentDto) {
        return  commentRepository.findById(id)
                .map(existing->{
                    commentMapper.uptadeFromDto(commentDto,existing);
                    commentRepository.save(existing);
                    return ApiResult.success("Comment updated successfully",
                            commentMapper.commentToCommentDto(existing));
                })
                .orElseGet(()->ApiResult.error("Commentary not found "+id));

    }

    @Override
    public ApiResult<List<CommentDto>> getAllComments() {
        List<CommentDto> comments=commentRepository.findAll()
                .stream()
                .map(commentMapper::commentToCommentDto)
                .toList();
        return ApiResult.success(comments);

    }

    @Override
    public ApiResult<CommentDto> getCommentById(Integer id) {
        Optional<Comment> comment=commentRepository.findById(id);
        if(comment.isPresent()){
            return ApiResult.success(commentMapper.commentToCommentDto(comment.get()));
        }
        return ApiResult.error("Comment not found with id: " + id);
    }
}
