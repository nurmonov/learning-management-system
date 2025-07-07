package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.EnrollmentDto;
import pdp.uz.learningmanagementsystem.entity.Enrollment;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

public interface EnrollmentService {

   ApiResult<EnrollmentDto> addEnrollment(EnrollmentDto enrollmentDto);

   ApiResult<Object> deleteEnrollment(Integer id);

   ApiResult<Enrollment> updateEnrollment(Integer id, EnrollmentDto enrollmentDto);

   ApiResult<List<EnrollmentDto>> getAllEnrollment();

   ApiResult<EnrollmentDto> getEnrollmentById(Integer id);
}
