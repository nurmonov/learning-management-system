package pdp.uz.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.learningmanagementsystem.dto.LessonDto;
import pdp.uz.learningmanagementsystem.entity.Lesson;
import pdp.uz.learningmanagementsystem.mapper.LessonMapper;
import pdp.uz.learningmanagementsystem.repository.LessonRepository;
import pdp.uz.learningmanagementsystem.service.LessonService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;


    @Override
    public ApiResult<List<LessonDto>> getAllLessons() {
        List<LessonDto> all = lessonRepository.findAll()
                .stream()
                .map(lessonMapper::lessonToLessonDto)
                .toList();
        return ApiResult.success(all);
    }

    @Override
    public ApiResult<LessonDto> getCategoryById(Integer id) {
        Optional<Lesson> byId = lessonRepository.findById(id);
        return byId
                .map(lesson -> ApiResult.success(lessonMapper.lessonToLessonDto(lesson)))
                .orElseGet(()->ApiResult.error("Lesson not found with id: " + id));

    }

    @Override
    @Transactional
    public ApiResult<LessonDto> createLesson(LessonDto lessonDto) {
        Lesson  lesson = lessonMapper.lessonDtoToLesson(lessonDto);
        lessonRepository.save(lesson);
        return ApiResult.success(lessonMapper.lessonToLessonDto(lesson));
    }

    @Override
    public ApiResult<Object> deleteLesson(Integer id) {
        Optional<Lesson> byId = lessonRepository.findById(id);
        if(byId.isPresent()) {
            lessonRepository.deleteById(id);
            return ApiResult.success("Lesson deleted successfully");
        }
        return ApiResult.error("Lesson not found with id: " + id);
    }

    @Override
    @Transactional
    public ApiResult<Object> updateLesson(Integer id, LessonDto lessonDto) {
        return lessonRepository.findById(id)
                .map(existing->{
                    lessonMapper.updateLessonFromDto(lessonDto,existing);
                    lessonRepository.save(existing);
                    return ApiResult.success("Lesson updated successfully");
                })
                .orElse(ApiResult.error("Lesson not found with id: " + id));

    }
}
