package tech.buildrun.savia.repository;

import java.util.UUID;

import tech.buildrun.savia.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
