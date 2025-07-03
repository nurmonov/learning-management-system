package pdp.uz.learningmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pdp.uz.learningmanagementsystem.dto.CourseDto;
import pdp.uz.learningmanagementsystem.entity.Course;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course courseToCourseDto(CourseDto courseDto);
    CourseDto courseDtoToCourse(Course course);

    void updateFromDto(CourseDto courseDto,@MappingTarget Course existing);
}
