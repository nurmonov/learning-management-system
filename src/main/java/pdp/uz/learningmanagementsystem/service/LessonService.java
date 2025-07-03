package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.CategoryDto;
import pdp.uz.learningmanagementsystem.dto.LessonDto;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

public interface LessonService {

    ApiResult<List<LessonDto>> getAllLessons();

    ApiResult<CategoryDto> getCategoryById(Integer id);

    ApiResult<LessonDto> createLesson(LessonDto lessonDto);

    ApiResult<Object> deleteLesson(Integer id);

    ApiResult<Object> updateLesson(Integer id,LessonDto lessonDto);





}
