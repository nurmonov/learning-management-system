package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
