package pdp.uz.learningmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.learningmanagementsystem.dto.CommentDto;
import pdp.uz.learningmanagementsystem.service.CommentService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<CommentDto>> findByIdComments(@RequestParam Integer id){
        ApiResult<CommentDto> commentById = commentService.getCommentById(id);
        return ResponseEntity.ok(commentById);

    }

    @GetMapping
    public ResponseEntity<ApiResult<List<CommentDto>>> findAllComments(){
        ApiResult<List<CommentDto>> allComments = commentService.getAllComments();
        return ResponseEntity.ok(allComments);

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResult<CommentDto>> createComment(@RequestBody CommentDto commentDto){
        ApiResult<CommentDto> comment = commentService.createComment(commentDto);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResult<CommentDto>> updateComment(@RequestParam Integer id, @RequestBody CommentDto commentDto){
        ApiResult<CommentDto> commentDtoApiResult = commentService.updateComment(id, commentDto);
        return ResponseEntity.ok(commentDtoApiResult);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult<Object>> deleteComment(@RequestParam Integer id){
        ApiResult<Object> objectApiResult = commentService.deleteComment(id);
        return ResponseEntity.ok(objectApiResult);
    }

}
