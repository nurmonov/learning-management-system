package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.Enrollment;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

}
