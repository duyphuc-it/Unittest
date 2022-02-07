package vn.sapo.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorHistoryRepository extends JpaRepository<CalculatorHistory, Integer> {
}
