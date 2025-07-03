package pdp.uz.learningmanagementsystem.service;

import pdp.uz.learningmanagementsystem.dto.EnrollmentDto;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;

public interface EnrollmentService {

   ApiResult<EnrollmentDto> addEnrollment(EnrollmentDto enrollmentDto);

   ApiResult<Object> deleteEnrollment(Integer id);

   ApiResult<EnrollmentDto> updateEnrollment(Integer id,EnrollmentDto enrollmentDto);

   ApiResult<List<EnrollmentDto>> getEnrollment();

   ApiResult<EnrollmentDto> getEnrollmentById(Integer id);
}
