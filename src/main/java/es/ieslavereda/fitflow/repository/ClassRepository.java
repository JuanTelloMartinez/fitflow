package es.ieslavereda.fitflow.repository;

import es.ieslavereda.fitflow.model.entity.FitnessClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<FitnessClass, Long> {
}
