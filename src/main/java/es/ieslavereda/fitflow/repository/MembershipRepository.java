package es.ieslavereda.fitflow.repository;

import es.ieslavereda.fitflow.model.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
