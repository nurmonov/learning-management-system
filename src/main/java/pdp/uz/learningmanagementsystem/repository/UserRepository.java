package pdp.uz.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdp.uz.learningmanagementsystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
