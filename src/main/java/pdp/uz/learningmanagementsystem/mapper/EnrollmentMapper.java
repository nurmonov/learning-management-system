package pdp.uz.learningmanagementsystem.mapper;


import org.mapstruct.Mapper;
import pdp.uz.learningmanagementsystem.dto.EnrollmentDto;
import pdp.uz.learningmanagementsystem.entity.Enrollment;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    Enrollment enrollmentDtoToEnrollment(EnrollmentDto enrollmentDto);
    EnrollmentDto enrollmentToEnrollmentDto(Enrollment enrollment);
}
