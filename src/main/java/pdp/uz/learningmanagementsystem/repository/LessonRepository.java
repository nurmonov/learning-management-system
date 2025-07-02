package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.Lesson;

@Repository
public interface LessonRepository extends JpaRepositoryImplementation<Lesson,Integer> {
}
