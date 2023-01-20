package task17_21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task17_21.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
