package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
