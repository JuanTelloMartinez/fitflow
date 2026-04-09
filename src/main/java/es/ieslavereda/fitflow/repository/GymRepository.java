package es.ieslavereda.fitflow.repository;

import es.ieslavereda.fitflow.model.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
