package task_consolidation_of_skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task_consolidation_of_skills.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
