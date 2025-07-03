package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.CourseDto;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

public interface CourseService {

    ApiResult<CourseDto> addCourse(CourseDto courseDto);

    ApiResult<Object> deleteCourse(Integer id);

    ApiResult<CourseDto> updateCourse(Integer id,CourseDto courseDto);

    ApiResult<List<CourseDto>> getAllCourses();

    ApiResult<CourseDto> getCourseById(Integer id);
}
