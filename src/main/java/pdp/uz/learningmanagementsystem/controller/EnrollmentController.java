package pdp.uz.learningmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.learningmanagementsystem.dto.EnrollmentDto;
import pdp.uz.learningmanagementsystem.entity.Enrollment;
import pdp.uz.learningmanagementsystem.service.EnrollmentService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<ApiResult<List<EnrollmentDto>>> findEnrollment(){
        ApiResult<List<EnrollmentDto>> allEnrollment = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok(allEnrollment);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<EnrollmentDto>> findEnrollmentById(@PathVariable Integer id){
        ApiResult<EnrollmentDto> enrollmentById = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollmentById);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResult<EnrollmentDto>> addCourse(@RequestBody EnrollmentDto courseDto){
        ApiResult<EnrollmentDto> courseDtoApiResult = enrollmentService.addEnrollment(courseDto);
        return ResponseEntity.ok(courseDtoApiResult);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResult<Enrollment>> updateCourse(@PathVariable Integer id, @RequestBody EnrollmentDto courseDto){
        ApiResult<Enrollment> courseDtoApiResult = enrollmentService.updateEnrollment(id, courseDto);
        return ResponseEntity.ok(courseDtoApiResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResult<Object>> deleteCourse(@PathVariable Integer id){
        ApiResult<Object> objectApiResult = enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok(objectApiResult);
    }
}
