package pdp.uz.learningmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.learningmanagementsystem.dto.LessonDto;
import pdp.uz.learningmanagementsystem.service.LessonService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;


    @GetMapping
    public ResponseEntity<ApiResult<List<LessonDto>>> getAllLessons(){
        ApiResult<List<LessonDto>> allLessons = lessonService.getAllLessons();
        return ResponseEntity.ok(allLessons);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<LessonDto>> findLessonById(@RequestParam Integer id){
        ApiResult<LessonDto> categoryById = lessonService.getCategoryById(id);
        return ResponseEntity.ok(categoryById);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResult<LessonDto>> createLesson(@RequestParam LessonDto lessonDto){
        ApiResult<LessonDto> lesson = lessonService.createLesson(lessonDto);
        return ResponseEntity.ok(lesson);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResult<Object>> updateLesson(@RequestParam Integer id, @RequestParam LessonDto lessonDto){
        ApiResult<Object> objectApiResult = lessonService.updateLesson(id, lessonDto);
        return ResponseEntity.ok(objectApiResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult<Object>> deleteLesson(@PathVariable Integer id){
        ApiResult<Object> objectApiResult = lessonService.deleteLesson(id);
        return ResponseEntity.ok(objectApiResult);
    }
}
