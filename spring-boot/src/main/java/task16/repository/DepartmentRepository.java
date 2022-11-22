package task16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task16.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
