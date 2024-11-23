package tech.buildrun.savia.repository;

import java.util.UUID;

import tech.buildrun.savia.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}
