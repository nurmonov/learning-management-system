package pdp.uz.learningmanagementsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.learningmanagementsystem.dto.CourseDto;
import pdp.uz.learningmanagementsystem.service.CourseService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResult<List<CourseDto>>> findAllCourse(){
        ApiResult<List<CourseDto>> allCourses = courseService.getAllCourses();
        return ResponseEntity.ok(allCourses);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<CourseDto>> findCourseById(@RequestParam Integer id){
        ApiResult<CourseDto> courseById = courseService.getCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResult<CourseDto>> addCourse(@RequestBody CourseDto courseDto){
        ApiResult<CourseDto> courseDtoApiResult = courseService.addCourse(courseDto);
        return ResponseEntity.ok(courseDtoApiResult);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResult<CourseDto>> updateCourse(@RequestParam Integer id,@RequestBody CourseDto courseDto){
        ApiResult<CourseDto> courseDtoApiResult = courseService.updateCourse(id, courseDto);
        return ResponseEntity.ok(courseDtoApiResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult<Object>> deleteCourse(@RequestParam Integer id){
        ApiResult<Object> objectApiResult = courseService.deleteCourse(id);
        return ResponseEntity.ok(objectApiResult);
    }
}
