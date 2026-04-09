package es.ieslavereda.fitflow.repository;

import es.ieslavereda.fitflow.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
