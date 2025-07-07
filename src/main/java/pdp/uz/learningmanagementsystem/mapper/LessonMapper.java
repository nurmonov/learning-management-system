package pdp.uz.learningmanagementsystem.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pdp.uz.learningmanagementsystem.dto.LessonDto;
import pdp.uz.learningmanagementsystem.entity.Lesson;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    Lesson lessonDtoToLesson(LessonDto lessonDto);
    LessonDto lessonToLessonDto(Lesson lesson);

    void updateLessonFromDto(LessonDto lessonDto, @MappingTarget Lesson existing);
}
