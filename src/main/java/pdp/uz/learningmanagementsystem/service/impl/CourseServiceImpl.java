package pdp.uz.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.learningmanagementsystem.dto.CourseDto;
import pdp.uz.learningmanagementsystem.entity.Course;
import pdp.uz.learningmanagementsystem.mapper.CourseMapper;
import pdp.uz.learningmanagementsystem.repository.CourseRepository;
import pdp.uz.learningmanagementsystem.service.CourseService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    @Override
    @Transactional
    public ApiResult<CourseDto> addCourse(CourseDto courseDto) {
        Course course = courseMapper.courseToCourseDto(courseDto);
        courseRepository.save(course);
        return ApiResult.success(courseMapper.courseDtoToCourse(course));

    }

    @Override
    public ApiResult<Object> deleteCourse(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            courseRepository.deleteById(id);
            return ApiResult.success(course);
        }
        return ApiResult.error("Course not found with id: " + id);
    }

    @Override
    @Transactional
    public ApiResult<CourseDto> updateCourse(Integer id, CourseDto courseDto) {
        return courseRepository.findById(id)
                .map(existing->{
                    courseMapper.updateFromDto(courseDto,existing);
                    courseRepository.save(existing);
                    return ApiResult.success(courseMapper.courseDtoToCourse(existing));
                })
                .orElse(ApiResult.error("Course not found with id: " + id));
    }

    @Override
    public ApiResult<List<CourseDto>> getAllCourses() {
        List<CourseDto> courseDtos=courseRepository.findAll()
                .stream()
                .map(courseMapper::courseDtoToCourse).collect(Collectors.toList());
        return ApiResult.success(courseDtos);

    }

    @Override
    public ApiResult<CourseDto> getCourseById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
       return course
               .map(course1 -> ApiResult.success(courseMapper.courseDtoToCourse(course1)))
               .orElse(ApiResult.error("Course not found with id: " + id));
    }
}
