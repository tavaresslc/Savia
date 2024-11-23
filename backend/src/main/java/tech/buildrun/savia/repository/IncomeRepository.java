package tech.buildrun.savia.repository;

import java.util.UUID;

import tech.buildrun.savia.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, UUID> {
}

