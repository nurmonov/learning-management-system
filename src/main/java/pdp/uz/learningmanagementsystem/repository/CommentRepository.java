package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
