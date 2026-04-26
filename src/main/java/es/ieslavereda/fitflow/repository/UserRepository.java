package es.ieslavereda.fitflow.repository;

import es.ieslavereda.fitflow.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
