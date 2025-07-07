package pdp.uz.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdp.uz.learningmanagementsystem.dto.EnrollmentDto;
import pdp.uz.learningmanagementsystem.entity.Enrollment;
import pdp.uz.learningmanagementsystem.mapper.EnrollmentMapper;
import pdp.uz.learningmanagementsystem.repository.EnrollmentRepository;
import pdp.uz.learningmanagementsystem.service.EnrollmentService;
import pdp.uz.learningmanagementsystem.utill.ApiResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentMapper enrollmentMapper;
    private final EnrollmentRepository enrollmentRepository;


    @Override
    @Transactional
    public ApiResult<EnrollmentDto> addEnrollment(EnrollmentDto enrollmentDto) {
        Enrollment enrollment=enrollmentMapper.enrollmentDtoToEnrollment(enrollmentDto);
        enrollmentRepository.save(enrollment);
        return ApiResult.success(enrollmentMapper.enrollmentToEnrollmentDto(enrollment));
    }

    @Override
    public ApiResult<Object> deleteEnrollment(Integer id) {
        Optional<Enrollment> enrollment=enrollmentRepository.findById(id);
        if(enrollment.isPresent()) {
            enrollmentRepository.deleteById(id);
            return ApiResult.success(enrollment.get());
        }
        return ApiResult.error("Enrollment not found with id: " + id);
    }

    @Override
    @Transactional
    public ApiResult<Enrollment> updateEnrollment(Integer id, EnrollmentDto enrollmentDto) {
        return enrollmentRepository.findById(id)
                .map(existing->{
                    enrollmentMapper.uptadeFromDto(enrollmentDto,existing);
                    enrollmentRepository.save(existing);
                    return ApiResult.success(existing);
                })
                .orElse(ApiResult.error("Enrollment not found with id: " + id));
    }

    @Override
    public ApiResult<List<EnrollmentDto>> getAllEnrollment() {
        List<EnrollmentDto> enrollments=enrollmentRepository.findAll()
                .stream().map(enrollmentMapper::enrollmentToEnrollmentDto).collect(Collectors.toList());
       return ApiResult.success(enrollments);
    }

    @Override
    public ApiResult<EnrollmentDto> getEnrollmentById(Integer id) {
        Optional<Enrollment> enrollment=enrollmentRepository.findById(id);
        return enrollment
                .map(enrollment1 -> ApiResult.success(enrollmentMapper.enrollmentToEnrollmentDto(enrollment1)))
                .orElse(ApiResult.error("Enrollment not found with id: " + id));
    }
}
